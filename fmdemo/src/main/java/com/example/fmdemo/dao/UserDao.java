package com.example.fmdemo.dao;

import com.example.fmdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/***
 * Created by dz on 2020-4-1
 */
@Component
public interface UserDao extends JpaRepository<User,Long> {

}
