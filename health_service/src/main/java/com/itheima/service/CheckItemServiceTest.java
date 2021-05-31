package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;

public interface CheckItemServiceTest {


    PageResult<CheckItem> findPage(QueryPageBean queryPageBean);

    void add2(CheckItem checkItem);

    void delete(int id);

    CheckItem findById(int id);

    void update2(CheckItem checkItem);
}
