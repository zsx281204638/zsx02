package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckItemDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.exception.MyException;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

//检查项业务层
@Service
@Transactional
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemDao checkItemDao;
    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    @Override
    public PageResult<CheckItem> findPage(QueryPageBean queryPageBean) {

        if (!StringUtils.isEmpty(queryPageBean.getQueryString())) {
            //有查询条件
            queryPageBean.setQueryString("%" + queryPageBean.getQueryString() +"%");
        }
            PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
         Page<CheckItem> page= checkItemDao.findByCondition(queryPageBean.getQueryString());
            long total = page.getTotal();
            List<CheckItem> checkItems = page.getResult();
       return new  PageResult<CheckItem>(total,checkItems);



    }

    @Override
    public void delete(int id) {
        //根据id删除数据库的数据，此时要判断该id字段有没有被其他表所关联且有数据
        int count = checkItemDao.findCountCheckItemById(id);
        if (count > 0) {
            throw new MyException("该检查项被检查组使用了，不能删除");
        } else {
            checkItemDao.delete(id);
        }
    }

    @Override
    public CheckItem findById(int id) {

         return checkItemDao.findById(id);
    }

    @Override
    public void update(CheckItem checkItem) {
            checkItemDao.update(checkItem);
    }

    @Override
    public List<CheckItem> findAll() {
        return checkItemDao.findAll();
    }
}
