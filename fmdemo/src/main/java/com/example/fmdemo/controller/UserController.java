package com.example.fmdemo.controller;

import com.example.fmdemo.entity.User;
import com.example.fmdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Created by dz on 2020-4-1
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PutMapping("/add")
    public String save(User user){
        User res = userService.save(user);
        System.err.println("插入结果:" + res);
        return String.valueOf(user.getId());
    }

}
