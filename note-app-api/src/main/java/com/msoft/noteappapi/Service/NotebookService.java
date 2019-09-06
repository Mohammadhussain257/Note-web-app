package com.msoft.noteappapi.Service;

import com.msoft.noteappapi.Model.Notebook;

import java.util.List;

public interface NotebookService {
    void saveNotebook(Notebook notebook);
    void updateNotebook(Notebook notebook);
    void deleteNotebook(long id);
    Notebook getNotebookById(long id);
    List<Notebook> getAllNotebook();
    List<Notebook> getNoteboookByUserId(long id);
}
