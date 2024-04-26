import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  FormInput!:FormGroup;
  errormsg:String=""
   
  constructor(private FB:FormBuilder, private authService:AuthService, private route: Router){

  }
  ngOnInit(): void {
    this.FormInput = this.FB.group({
      
      email:['',[Validators.required,Validators.email]],
      
      password: ['', [
        Validators.required,
        // Complexité
      ]]
    }) 
      
  }

  login() {
    // Afficher les informations du formulaire dans la console
    console.log("Form input:", this.FormInput.value);
  
    // Appeler le service de connexion
    this.authService.login(this.FormInput.value).subscribe(
      (response: any) => {
        console.log('success:', response);
            localStorage.setItem('token',response.jwt)
      
              this.route.navigate(['/dashboard']); // Utiliser la route admin appropriée
            }, (error : any) => {
              console.log('error:', error);
              this.errormsg = "verifier votre email ou password"
            }
        
      
    );
  }
  
}
