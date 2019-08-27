package com.msoft.noteappapi.Service;

import com.msoft.noteappapi.Model.Note;
import com.msoft.noteappapi.Model.Notebook;

import java.util.List;

public interface NoteService {
    void saveNote(Note note);
    void updateNote(Note note);
    void deleteNote(long id);
    Note getNoteById(long id);
    List<Note> getAllNote();
    List<Notebook> getAllNoteByNotebookId(long id);
}
