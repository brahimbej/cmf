import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  UserUrl:string  = " http://localhost:3000/api/auth"


  constructor(private httpclient: HttpClient) { }

  login(obj:any): Observable<{ msg: string}> {
    console.log(obj)
    return this.httpclient.post<{ msg: string }>(`${this.UserUrl}/login`, obj);
  }

}
