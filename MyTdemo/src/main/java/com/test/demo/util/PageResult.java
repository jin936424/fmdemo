package com.test.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/***
 * Created by dz on 2020-1-17
 */
@Data
@AllArgsConstructor
public class PageResult {
    private Integer pageCount;
    private Integer size;
    private List<Object> dataList;
}
