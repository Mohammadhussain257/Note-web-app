package com.msoft.noteappapi.Repository;

import com.msoft.noteappapi.Model.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
    @Query("SELECT n, nb FROM Note n JOIN n.notebook nb WHERE n.notebook.id=?1")
    List<Note> getAllNoteByNotebookId(long id);
}
