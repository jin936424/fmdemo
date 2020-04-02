package com.test.demo.courses.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


/***
 * Created by dz on 2020-1-16
 */
@Data
@Document("courses")
public class Courses {
    @Id
    private String id;
    @Field("title")
    private String title;
    @Field("description")
    private String description;
    @Field("by")
    private String by;
    @Field("url")
    private String url;
    @Field("tags")
    private String[] tags;
    @Field("likes")
    private Double likes;


}
