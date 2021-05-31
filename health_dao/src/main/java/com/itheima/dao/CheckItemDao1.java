package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;

public interface CheckItemDao1 {


    void addd(CheckItem checkItem);

    Page<CheckItem> findByTJ(String queryString);
}
