import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JwtService {

  private tokenKey: string = 'token';

  constructor() { }

  // Méthode pour obtenir le JWT depuis le localStorage
  getToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }

  isConnected(): boolean {
    if (!localStorage.getItem(this.tokenKey)){
      return false;
    } else {
      return true;
    }
  }

  // Méthode pour décoder le JWT
  decodeToken(token: string): any {
    if (!token) {
      return null;
    }
    const payload = token.split('.')[1];
    return JSON.parse(atob(payload));
  }

  // Méthode pour obtenir les données utilisateur depuis le JWT
  getUserData(): any {
    const token = this.getToken();
    if (token) {
      return this.decodeToken(token);
    }
    return null;
  }

  isAdmin() : boolean {
    const token = this.getToken();
    let data :any;
    if (token) {
      data = this.decodeToken(token);
      if (data.userRole ==="ADMIN")
        return true
    }
    
    return false;
    }

    isUser() : boolean {
      const token = this.getToken();
      let data :any;
      if (token) {
        data = this.decodeToken(token);
        if (data.userRole ==="UTILISATEUR")
          return true
      }
      
      return false;
      }

  // Méthode pour sauvegarder le token dans le localStorage
  saveToken(token: string): void {
    localStorage.setItem(this.tokenKey, token);
  }

  // Méthode pour supprimer le token du localStorage
  removeToken(): void {
    localStorage.removeItem(this.tokenKey);
  }

}
