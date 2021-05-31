package com.itheima.controller;

import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService1;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkitem1")
public class CheckItemController11 {
    @Autowired
    private CheckItemService1 service;
    @RequestMapping("/add1")
    public Result addd(@RequestBody CheckItem checkItem){
            service.addd(checkItem);
            return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);

    }
    @PostMapping("/findPage1")
    public Result findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult<CheckItem> pageResult =  service.findPage(queryPageBean);
        return  new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,pageResult);
    }

}
