package com.test.demo;

import com.test.demo.courses.entity.Courses;
import com.test.demo.courses.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/***
 * Created by dz on 2020-1-16
 */
//@SpringBootTest
public class GcTest {

    @Autowired
    private CourseService courseService;

    @Test
    public void test1(){
//        System.out.println(Objects.hashCode("AB"));
        double v = 0.0 / 0;
        System.out.println(Double.isNaN(v));
        System.out.println(Double.isInfinite(1.0/0));
    }


    @Test
    public void test2(){
        List<Courses> courses = courseService.findAll();
        courses.forEach(System.out::println);
        System.err.println("========排序后=========");
        Collections.sort(courses, new Comparator<Courses>() {
            @Override
            public int compare(Courses o1, Courses o2) {
                return o2.getLikes().compareTo(o1.getLikes());
            }
        });
//        courses.sort(new Comparator<Courses>() {
//            @Override
//            public int compare(Courses o1, Courses o2) {
//                return o1.getLikes().compareTo(o2.getLikes());
//            }
//        });
        courses.forEach(System.out::println);
    }
    @Test
    public void test3(){
        String str = "C";
        byte[] bytes = str.getBytes();
        for(byte b : bytes) {
            System.out.println(b ^ 3);
            System.err.println(b);
        }
    }
}
