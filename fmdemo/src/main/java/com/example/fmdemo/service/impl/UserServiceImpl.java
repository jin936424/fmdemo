package com.example.fmdemo.service.impl;

import com.example.fmdemo.dao.UserDao;
import com.example.fmdemo.entity.User;
import com.example.fmdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/***
 * Created by dz on 2020-4-1
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User save(User user){
        return userDao.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public boolean update(User user) {
        return userDao.saveAndFlush(user)==null;
    }

    @Override
    public boolean deleteById(Long id) {
        boolean rs = true;
        try {
            userDao.deleteById(id);
        } catch (Exception e) {
            rs = false;
        }
        return rs;
    }


}
