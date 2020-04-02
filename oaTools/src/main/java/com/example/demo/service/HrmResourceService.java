package com.example.demo.service;

import com.example.demo.dao.impl.HrmResourceImpl;
import com.example.demo.entity.HrmResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * Created by dz on 2020-3-17
 */
@Service
public class HrmResourceService {
    @Autowired
    private HrmResourceImpl hrmResourceImpl;

    public List<HrmResource> findBycodePhone(String workCode, String mobile) {
        return hrmResourceImpl.findBycodePhone(workCode, mobile);
    }
}
