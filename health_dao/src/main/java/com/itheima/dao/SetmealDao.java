package com.itheima.dao;

import com.itheima.pojo.Setmeal;
import org.apache.ibatis.annotations.Param;

public interface SetmealDao {
    void add(Setmeal setmeal);

    void addmealgroup(@Param("setmealId") Integer id, @Param("checkgroupId") Integer checkgroupId);
}
