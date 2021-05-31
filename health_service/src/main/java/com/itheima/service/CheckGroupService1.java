package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckGroup;

import java.util.List;

public interface CheckGroupService1 {
    PageResult<CheckGroup> findPage6(QueryPageBean queryPageBean);

    void add6(CheckGroup checkGroup, Integer[] checkitemIds);

    CheckGroup findById6(int id);

    List<Integer> findimgp(int id);

    void update6(CheckGroup checkGroup, Integer[] checkitemIds);

    void delete6(int id);
}
