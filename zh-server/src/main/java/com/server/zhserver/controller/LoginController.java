package com.server.zhserver.controller;

import com.server.zhserver.pojo.Result;
import com.server.zhserver.pojo.Users;
import com.server.zhserver.service.UsersService;
import com.server.zhserver.util.SignUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/***
 * Created by dz on 2019-11-14
 * @author Administrator
 */
@RestController
@RequestMapping("/api")
public class LoginController {


    @Autowired
    UsersService usersService;

    private static final Logger logger = Logger.getLogger(LoginController.class);

    @CrossOrigin
    @RequestMapping("/login")
    public Result login(@RequestBody Users requestUser, HttpSession session) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        Users user = usersService.queryByUserNameAndPassword(username, requestUser.getPassword());
        if (null == user) {
            String message = "账号密码错误";
            System.out.println(message);
            return new Result(400,message);
        } else {
            session.setAttribute("user", user);
            return new Result(200);
        }
    }

    @RequestMapping(value = "/security", method = RequestMethod.GET)
    public void checkSignature(HttpServletResponse response, @RequestParam(value = "signature",required = true) String signature,
                                 @RequestParam(value = "timestamp",required = true) String timestamp,
                                 @RequestParam(value = "nonce",required = true) String nonce,
                                 @RequestParam(value = "echostr",required = true) String echostr) {
        try {
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                PrintWriter out = response.getWriter();
                out.print(echostr);
                out.close();
            } else {
                logger.info("这里存在非法请求！");
            }
        } catch (Exception e) {
            logger.error(e, e);
        }
    }
}
