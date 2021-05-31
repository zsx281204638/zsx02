package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;

public interface CheckItemService1 {


    void addd(CheckItem checkItem);

    PageResult<CheckItem> findPage(QueryPageBean queryPageBean);

}
