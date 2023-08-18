import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ThemeServiceService {

  private themeUrl = '/api/theme';
  constructor(private http: HttpClient){}

  getTheme(id: number | null): Observable<any>{
    return this.http.get<any>(`${this.themeUrl}/${id}`).pipe();
  }

  changeTheme(id: number | null, theme: string): Observable<any>{
    return this.http.post<any>(`${this.themeUrl}/${id}`, theme).pipe();
  }

}
