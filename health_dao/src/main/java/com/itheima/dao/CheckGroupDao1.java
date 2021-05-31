package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckGroupDao1 {
    Page<CheckGroup> findPage6(String queryString);

    void add6(CheckGroup checkGroup);

    void addgpim( @Param("id") Integer id, @Param("checkitemId") Integer checkitemId);

    CheckGroup findById6(int id);

    List<Integer> findimgp(int id);

    void update6(CheckGroup checkGroup);

    void deletegpim(Integer id);

    int findCount6(int id);

    void delete(int i);
}
