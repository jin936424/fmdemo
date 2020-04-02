package com.example.fmdemo.service;

import com.example.fmdemo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * Created by dz on 2020-4-1
 */
@Service
public interface UserService {
    List<User> findAll();

    User save(User user);
}
