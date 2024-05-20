import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'BrahimAngular';
  isLoggedIn!: boolean;

  isExpanded: boolean = false;

  ngOnInit() {
    // this.authService.loggedIn.subscribe(status => {
    //   console.log(status)
    //   this.isLoggedIn = status;
    // });
  }


  toggleSidebar() {
    this.isExpanded = !this.isExpanded;
  }
  Logout() {
      this.authService.setloggedIn(false);
      localStorage.removeItem('token');
      this.router.navigate(['login']);
    
  }
  constructor(private http: HttpClient, private router: Router,public authService : AuthService) {}

}
