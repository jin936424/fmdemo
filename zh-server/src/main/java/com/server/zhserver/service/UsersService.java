package com.server.zhserver.service;

import com.server.zhserver.pojo.Users;
import com.server.zhserver.service.impl.UsersImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/***
 * Created by dz on 2019-11-14
 */
@Service
@Transactional
public class UsersService {
    @Autowired
    private UsersImpl usersImpl;

    public boolean queryByuserName(String userName){
        return usersImpl.queryByuserName(userName) != null;
    }

    public Users queryUserByuserName(String userName){
        return usersImpl.queryByuserName(userName);
    }

    public Users queryByUserNameAndPassword(String userName, String password){
        return usersImpl.queryByUserNameAndPassword(userName,password);
    }
    public boolean register(Users user){
        return usersImpl.insert(user)==1;
    }

    public boolean updateLoginTime(String userName, Date loginTime){
        return usersImpl.updateLoginTime(userName, loginTime);
    }
    public boolean updateByUsername(Users user){
        return usersImpl.updateByUsername(user);
    }
}
