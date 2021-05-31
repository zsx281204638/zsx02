package com.itheima.service;

import com.itheima.pojo.Setmeal;
import org.springframework.stereotype.Service;



public interface SetmealService {
    void add(Setmeal setmeal, Integer[] checkgroupIds);
}
