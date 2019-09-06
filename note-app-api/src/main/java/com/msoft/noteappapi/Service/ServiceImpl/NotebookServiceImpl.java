package com.msoft.noteappapi.Service.ServiceImpl;

import com.msoft.noteappapi.Model.Notebook;
import com.msoft.noteappapi.Repository.NotebookRepositroy;
import com.msoft.noteappapi.Service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotebookServiceImpl implements NotebookService {
    @Autowired
    private NotebookRepositroy notebookRepositroy;

    @Override
    public void saveNotebook(Notebook notebook) {
        notebookRepositroy.save(notebook);

    }

    @Override
    public void updateNotebook(Notebook notebook) {
        notebookRepositroy.save(notebook);

    }

    @Override
    public void deleteNotebook(long id) {
        notebookRepositroy.deleteById(id);

    }

    @Override
    public Notebook getNotebookById(long id) {
        return notebookRepositroy.findById(id).get();
    }

    @Override
    public List<Notebook> getAllNotebook() {
        return (List<Notebook>) notebookRepositroy.findAll();
    }

    @Override
    public List<Notebook> getNoteboookByUserId(long id) {
        return notebookRepositroy.getAllNotebookByUserkId(id);
    }
}
