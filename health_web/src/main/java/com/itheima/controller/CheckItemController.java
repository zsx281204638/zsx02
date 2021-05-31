package com.itheima.controller;

import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 体检检查项管理
 */
@RestController
@RequestMapping("/checkitem")
public class CheckItemController {
    @Autowired
    private CheckItemService checkItemService;

    //新增
    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem){
        //try {
            checkItemService.add(checkItem);
        //}catch (Exception e){
            //return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        //}
        return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
    }

    @PostMapping("/findPage")
    public Result findPage(@RequestBody QueryPageBean queryPageBean){
            PageResult<CheckItem>  pageResult = checkItemService.findPage(queryPageBean);
            return  new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,pageResult);
    }
    @PostMapping("/delete")
    public Result delete(int id){
           checkItemService.delete(id);
           return new Result(true,MessageConstant.DELETE_CHECKITEM_SUCCESS);
    }

    @PostMapping("/findById")
    public Result findById(int id){
    CheckItem checkItem  =    checkItemService.findById(id);
        return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItem);
    }

    //编辑
    @RequestMapping("/update")
    public Result update(@RequestBody CheckItem checkItem){

        checkItemService.update(checkItem);

        return new Result(true, MessageConstant.EDIT_CHECKITEM_SUCCESS);
    }

    @RequestMapping("/findAll")
        public Result findAll(){
              List<CheckItem> list = checkItemService.findAll();
              return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,list);
        }

}