package com.msoft.noteappapi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

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
    private List<Note> note;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(updatable = false,nullable = false)
    private User user;

    public Notebook() {
    }

    public Notebook(String notebookTitle, Long noOfNote, List<Note> note, User user) {
        this.notebookTitle = notebookTitle;
        this.noOfNote = noOfNote;
        this.note = note;
        this.user = user;
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

    public List<Note> getNote() {
        return note;
    }

    public void setNote(List<Note> note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", notebookTitle='" + notebookTitle + '\'' +
                ", noOfNote=" + noOfNote +
                ", note=" + note +
                ", user=" + user +
                '}';
    }
}
