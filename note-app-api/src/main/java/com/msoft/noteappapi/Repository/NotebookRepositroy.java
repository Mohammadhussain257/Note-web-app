package com.msoft.noteappapi.Repository;
import com.msoft.noteappapi.Model.Notebook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotebookRepositroy extends CrudRepository<Notebook, Long> {
}
