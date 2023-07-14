
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/internal/Observable';
import { Task } from '../Entities/Task';

@Injectable({
  providedIn: 'root'
})
export class TaskServiceService {

  private tasksUrl = '/api/tasks';


  constructor(
    private http: HttpClient) { }

    getTasksByBoardId(id: number): Observable<Task[]> {
      return this.http.get<Task[]>(`${this.tasksUrl}/${id}`).pipe();
    }

}
