
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Task } from '../Entities/Task';
import { Column } from '../Entities/Column';

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

    addNewTask(task: Task, columnId: number | null): Observable<Task> {
      console.log("adding new task: " + task.taskName);
      return this.http.post<Task>(`${this.tasksUrl}?columnId=${columnId}`, task).pipe();
    }

    updateTask(task: Task): Observable<Task> {
      console.log("updating task: " + task.taskName);
      return this.http.put<Task>(`${this.tasksUrl}/task/${task.id}`, task).pipe();
    }

    deleteTask(task: Task): Observable<Task> {
      console.log("deleting task: " + task.taskName);
      return this.http.delete<Task>(`${this.tasksUrl}/task/${task.id}`).pipe();
    }

    changeTaskPosition(task: Task, currentIndex: number): Observable<Column[]>{
      return this.http.post<Column[]>(`${this.tasksUrl}/swap/${currentIndex}`, task).pipe();
    }

    changeTaskPositionAndColumn(task: Task, currentIndex: number, currentColumnId: number): Observable<Column[]>{
      return this.http.post<Column[]>(`${this.tasksUrl}/swap/${currentIndex}/${currentColumnId}`, task).pipe();
    }
}
