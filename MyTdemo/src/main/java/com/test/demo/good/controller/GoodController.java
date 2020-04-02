package com.test.demo.good.controller;

import com.test.demo.good.entity.Goods;
import com.test.demo.good.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * Created by dz on 2020-1-15
 */
@RestController
public class GoodController {
    @Autowired
    private GoodsServiceImpl goodsService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Goods> list(){
        return goodsService.listAll();
    }
}
