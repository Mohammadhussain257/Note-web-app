package com.msoft.noteappapi.Service;

import com.msoft.noteappapi.Model.Notebook;
import com.msoft.noteappapi.Model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    User getUserById(long id);
}
