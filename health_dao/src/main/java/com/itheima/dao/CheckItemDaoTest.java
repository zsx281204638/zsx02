package com.itheima.dao;


import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;

public interface CheckItemDaoTest {


    Page<CheckItem> findByTj(String queryString);

    void add2(CheckItem checkItem);

    void delete(int id);

    int findCountByID(int id);

    CheckItem findById(int id);

    void update2(CheckItem checkItem);
}
