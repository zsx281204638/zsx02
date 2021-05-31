package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckGroupDao1;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.exception.MyException;
import com.itheima.pojo.CheckGroup;
import com.itheima.service.CheckGroupService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CheckGroupService1Impl implements CheckGroupService1 {
    @Autowired
    private CheckGroupDao1 checkGroupDao1;

    @Override
    public PageResult<CheckGroup> findPage6(QueryPageBean queryPageBean) {
        if (!StringUtils.isEmpty(queryPageBean.getQueryString())) {
            queryPageBean.setQueryString("%" + queryPageBean.getQueryString() + "%");
        }
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page<CheckGroup> page = checkGroupDao1.findPage6(queryPageBean.getQueryString());

        long total = page.getTotal();
        List<CheckGroup> result = page.getResult();

        return new PageResult<CheckGroup>(total, result);
    }

    @Override
    public void add6(CheckGroup checkGroup, Integer[] checkitemIds) {
            checkGroupDao1.add6(checkGroup);
        Integer id = checkGroup.getId();
        if (null != checkitemIds){
            for (Integer checkitemId : checkitemIds) {

                checkGroupDao1.addgpim(id,checkitemId);
            }
        }
    }

    @Override
    public CheckGroup findById6(int id) {
        return checkGroupDao1.findById6(id);
    }

    @Override
    public List<Integer> findimgp(int id) {
        return checkGroupDao1.findimgp(id);
    }

    @Override
    public void update6(CheckGroup checkGroup, Integer[] checkitemIds) {
        checkGroupDao1.update6(checkGroup);
        Integer id = checkGroup.getId();
        checkGroupDao1.deletegpim(id);
        if (null != checkitemIds){
            for (Integer checkitemId : checkitemIds) {

                checkGroupDao1.addgpim(id,checkitemId);
            }
        }
    }

    @Override
    public void delete6(int id) {
        int count =checkGroupDao1.findCount6(id);
        if (count>0){
            throw new MyException("改项已被关联，删除失败");
        }else {
            checkGroupDao1.delete(id);
        }
    }
}
