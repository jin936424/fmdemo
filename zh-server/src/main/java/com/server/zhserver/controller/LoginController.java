package com.server.zhserver.controller;

import com.server.zhserver.pojo.Result;
import com.server.zhserver.pojo.Users;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

/***
 * Created by dz on 2019-11-14
 * @author Administrator
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    @CrossOrigin
    @RequestMapping("/login")
    public Result login(@RequestBody Users requestUser){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        System.err.println(requestUser);

        if (!"admin".equals( username) || !"123qwe".equals(requestUser.getPassword())) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}
