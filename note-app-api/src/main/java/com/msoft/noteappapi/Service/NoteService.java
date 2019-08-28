package com.msoft.noteappapi.Service;

import com.msoft.noteappapi.Model.Note;

import java.util.List;

public interface NoteService {
    void saveNote(Note note);
    void updateNote(Note note);
    void deleteNote(long id);
    Note getNoteById(long id);
    List<Note> getAllNote();
    List<Note> getAllNoteByNotebookId(long id);
}
