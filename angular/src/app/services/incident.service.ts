import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IncidentService {

  IncidentUrl:string  = " http://localhost:3000/api/incident"

   httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('token') // Assuming you're storing JWT token in localStorage
    })
  };


  constructor(private httpclient: HttpClient) { }

  addIncident(obj:any): Observable<{ incident: any}> {
        console.log(localStorage.getItem('token'))
    return this.httpclient.post<{ incident: any }>(`${this.IncidentUrl}/`, obj, this.httpOptions);
  }

  deleteIncident(id:any): Observable<{ id: any}> {
    return this.httpclient.delete<{ id: any }>(`${this.IncidentUrl}/delete/${id}`, this.httpOptions);
}

updateIncident(obj:any): Observable<{ id: any}> {
  return this.httpclient.put<{ id: any }>(`${this.IncidentUrl}/update/${obj.id}`,obj, this.httpOptions);
}

  getAllIncidents(): Observable<{ incidents: any}> {
    return this.httpclient.get<{ incidents: any }>(`${this.IncidentUrl}/getAll`, this.httpOptions);
  }
}
