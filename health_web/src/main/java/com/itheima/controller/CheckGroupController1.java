package com.itheima.controller;

import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckGroup;
import com.itheima.service.CheckGroupService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/checkgroup1")
public class CheckGroupController1 {
    @Autowired
    private CheckGroupService1 checkGroupService1;
    @RequestMapping("/findPage6")
    public Result findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult<CheckGroup> pageResult = checkGroupService1.findPage6(queryPageBean);
        return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,pageResult);
    }
    @Transactional
     @RequestMapping("/add6")
         public Result add6(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
                        checkGroupService1.add6(checkGroup,checkitemIds);
                        return  new Result(true,MessageConstant.ADD_CHECKGROUP_SUCCESS);
         }

          @RequestMapping("/findById6")
              public Result findById6(int id){
          CheckGroup checkGroup =  checkGroupService1.findById6(id);
            return  new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkGroup);

              }

 @RequestMapping("/findimgp")
     public Result findimgp(int id){
                List<Integer> list =checkGroupService1.findimgp(id);
                    return  new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,list);

     }
        @Transactional
      @RequestMapping("/update6")
          public Result update6(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){

          checkGroupService1.update6(checkGroup,checkitemIds);
          return  new Result(true,MessageConstant.EDIT_CHECKGROUP_SUCCESS);
          }
           @RequestMapping("/delete6")
               public Result delete6(int id){
                    checkGroupService1.delete6(id);
                    return  new Result(true,MessageConstant.DELETE_CHECKGROUP_SUCCESS);
               }
}
