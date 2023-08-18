import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ThemeServiceService {

  private themeUrl = '/api/theme';
  constructor(private http: HttpClient){}

  getTheme(): Observable<any>{
    return this.http.get<any>(`${this.themeUrl}/getTheme/`).pipe();
  }

  changeTheme(): Observable<any>{
    return this.http.get<any>(`${this.themeUrl}/changeTheme/`).pipe();
  }

}
