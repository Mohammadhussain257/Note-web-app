import { Component, OnInit } from '@angular/core';
import {Note} from '../model/note';
import {AppService} from '../shared/app-service';
import {Notebook} from '../model/notebook';
import {log} from 'util';

@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css']
})
export class NoteComponent implements OnInit {
  notes: Note[] = [];
  notebooks: Notebook[] = [];
  selectedNotebook: Notebook;
  searchText: string;
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
        this.getAllNotes();
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

  public newNote(id: number) {
    let new_note: Note = {
      id: 0,
      title: 'Title',
      content: 'Note Content',
      lastModified: null,
      notebook: id
    };
    this.apiService.createNote(new_note, id).subscribe(
      res => {
        if (new_note.id == null) {
          new_note.id = res.id;
          this.notes.push(new_note);
        }
      },
      err => {
        alert('An error occurred while creating note');
        console.log(new_note);
      }
    );
  }

  public selectNotebook(notebok: Notebook) {
    this.selectedNotebook = notebok;
    this.apiService.getAllNoteByNotebookId(notebok.id).subscribe(
      res => {
        this.notes = res;
      },
      err => {
        alert('An error occurred while getting notes!!!');
      }
    );
  }

  public deleteNote(note: Note) {
    if (confirm('Are you sure to delete?')) {
      this.apiService.deleteNote(note.id).subscribe(
        res => {
          let indexOfNote = this.notes.indexOf(note);
          this.notes.splice(indexOfNote, 1);
        },
        err => {
          alert('An error occurred while deleting note!!!');
        }
      );
    }
  }

  public updateNote(note: Note) {
    this.apiService.updateNote(note).subscribe(
      res => {},
      err => {
        alert('An error occurred while updating note!!!');
      }
    );
  }

  public selectAllNotes() {
    this.selectedNotebook = null;
    this.getAllNotes();
  }
}
