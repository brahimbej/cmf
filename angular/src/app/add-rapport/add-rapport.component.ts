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
  const rapport = {
    incident : {
      id : this.FormInput.value.incident
    },
    description : this.FormInput.value.description
  }

  console.log(rapport)
    
console.log(this.FormInput.value)

    this.rapportService.addRapport(rapport).subscribe(
      (response: any) => {
        console.log('success:', response);
        
      
              this.route.navigate(['/listrapport']); // Utiliser la route admin appropriée
            }, (error : any) => {
              console.log('error:', error);
            }
        
      
    );
  }
}
