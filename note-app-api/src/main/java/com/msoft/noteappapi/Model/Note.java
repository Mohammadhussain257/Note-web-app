package com.msoft.noteappapi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date lastModified;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(updatable = false,nullable = false)
    private Notebook notebook;

    public Note() {
    }

    public Note(String title, String content, Date lastModified, Notebook notebook) {
        this.title = title;
        this.content = content;
        this.lastModified = lastModified;
        this.notebook = notebook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", lastModified=" + lastModified +
                ", notebook=" + notebook +
                '}';
    }
}
