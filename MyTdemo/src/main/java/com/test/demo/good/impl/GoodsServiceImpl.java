package com.test.demo.good.impl;

import com.test.demo.good.dao.GoodsInterface;
import com.test.demo.good.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * Created by dz on 2020-1-3
 */
@Service
public class GoodsServiceImpl {
    @Autowired
    private GoodsInterface goodsInterface;

    public List<Goods> listAll(){
        return goodsInterface.findAll();
    }

    public int save(Goods goods){
        goodsInterface.save(goods);
        return 1;
    }
}
