import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { RapportService } from '../services/rapport.service';
import { IncidentService } from '../services/incident.service';

@Component({
  selector: 'app-add-rapport',
  templateUrl: './add-rapport.component.html',
  styleUrl: './add-rapport.component.css'
})
export class AddRapportComponent {
  FormInput!:FormGroup;
  errormsg:String="";
  listIncidents!:any[];
  selectedItemId: any;
   
  constructor(private FB:FormBuilder, private rapportService:RapportService, private route: Router,private incidentService : IncidentService){
     // Default to the first item
  }


  onSelectionChange(event: any) {
    this.selectedItemId = event.target.value;
    console.log('Selected item ID:', this.selectedItemId);
  }
  
  ngOnInit(): void {
    this.FormInput = this.FB.group({
      
      incidentId:['',[Validators.required]],
      description:['',[Validators.required]],
      
    }) 

    this.FormInput.get('incidentId')!.valueChanges.subscribe(selectedValue => {
      console.log('Selected incident ID:', selectedValue);
    });

    this.incidentService.getAllIncidents().subscribe(
      (response : any) => {
        console.log(response);
        this.listIncidents= response;
        this.selectedItemId = this.listIncidents[0].id;
      }
    )
      
  }

  submit() {
    // Afficher les informations du formulaire dans la console
    console.log("Form input:", this.FormInput.value);
  // const rapport = {
  //   incident : {
  //     id : this.FormInput.value.incident
  //   },
  //   description : this.FormInput.value.description
  // }

  // console.log(rapport)
    
console.log(this.FormInput.value)

    this.rapportService.addRapport(this.FormInput.value).subscribe(
      (response: any) => {
        console.log('success:', response);
        
      
              this.route.navigate(['/listrapport']); // Utiliser la route admin appropriée
            }, (error : any) => {
              console.log('error:', error);
            }
        
      
    );
  }
}
