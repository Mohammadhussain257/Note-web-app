package com.msoft.noteappapi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "notebook")
public class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String notebookTitle;
    private Long noOfNote;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "notebook", cascade = CascadeType.ALL)
    @JsonIgnore
    private Note note;

    public Notebook() {
    }

    public Notebook(String notebookTitle, Long noOfNote, Note note) {
        this.notebookTitle = notebookTitle;
        this.noOfNote = noOfNote;
        this.note = note;
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

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", notebookTitle='" + notebookTitle + '\'' +
                ", noOfNote=" + noOfNote +
                ", note=" + note +
                '}';
    }
}
