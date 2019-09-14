package com.msoft.noteappapi.Controller;

import com.msoft.noteappapi.Model.Notebook;
import com.msoft.noteappapi.Model.User;
import com.msoft.noteappapi.Service.NotebookService;
import com.msoft.noteappapi.Service.UserService;
import com.msoft.noteappapi.dto.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/user/api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private NotebookService notebookService;

    private AuthenticationManager authenticationManager;
    @PostMapping("/save")
    public void saveUser(@RequestBody User user){
        if(user !=null){
            userService.saveUser(user);
        }
    }

    @GetMapping("/get/notebook/{id}")
    public List<Notebook> getAllNotebookByUserId(@PathVariable long id){
        if(id!=0){
           return notebookService.getNoteboookByUserId(id);
        }
        return null;
    }

    @RequestMapping({ "/validateLogin" })
    public Map<String,String> validateLogin(HttpSession session, HttpServletRequest request) {
        System.out.println(request.getRemoteHost());
        String remoteHost= request.getRemoteHost();
        int portNumber = request.getRemotePort();
        System.out.println(remoteHost+":"+portNumber);
        System.out.println(request.getRemoteAddr());
        return Collections.singletonMap("validateLogin",session.getId());
    }
    
}
