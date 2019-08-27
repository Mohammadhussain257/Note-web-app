package com.msoft.noteappapi.Repository;

import com.msoft.noteappapi.Model.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
}
