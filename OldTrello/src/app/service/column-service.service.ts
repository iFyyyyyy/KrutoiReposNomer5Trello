import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Column } from '../Entities/Column';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ColumnServiceService {

  private columnsUrl = '/api/columns';


  constructor(
    private http: HttpClient) { }

    getColumnsByBoardId(id: number): Observable<Column[]> {
      return this.http.get<Column[]>(`${this.columnsUrl}/${id}`).pipe();
    }


}
