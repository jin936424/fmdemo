package com.example.wechatdemo.util;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * Created by dz on 2019-11-20
 */
@RestController
@RequestMapping("/")
public class WebMvcConfig {

    @RequestMapping({"mpVerify"})
    private String returnConfigFile() {
        //把MP_verify_xxxxxx.txt中的内容返回
        return "ChICxCSXdCoWt4KL";
    }
}
