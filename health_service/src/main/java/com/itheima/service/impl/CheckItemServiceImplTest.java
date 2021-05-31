package com.itheima.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckItemDao;
import com.itheima.dao.CheckItemDaoTest;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.exception.MyException;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

//检查项业务层
@Service
@Transactional
public class CheckItemServiceImplTest implements CheckItemServiceTest {
    @Autowired
    private CheckItemDaoTest dao2;


    @Override
    public PageResult<CheckItem> findPage(QueryPageBean queryPageBean) {
        if (!StringUtils.isEmpty(queryPageBean.getQueryString())){
            queryPageBean.setQueryString("%"+queryPageBean.getQueryString()+"%");
        }
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
       Page<CheckItem> page = dao2.findByTj(queryPageBean.getQueryString());
        long total = page.getTotal();
        List<CheckItem> result = page.getResult();

        return new PageResult<CheckItem>(total,result);

    }

    @Override
    public void add2(CheckItem checkItem) {
        dao2.add2(checkItem);
    }

    @Override
    public void delete(int id) {
        int count = dao2.findCountByID(id);
        if (count > 0) {
            throw new MyException("该项已经被关连，不能删除");
        } else {
            dao2.delete(id);
        }
    }

    @Override
    public CheckItem findById(int id) {
        return dao2.findById(id);
    }

    @Override
    public void update2(CheckItem checkItem) {
        dao2.update2(checkItem);
    }
}
