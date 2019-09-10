package com.msoft.noteappapi.Service.ServiceImpl;

import com.msoft.noteappapi.Model.Notebook;
import com.msoft.noteappapi.Model.User;
import com.msoft.noteappapi.Repository.UserRepository;
import com.msoft.noteappapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
      return userRepository.findById(id).get();
    }
}
