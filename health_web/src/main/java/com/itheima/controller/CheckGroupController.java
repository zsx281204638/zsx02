package com.itheima.controller;

import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckGroup;
import com.itheima.service.CheckGroupService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sun.security.ec.CurveDB;

import java.util.List;

@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController {
    @Autowired
    private CheckGroupService checkGroupService;
    @Transactional
    @RequestMapping("/add")
         public Result add(@RequestBody CheckGroup checkGroup, Integer[] checkitemIds){
                checkGroupService.add(checkGroup,checkitemIds);
                return new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);

         }

          @RequestMapping("/findPage")
              public Result findPage(@RequestBody QueryPageBean queryPageBean){
               PageResult<CheckGroup> pageResult = checkGroupService.findPage(queryPageBean);
               return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,pageResult);
              }
               @RequestMapping("/delete")
                   public Result delete(int id){
                   checkGroupService.delete(id);
                    return new Result(true, MessageConstant.DELETE_CHECKGROUP_SUCCESS);
                   }

    @GetMapping("/findById")
    public Result findById(int id){
        // 调用业务查询
        CheckGroup checkGroup = checkGroupService.findById(id);
        return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkGroup);
    }

    @GetMapping("/findCheckItemIdsByCheckGroupId")
    public Result findCheckItemIdsByCheckGroupId(int id){
        List<Integer> list = checkGroupService.findCheckItemIdsByCheckGroupId(id);
        return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS,list);
    }
    @Transactional
    @RequestMapping("/update")
    public Result update(@RequestBody CheckGroup checkGroup, Integer[] checkitemIds){
        checkGroupService.update(checkGroup,checkitemIds);
        return new Result(true, MessageConstant.EDIT_CHECKGROUP_SUCCESS);

    }
     @GetMapping("/findAll")
         public Result findAll(){
         List<CheckGroup> list  = checkGroupService.findAll();
         return  new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,list);

         }
}
