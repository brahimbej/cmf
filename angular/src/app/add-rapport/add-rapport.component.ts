import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { RapportService } from '../services/rapport.service';

@Component({
  selector: 'app-add-rapport',
  templateUrl: './add-rapport.component.html',
  styleUrl: './add-rapport.component.css'
})
export class AddRapportComponent {
  FormInput!:FormGroup;
  errormsg:String=""
   
  constructor(private FB:FormBuilder, private rapportService:RapportService, private route: Router){

  }
  ngOnInit(): void {
    this.FormInput = this.FB.group({
      
      incident:['',[Validators.required]],
      description:['',[Validators.required]],
      
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

    this.rapportService.addRapport(this.FormInput.value).subscribe(
      (response: any) => {
        console.log('success:', response);
        
      
              this.route.navigate(['/dashboard']); // Utiliser la route admin appropriée
            }, (error : any) => {
              console.log('error:', error);
            }
        
      
    );
  }
}
