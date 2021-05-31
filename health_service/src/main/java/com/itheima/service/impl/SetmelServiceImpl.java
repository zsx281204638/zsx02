package com.itheima.service.impl;

import com.itheima.dao.SetmealDao;
import com.itheima.pojo.Setmeal;
import com.itheima.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SetmelServiceImpl implements SetmealService {
    @Autowired
    private SetmealDao setmealDao;
    @Override
    @Transactional
    public void add(Setmeal setmeal, Integer[] checkgroupIds) {
            setmealDao.add(setmeal);
        Integer id = setmeal.getId();
        if (null != checkgroupIds){
            for (Integer checkgroupId : checkgroupIds) {
                setmealDao.addmealgroup(id,checkgroupId);
            }
        }
    }
}
