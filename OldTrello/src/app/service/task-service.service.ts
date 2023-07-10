
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/internal/Observable';
import { Task } from '../Entities/Task';

@Injectable({
  providedIn: 'root'
})
export class TaskServiceService {

  private studentsUrl = '/api/tasks';


  constructor(
    private http: HttpClient) { }

    getTasksByBoardId(id: number): Observable<Task[]> {
      return this.http.post<Task[]>(`${this.studentsUrl}`, id).pipe();
    }

}
