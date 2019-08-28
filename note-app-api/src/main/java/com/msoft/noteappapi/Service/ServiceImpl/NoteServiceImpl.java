package com.msoft.noteappapi.Service.ServiceImpl;

import com.msoft.noteappapi.Model.Note;
import com.msoft.noteappapi.Model.Notebook;
import com.msoft.noteappapi.Repository.NoteRepository;
import com.msoft.noteappapi.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public void saveNote(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void updateNote(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void deleteNote(long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Note getNoteById(long id) {
        return noteRepository.findById(id).get();
    }

    @Override
    public List<Note> getAllNote() {
        return (List<Note>) noteRepository.findAll();
    }

    @Override
    public List<Note> getAllNoteByNotebookId(long id) {
        return noteRepository.getAllNoteByNotebookId(id);
    }
}
