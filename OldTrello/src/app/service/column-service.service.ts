import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Column } from '../Entities/Column';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ColumnServiceService {

  private studentsUrl = '/api/columns';


  constructor(
    private http: HttpClient) { }

    getColumnsByBoardId(id: number): Observable<Column[]> {
      return this.http.post<Column[]>(`${this.studentsUrl}`, id).pipe();
    }

}
