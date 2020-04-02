package com.test.demo.good.dao;

import com.test.demo.good.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/***
 * Created by dz on 2020-1-3
 */
@Repository
public interface GoodsInterface extends JpaRepository<Goods, Integer> {

}
