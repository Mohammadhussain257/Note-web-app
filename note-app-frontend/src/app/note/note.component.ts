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
    this.apiService.refresh.subscribe(() => {
      this.getAllNotebooks();
      this.getAllNotes();
    });
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

  public newNotebook() {
    let new_notebook: Notebook = {
      id: 0,
      notebookTitle: 'New Notebook',
      noOfNote: 0
    };
    this.apiService.newNotebook(new_notebook).subscribe(
      res => {
        if (new_notebook.id == null) {
          new_notebook.id = res.id;
          this.notebooks.push(new_notebook);
          }
      },
      err => {
        alert('An error occurred while creating notebook');
      }
    );
  }

 public deleteNotebook(notebook: Notebook) {
  if (confirm('Are you sure to delete?')) {
    this.apiService.deleteNotebook(notebook.id).subscribe(
      res => {
        let indexOfNotebook = this.notebooks.indexOf(notebook);
        this.notebooks.splice(indexOfNotebook, 1);
      }
    );
  }
  }
 public updateNotebook(notebook: Notebook) {
    this.apiService.updateNotebook(notebook).subscribe(
      res => {},
      err => {
        alert('An error occurred while updating notebook');
      }
    );
  }
  public newNote(note: Note, notebook: Notebook) {
   let newNote: Note = {
      id: 0,
      title: 'New Title',
      content: 'Note Content',
      notebook: notebook.id,
     lastModified: null
    };
   this.apiService.saveNote(note, notebook).subscribe(
      res => {
        if (newNote.id == null) {
          newNote.id = res.id;
          this.notes.push(newNote);
        }
      },
      err => {
        alert('An error occurred while creating note');
      }
    );
  }
}
