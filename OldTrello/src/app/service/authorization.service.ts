import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationService {
  constructor(private http: HttpClient) { }

  private loginUrl = '/api';

  private authData(username: string, password: string){
    return window.btoa(username + ":" + password);
  }


  login(username: string, password: string){
    let myHeaders = new HttpHeaders().set('authorization', `Basic ${this.authData(username, password)}`);
    return this.http.post<any>(`${this.loginUrl}/login`,"",
      {headers: myHeaders})
      .pipe(
        map(user => {
          if (user) {
            localStorage.setItem("isLoggedIn", "true");
            localStorage.setItem("Theme", user.details.theme);
            localStorage.setItem("UserId", user.details.id);
            localStorage.setItem("Username", user.details.username);
        }
        return user;
        })
    );
  }

  logout(){
    let myHeaders = new HttpHeaders().set('content-type','application/json');
    return this.http.post<any>(`${this.loginUrl}/logout`, null,
    {headers: myHeaders}).pipe();
  }

  checkLogin(){
    return this.http.get<boolean>(`${this.loginUrl}/checkLogin`).pipe();
  }
}
