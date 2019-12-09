package com.server.zhserver.controller;

import com.server.zhserver.result.Result;
import com.server.zhserver.pojo.Users;
import com.server.zhserver.result.ResultFactory;
import com.server.zhserver.service.UsersService;
import com.server.zhserver.util.DateUtil;
import com.server.zhserver.util.SignUtil;
import com.server.zhserver.util.UploadUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    //默认头像
    private static final String profile = "http://i1.fuimg.com/705223/cdb74704b0e66bec.jpg";
    //默认简介
    private static final String intro = "这个人很懒，什么也没留下..";

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
            usersService.updateLoginTime(username, DateUtil.getNow());
            return ResultFactory.buildSuccessResult(usersService.queryUserByuserName(username));
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
        regUser.setIntro(intro);
        regUser.setProfile(profile);
        regUser.setRegisterTime(DateUtil.getNow());

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

    /***
     * 查询个人信息
     * @param reqUser
     * @return Result
     */
    @CrossOrigin
    @RequestMapping("/queryByUserName")
    public Result queryByUserName(@RequestBody Users reqUser){
        Users res = usersService.queryUserByuserName(reqUser.getUsername());
        return ResultFactory.buildSuccessResult(res);
    }


    /**
     * 头像上传 已经废弃 使用网络图床
     * @return
     */
    @CrossOrigin
    @RequestMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String savePath = "E:\\Idea_workspace\\taskspace\\zh-server\\src\\main\\resources\\static\\headpoint";
        String newFilePath = UploadUtil.upload(fileName, file, savePath);
        return newFilePath;
    }
    /***
     * 修改个人信息
     * @param reqUser
     * @return
     */
    @CrossOrigin
    @RequestMapping("/update")
    public Result updateByUserName(@RequestBody Users reqUser){
        if (usersService.updateByUsername(reqUser)) {
            return ResultFactory.buildSuccessResult(usersService.queryUserByuserName(reqUser.getUsername()));
        } else {
            return ResultFactory.buildFailResult("error");
        }
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
