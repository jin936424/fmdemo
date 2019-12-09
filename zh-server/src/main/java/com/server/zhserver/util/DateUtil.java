package com.server.zhserver.util;


import java.util.Date;

/***
 * Created by dz on 2019-12-5
 */
public class DateUtil {
    public static Date getNow(){
        return new Date(System.currentTimeMillis());
    }
}
