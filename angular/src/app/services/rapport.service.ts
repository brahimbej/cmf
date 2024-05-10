import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RapportService {

  rapportUrl:string  = "http://localhost:3000/api/rapport"

   httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token') // Assuming you're storing JWT token in localStorage
    })
  };

  constructor(private httpclient: HttpClient) { }

  // addRapport(obj:any): Observable<{ rapport: any}> {

  //     console.log(localStorage.getItem('token'))
  //     console.log(obj)
  // return this.httpclient.post<{ rapport: any }>(`${this.rapportUrl}/ajout`, obj, this.httpOptions);

  // }

  addRapport(obj:any): Observable<{ incident: any}> {
return this.httpclient.post<{ incident: any }>(`${this.rapportUrl}/ajout`, obj, this.httpOptions);
}

  getAllRapports(): Observable<any> {
    return this.httpclient.get<any>(`${this.rapportUrl}/getAll`, this.httpOptions);
  }
}
