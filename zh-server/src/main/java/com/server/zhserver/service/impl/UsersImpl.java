package com.server.zhserver.service.impl;

import com.server.zhserver.dao.UsersMapper;
import com.server.zhserver.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
