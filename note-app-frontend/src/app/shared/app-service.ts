import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, Subject} from 'rxjs';
import {Note} from '../model/note';
import {Notebook} from '../model/notebook';
import {tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private NOTE_BASE_URL = 'http://localhost:8080/note/api';
  private NOTEBOOK_BASE_URL = 'http://localhost:8080/notebook/api';
  private SAVE_NOTE = '/save/';
  private GET_ALL_NOTE = '/get/all/notes';
  private GET_ALL_NOTEBOOK = '/get/all/Notebooks';
  private NEW_NOTEBOOK = '/save';
  private DELETE_NOTEBOOK = '/delete/';
  private UPDATE_NOTEBOOK = '/update';

  constructor(private http: HttpClient) { }
  public refresh = new Subject<void>();

  saveNote(note: Note, noteboo: Notebook): Observable<Note> {
    return this.http.post<Note>(this.NOTE_BASE_URL + this.SAVE_NOTE, note).pipe(
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
  newNotebook(notebook: Notebook): Observable<Notebook> {
    return this.http.post<Notebook>(this.NOTEBOOK_BASE_URL + this.NEW_NOTEBOOK, notebook)
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
}
