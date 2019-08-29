import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Note} from '../model/note';
import {Notebook} from '../model/notebook';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private NOTE_BASE_URL = 'http://localhost:8080/note/api';
  private NOTEBOOK_BASE_URL = 'http://localhost:8080/notebook/api';
  private SAVE_NOTE = '/save/';
  private GET_ALL_NOTE = '/get/all/notes'
  private GET_ALL_NOTEBOOK = '/get/all/Notebooks'

  constructor(private http: HttpClient) { }
  getAllNotes(): Observable<Note[]> {
    return this.http.get<Note[]>(this.NOTE_BASE_URL + this.GET_ALL_NOTE);
  }
  getAllNotebooks(): Observable<Notebook[]> {
    return this.http.get<Notebook[]>(this.NOTEBOOK_BASE_URL + this.GET_ALL_NOTEBOOK);
  }
}
