import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, Subject} from 'rxjs';
import {Note} from '../model/note';
import {Notebook} from '../model/notebook';
import {map, tap} from 'rxjs/operators';
import {Feedback} from "../model/feedback";
import {User} from "../model/user";

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private NOTE_BASE_URL = 'http://localhost:8080/note/api';
  private NOTEBOOK_BASE_URL = 'http://localhost:8080/notebook/api';
  private SAVE_NOTE = '/save/';
  private GET_ALL_NOTE = '/get/all/notes';
  private GET_ALL_NOTEBOOK = '/get/all/Notebooks';
  private NEW_NOTEBOOK = '/save/';
  private DELETE_NOTEBOOK = '/delete/';
  private UPDATE_NOTEBOOK = '/update';
  private GET_NOTEBOOK_BY_ID = '/get/notebook/';
  private GET_ALL_NOTE_BY_NOTEBOOK_ID = '/note/notebook/';
  private DELETE_NOTE = '/delete/';
  private UPDATE_NOTE = '/update';
  private POST_FEEDBACK_URL = 'http://localhost:8080/feedback/api/send/mail';

  constructor(private http: HttpClient) { }
  public refresh = new Subject<void>();

  createNote(note: Note, id: number): Observable<Note> {
    return this.http.post<Note>(this.NOTE_BASE_URL + this.SAVE_NOTE + id, note).pipe(
      tap(() => {
        this.refresh.next();
      })
    );
  }

  getAllNotes(): Observable<Note[]> {
    return this.http.get<Note[]>(this.NOTE_BASE_URL + this.GET_ALL_NOTE);
  }

  getAllNotebooks(): Observable<Notebook[]> {
    return this.http.get<Notebook[]>(this.NOTEBOOK_BASE_URL + this.GET_ALL_NOTEBOOK);
  }
  newNotebook(notebook: Notebook, id: number): Observable<Notebook> {
    return this.http.post<Notebook>(this.NOTEBOOK_BASE_URL + this.NEW_NOTEBOOK + id, notebook)
      .pipe(
        tap(() => {
          this.refresh.next();
        })
      );
  }

  deleteNotebook(id: number): Observable<any> {
    return this.http.delete(this.NOTEBOOK_BASE_URL + this.DELETE_NOTEBOOK + id);
  }

  updateNotebook(notebook: Notebook): Observable<Notebook> {
    return this.http.put<Notebook>(this.NOTEBOOK_BASE_URL + this.UPDATE_NOTEBOOK, notebook);
  }

  getAllNoteByNotebookId(id: number): Observable<Note[]> {
    return this.http.get<Note[]>(this.NOTEBOOK_BASE_URL + this.GET_ALL_NOTE_BY_NOTEBOOK_ID + id);
  }

  deleteNote(id: number): Observable<any> {
    return this.http.delete(this.NOTE_BASE_URL + this.DELETE_NOTE + id);
  }

  updateNote(note: Note): Observable<Note> {
    return  this.http.put<Note>(this.NOTE_BASE_URL + this.UPDATE_NOTE, note);
  }

  sendFeedback(feedback: Feedback): Observable<Feedback> {
    return this.http.post<Feedback>(this.POST_FEEDBACK_URL, feedback);
  }
}
