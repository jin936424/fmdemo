package com.test.demo.courses.controller;

import com.test.demo.courses.entity.Courses;
import com.test.demo.courses.service.CourseService;
import com.test.demo.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Created by dz on 2020-1-16
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/list")
    public List<Courses> list(){
        return courseService.findAll();
    }

    @GetMapping(value = "/find/{_id}")
    public Courses find(@PathVariable String _id){
        return courseService.findById(_id);
    }

    @GetMapping("/listByPage/{pageNum}/{size}")
    public PageResult listByPage(@PathVariable Integer pageNum,@PathVariable Integer size){
        return courseService.findByPage(pageNum,size);
    }
    @PostMapping(value = "/save")
    public Integer save(Courses courses){
        return courseService.save(courses);
    }

    @DeleteMapping(value = "/delete/{_id}")
    public Integer delete(@PathVariable String _id){
        return courseService.delete(_id);
    }

    @PutMapping(value = "/update")
    public Integer update(Courses courses){
        System.out.println("update:" + courses);
        return courseService.update(courses);
    }
}
