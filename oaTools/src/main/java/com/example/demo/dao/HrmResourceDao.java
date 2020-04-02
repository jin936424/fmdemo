package com.example.demo.dao;

import com.example.demo.entity.HrmResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * Created by dz on 2020-3-17
 */
@Mapper
@Repository
public interface HrmResourceDao {


    /**
     * query person by workCode and mobile
     * @param workCode 编号
     * @param mobile 登录名/手机号
     * @return 查询的人员集合(考虑到无编号情况、重名情况、所以可能是多个)
     */
    @SelectProvider(type = HrmResourceDaoProvider.class, method = "findBycodePhone")
    List<HrmResource> findByCodePhone(@Param("workCode") String workCode, @Param("mobile") String mobile);




    class HrmResourceDaoProvider{
        public String findBycodePhone(String workCode,String mobile) {
            String sql = "select id,lastname,workCode,mobile,passwordlock from HrmResource where 1=1";
            if(workCode!=null && !"".equals(workCode)){
                sql += " and workCode = #{workCode}";
            }
            if(mobile!=null && !"".equals(mobile)){
                sql+=" and mobile = #{mobile}";
            }
            return sql;
        }
    }
}
