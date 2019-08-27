package com.msoft.noteappapi.Model;

public class Notebook {

    private Long id;
    private String notebookTitle;
    private Long noOfNote;

    public Notebook() {
    }

    public Notebook(Long id, String notebookTitle, Long noOfNote) {
        this.id = id;
        this.notebookTitle = notebookTitle;
        this.noOfNote = noOfNote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotebookTitle() {
        return notebookTitle;
    }

    public void setNotebookTitle(String notebookTitle) {
        this.notebookTitle = notebookTitle;
    }

    public Long getNoOfNote() {
        return noOfNote;
    }

    public void setNoOfNote(Long noOfNote) {
        this.noOfNote = noOfNote;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", notebookTitle='" + notebookTitle + '\'' +
                ", noOfNote=" + noOfNote +
                '}';
    }
}
