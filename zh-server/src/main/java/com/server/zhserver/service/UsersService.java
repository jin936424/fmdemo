package com.server.zhserver.service;

import com.server.zhserver.pojo.Users;
import com.server.zhserver.service.impl.UsersImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/***
 * Created by dz on 2019-11-14
 */
@Service
@Transactional
public class UsersService {
    @Autowired
    private UsersImpl usersImpl;
    public int queryByuserName(String userName){
        return usersImpl.queryByuserName(userName);
    }

    public Users queryByUserNameAndPassword(String userName, String password){
        return usersImpl.queryByUserNameAndPassword(userName,password);
    }
}
