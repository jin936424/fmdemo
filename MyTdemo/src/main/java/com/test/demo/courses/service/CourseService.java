package com.test.demo.courses.service;

import com.test.demo.courses.entity.Courses;
import com.test.demo.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/***
 * Created by dz on 2020-1-16
 */
@Service
public class CourseService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Courses> findAll(){
        return mongoTemplate.findAll(Courses.class);
    }

    public Integer save(Courses courses){
        try{
            mongoTemplate.save(courses);
            return 1;
        } catch (Exception ex){
            return 0;
        }
    }

    public Courses findById(String _id){
        return mongoTemplate.findById(_id,Courses.class);
    }

    public Integer delete(String _id){
        try {
            Query query = new Query(Criteria.where("_id").is(_id));
            mongoTemplate.remove(query,Courses.class);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Integer update(Courses courses){
        try {
            Query query = null;
            if( null != courses.getId() ){
                query = new Query(Criteria.where("_id").is(courses.getId()));
            } else {
                query = new Query(Criteria.where("title").is(courses.getTitle()));
            }
            Update update = new Update().set("title",courses.getTitle()).
                                        set("description",courses.getDescription())
                                        .set("by",courses.getBy())
                                        .set("likes",courses.getLikes()).
                                        set("tags",courses.getTags()).set("url",courses.getUrl());
            mongoTemplate.updateFirst(query,update,Courses.class);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public PageResult findByPage(Integer offset,Integer size){
        if (offset < 0)
            offset = 0;
        Query query = new Query();
        // 总记录数
        long totalCount = mongoTemplate.count(query, Courses.class);
        int pageCount = (int) (totalCount%size==0?totalCount/size:totalCount/size+1);
        offset = (offset-1)*size;
        query.skip(offset).limit(size);
        return new PageResult(pageCount,size, Collections.singletonList(mongoTemplate.find(query, Courses.class)));
    }
}
