import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { IncidentService } from '../services/incident.service';
import { JwtService } from '../services/jwt.service';

@Component({
  selector: 'app-ajout-incident-form',
  templateUrl: './ajout-incident-form.component.html',
  styleUrl: './ajout-incident-form.component.css'
})
export class AjoutIncidentFormComponent {

  FormInput!:FormGroup;
  errormsg:String="";
  message!:any;
  error!:any;
  
   
  constructor(private FB:FormBuilder, private incidentService:IncidentService, private route: Router, private jwtService : JwtService){

  }
  ngOnInit(): void {
    this.FormInput = this.FB.group({
      
      incident:['',[Validators.required]],
      type:['',[Validators.required]],
      
      priorite: ['', [
        Validators.required,
        // Complexité
      ]]
    }) 
      
  }

  submit() {
    // Afficher les informations du formulaire dans la console
    console.log("Form input:", this.FormInput.value);
  
    // Appeler le service de connexion
    const currentDate: Date = new Date();
const dateString: string = currentDate.toLocaleDateString();
const formattedDate = dateString.toLocaleString();
this.FormInput.value.echeance = formattedDate;

    this.incidentService.addIncident(this.FormInput.value).subscribe(
      (response: any) => {
        console.log('success:', response);
            if (this.jwtService.isAdmin())
              this.route.navigate(['/dashboard']);
            this.error="";
            this.message="l'incident est ajouté";

               // Utiliser la route admin appropriée
            }, (error : any) => {
              this.message="";
              this.error="l'incident n'est pas ajouté";
              console.log('error:', error);
            }
        
      
    );
  }

  ajoutMail() {

  }

}
