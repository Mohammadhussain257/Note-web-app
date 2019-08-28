package com.msoft.noteappapi.Controller;

import com.msoft.noteappapi.Model.Note;
import com.msoft.noteappapi.Service.NoteService;
import com.msoft.noteappapi.Service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/note/api")
public class NoteController {

    @Autowired
    private NoteService noteService;
    @Autowired
    private NotebookService notebookService;
    @PostMapping("/save/{id}")
    public void saveNote(@RequestBody Note note, @PathVariable long id){
        var notebook=notebookService.getNotebookById(id);
        if(note!=null && notebook!=null){
            note.setLastModified(new Date());
            note.setNotebook(notebook);
            noteService.saveNote(note);
        }
    }

    @PutMapping("/update")
    public void updateNote(@RequestBody Note note){
        if(note!=null){
            noteService.saveNote(note);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNote(@PathVariable long id){
        if(id!=0){
            noteService.deleteNote(id);
        }
    }

    @GetMapping("/get/note/{id}")
    public Note getNoteById(@PathVariable long id){
        return noteService.getNoteById(id);
    }

    @GetMapping("/get/all/notes")
    public List<Note> getAllNote(){
        return noteService.getAllNote();
    }
}
