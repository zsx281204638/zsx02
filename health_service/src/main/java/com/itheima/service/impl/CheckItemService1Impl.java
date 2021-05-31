package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckItemDao1;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class CheckItemService1Impl  implements CheckItemService1 {
    @Autowired
    private CheckItemDao1 dao1;


    @Override
    public void addd(CheckItem checkItem) {
         dao1.addd(checkItem);
    }

    @Override
    public PageResult<CheckItem> findPage(QueryPageBean queryPageBean) {
                    if (!StringUtils.isEmpty(queryPageBean.getQueryString())){
                        queryPageBean.setQueryString("%" + queryPageBean.getQueryString()+"%");
                    }
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
               Page<CheckItem>  page = dao1.findByTJ(queryPageBean.getQueryString());
        long total = page.getTotal();
        List<CheckItem>  result = page.getResult();

        return new PageResult<CheckItem>(total,result);



    }
}
