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

  getColumnsByBoardId(id: number): Observable<Column[]>{
    return this.http.get<Column[]>(`${this.columnsUrl}/${id}`).pipe();
  }

  addNewColumn(column: Column, boardId: number): Observable<Column> {
    console.log("adding new column: " + column.columnName);
    return this.http.post<Column>(`${this.columnsUrl}?boardId=${boardId}`, column).pipe();
  }

  updateColumn(column: Column): Observable<Column>{
    console.log("updating column: " + column.columnName);
    return this.http.put<Column>(`${this.columnsUrl}/column/${column.id}`, column).pipe();
  }

  deleteColumn(column: Column): Observable<Column>{
    console.log("updating board: " + column.columnName)
    return this.http.delete<Column>(`${this.columnsUrl}/column/${column.id}`).pipe();
  }

  changeColumnPosition(column: Column, currentIndex: number, boardId: number): Observable<Column[]>{
    return this.http.post<Column[]>(`${this.columnsUrl}/swap/${currentIndex}/${boardId}`, column).pipe();
  }

}
