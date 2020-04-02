package com.example.demo.dao.impl;

import com.example.demo.dao.HrmResourceDao;
import com.example.demo.entity.HrmResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * Created by dz on 2020-3-17
 * @author Administrator
 */
@Repository
public class HrmResourceImpl {

    @Autowired
    private HrmResourceDao hrmResourceDao;

    public List<HrmResource> findBycodePhone(String workCode, String mobile){
        return hrmResourceDao.findByCodePhone(workCode, mobile);
    }
}
