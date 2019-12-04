package com.server.zhserver.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

/***
 * Created by dz on 2019-11-14
 */
@Data
@AllArgsConstructor
public class Result {
    /**
     *  响应码
     */
    private int code;
    private String msg;
    private Object data;
}
