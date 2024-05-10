import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiServerUrl = "http://localhost:3000/api";

  constructor(private http: HttpClient){}

  public getUsers(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiServerUrl}/user/all`);
  }

  public addUser(user: any): Observable<any> {
    return this.http.post<any>(`${this.apiServerUrl}/user/add`, user);
  }

  public updateUser(user: any): Observable<any> {
    return this.http.put<any>(`${this.apiServerUrl}/user/update/${user.id}`, user);
  }

  public deleteUser(userId: number): Observable<void> {
    console.log(userId)
    return this.http.delete<void>(`${this.apiServerUrl}/user/delete/${userId}`);
  }
}
