package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;

import java.util.List;

public interface CheckItemDao {
    /**
     * 添加检查项
     * @param checkItem
     */
    void add(CheckItem checkItem);


    Page<CheckItem> findByCondition(String queryString);

    int findCountCheckItemById(int id);

    void delete(int id);

    CheckItem findById(int id);

    void update(CheckItem checkItem);

    List<CheckItem> findAll();
}
