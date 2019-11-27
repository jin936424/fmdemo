package com.example.wechatdemo.controller;

import com.example.wechatdemo.util.SignUtil;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/***
 * Created by dz on 2019-11-20
 * @author Administrator
 */
@org.springframework.stereotype.Controller
@RequestMapping("/api")
public class LoginController {

    private static final Logger logger = Logger.getLogger(LoginController.class);

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

    @RequestMapping("test")
    public void test(@RequestParam(value = "param")String param,HttpServletResponse response) throws IOException {
        if(null == param || "".equals(param)){
            response.sendRedirect("https://www.2345.com/?ie");
        } else {
            response.sendRedirect(param);
        }
    }
}
