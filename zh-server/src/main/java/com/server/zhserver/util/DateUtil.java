package com.server.zhserver.util;


import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * Created by dz on 2019-12-5
 */
public class DateUtil {
    public static Date getNow(){
        return new Date(System.currentTimeMillis());
    }

    public static String getDateStr(){
        return new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    }
}
