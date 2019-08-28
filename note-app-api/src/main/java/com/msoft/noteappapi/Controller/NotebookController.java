package com.msoft.noteappapi.Controller;

import com.msoft.noteappapi.Model.Note;
import com.msoft.noteappapi.Model.Notebook;
import com.msoft.noteappapi.Service.NoteService;
import com.msoft.noteappapi.Service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/notebook/api")
public class NotebookController {
    @Autowired
    private NotebookService notebookService;

    @Autowired
    private NoteService noteService;

    @PostMapping("/save")
    public void saveNotebook(@RequestBody Notebook notebook){
        if(notebook!=null){
         notebookService.saveNotebook(notebook);
        }
    }

    @PutMapping("/update")
    public void updateNotebook(@RequestBody Notebook notebook){
        if (notebook!=null){
            notebookService.updateNotebook(notebook);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNotebook(@PathVariable long id){
        if(id!=0){
            notebookService.deleteNotebook(id);
        }
    }

    @GetMapping("/get/notebook/{id}")
    public Notebook getNotebookById(@PathVariable long id){
        return notebookService.getNotebookById(id);
    }

    @GetMapping("/get/all/Notebooks")
    public List<Notebook> getAllNotebook(){
        return notebookService.getAllNotebook();
    }

    @GetMapping("/note/notebook/{id}")
    public List<Note> getAllNoteByNotebookId(@PathVariable long id){
        return this.noteService.getAllNoteByNotebookId(id);
    }
}
