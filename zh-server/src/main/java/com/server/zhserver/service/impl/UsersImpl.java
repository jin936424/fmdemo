package com.server.zhserver.service.impl;

import com.server.zhserver.dao.UsersMapper;
import com.server.zhserver.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/***
 * Created by dz on 2019-11-14
 * @author Administrator
 */
@Repository
public class UsersImpl {
    @Autowired
    private UsersMapper usersMapper;

    public Users queryByuserName(String userName){
        return usersMapper.queryByUsername(userName);
    }

    public Users queryByUserNameAndPassword(String userName,String password){
        return usersMapper.queryByUserNameAndPassword(userName,password);
    }
    public int insert(Users user){
        return usersMapper.insert(user);
    }

    public boolean updateLoginTime(String userName, Date loginTime){
        return usersMapper.updateLoginTime(userName, loginTime)==1;
    }
}
