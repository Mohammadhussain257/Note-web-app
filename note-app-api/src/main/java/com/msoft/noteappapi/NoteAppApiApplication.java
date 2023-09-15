package com.msoft.noteappapi;
import com.msoft.noteappapi.Constant.UserConstant;
import com.msoft.noteappapi.Model.User;
import com.msoft.noteappapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class NoteAppApiApplication {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(NoteAppApiApplication.class, args);
    }

    @PostConstruct
    private void init() {
        User existUser = userRepository.findByUsername("super_admin");
        if (existUser == null) {
            User user = new User();
            user.setEmail("admin@gmail.com");
            user.setEnabled(true);
            user.setFullName("The Administrator");
            user.setPassword(passwordEncoder.encode("admin1234"));
            user.setUsername("super_admin");
            user.setRole("ADMIN");
            userRepository.save(user);
        }
    }
}
