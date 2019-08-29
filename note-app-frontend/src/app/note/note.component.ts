import { Component, OnInit } from '@angular/core';
import {Note} from '../model/note';
import {AppService} from '../shared/app-service';
import {Notebook} from '../model/notebook';

@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css']
})
export class NoteComponent implements OnInit {
  notes: Note[] = [];
  notebooks: Notebook[] = [];
  constructor(private apiService: AppService) { }

  ngOnInit() {
    this.getAllNotes();
    this.getAllNotebooks();
  }

  public getAllNotes() {
    this.apiService.getAllNotes().subscribe(
      res => {
        this.notes = res;
      },
      err => {
        alert('An error occurred while getting notes!!!');
      }
    );
  }

  public getAllNotebooks() {
    this.apiService.getAllNotebooks().subscribe(
      res => {
        this.notebooks = res;
      },
      err => {
        alert('An error occurred while getting notebooks');
      }
    );
  }
}
