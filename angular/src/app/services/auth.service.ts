import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  // public loggedInStatus = new BehaviorSubject<boolean>(false);
  // public loggedIn = this.loggedInStatus.asObservable();

  public LoggedIn:boolean=false;


  UserUrl:string  = " http://localhost:3000/api/auth"


  constructor(private httpclient: HttpClient) { }

  login(obj:any): Observable<{ msg: string}> {
    console.log(obj)
    return this.httpclient.post<{ msg: string }>(`${this.UserUrl}/login`, obj);
  }

  setloggedIn(status:boolean) {
    this.LoggedIn=status;
  }

  isLoggedIn() {
    return this.LoggedIn;
  }

}
