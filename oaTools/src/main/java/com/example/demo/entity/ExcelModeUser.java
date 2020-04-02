package com.example.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/***
 * Created by dz on 2020-3-17
 * @author Administrator
 */
@Data
public class ExcelModeUser extends BaseRowModel {

    @ExcelProperty(value = "分部", index = 0)
    private String branch;
    @ExcelProperty(value = "部门", index = 1)
    private String department;
    @ExcelProperty(value = "编号", index = 2)
    private String workCode;
    @ExcelProperty(value = "姓名", index = 3)
    private String realName;
    @ExcelProperty(value = "登录名", index = 4)
    private String mobile;
    @ExcelProperty(value = "是否锁定", index = 47)
    private String isLock;

}
