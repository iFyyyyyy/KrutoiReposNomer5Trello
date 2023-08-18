import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Board } from '../Entities/Board';

@Injectable({
  providedIn: 'root'
})
export class BoardServiceService {

  private boardsUrl = '/api/boards';


  constructor(private http: HttpClient){}

  getAllBoards(): Observable<Board[]> {
    return this.http.get<Board[]>(`${this.boardsUrl}/`).pipe();
  }

  getBoardById(id: number): Observable<Board> {
    return this.http.get<Board>(`${this.boardsUrl}/board/${id}`).pipe();
  }

  addNewBoard(board: Board): Observable<Board> {
    console.log("adding new board: " + board.boardName);
    return this.http.post<Board>(`${this.boardsUrl}`, board).pipe();
  }

  updateBoard(board: Board): Observable<Board> {
    console.log("updating board: " + board.boardName)
    return this.http.put<Board>(`${this.boardsUrl}/board/${board.id}`, board).pipe();
  }

  deleteBoard(board: Board): Observable<Board> {
    console.log("updating board: " + board.boardName)
    return this.http.delete<Board>(`${this.boardsUrl}/board/${board.id}`).pipe();
  }

  // changeBoardPosition(board: Board[]): Observable<Board[]>{
  //   return this.http.post<Board[]>(`${this.boardsUrl}/swap`, board).pipe();
  // }

  changeBoardPosition(board: Board, currentIndex: number): Observable<Board[]>{
  return this.http.post<Board[]>(`${this.boardsUrl}/swap/${currentIndex}`, board).pipe();
  }

  }


