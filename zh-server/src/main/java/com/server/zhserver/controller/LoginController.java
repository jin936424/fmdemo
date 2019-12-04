package com.server.zhserver.controller;

import com.server.zhserver.result.Result;
import com.server.zhserver.pojo.Users;
import com.server.zhserver.result.ResultFactory;
import com.server.zhserver.service.UsersService;
import com.server.zhserver.util.SignUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;

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

    /**
     * 登录
     * @param requestUser
     * @return
     */
    @CrossOrigin
    @RequestMapping("/login")
    public Result login(@RequestBody  Users requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        Subject subject = SecurityUtils.getSubject();
        String pwd = requestUser.getPassword();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, pwd);
        try {
            subject.login(usernamePasswordToken);
            usersService.updateLoginTime(username,new Date(System.currentTimeMillis()));
            return ResultFactory.buildSuccessResult(usernamePasswordToken);
        } catch (AuthenticationException e) {
            String message = "账号密码错误";
            return ResultFactory.buildFailResult(message);
        }
    }

    /**
     * 注册
     * @param regUser
     * @return
     */
    @CrossOrigin
    @RequestMapping("/register")
    public Result register(@RequestBody Users regUser){
        String username = regUser.getUsername();
        String password = regUser.getPassword();
        username = HtmlUtils.htmlEscape(username);
        regUser.setUsername(username);
        // 查询是否存在
        boolean exist = usersService.queryByuserName(username);
        if (exist) {
            String message = "用户名已存在";
            return ResultFactory.buildFailResult(message);
        }
        //生成盐值
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String encodedPwd = new SimpleHash("MD5", password, salt, times).toString();

        regUser.setPassword(encodedPwd);
        regUser.setSalt(salt);
        usersService.register(regUser);
        return ResultFactory.buildSuccessResult(regUser);
    }

    /***
     * 登出
     * @return
     */
    @CrossOrigin
    @RequestMapping("/logout")
    public Result logOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultFactory.buildSuccessResult("success");
    }


    /**
     *  微信公众号认证
     */
    @RequestMapping(value = "/security", method = RequestMethod.GET)
    public void checkSignature(HttpServletResponse response,
                                 @RequestParam(value = "signature",required = true) String signature,
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
