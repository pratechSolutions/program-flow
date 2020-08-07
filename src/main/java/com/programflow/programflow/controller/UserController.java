package com.programflow.programflow.controller;


import com.programflow.programflow.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(value = "users/{userId}")
    public User getUser(@PathVariable int userId){

        User user;

        if (userId==1)
            user =new User(1,"Alican","wwww.google.com","12.12.2020");
        else if(userId==2)
            user=new User(2,"Zeynel","www.google.com","10.08.2020");
        else
            user=new User(0,"0","0","0");
        return user;
    }

}
