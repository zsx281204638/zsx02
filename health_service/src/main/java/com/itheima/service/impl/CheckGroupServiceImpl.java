package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckGroupDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.exception.MyException;
import com.itheima.pojo.CheckGroup;
import com.itheima.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {
    @Autowired
    private CheckGroupDao checkGroupDao;
    @Override
    public void add(CheckGroup checkGroup, Integer[] checkitemIds) {
            checkGroupDao.add(checkGroup);
        Integer id = checkGroup.getId();
        if (null != checkitemIds){
            for (Integer checkItemId : checkitemIds) {
                checkGroupDao.addCheckGroupCheckItem(id,checkItemId);
            }
        }
    }

    @Override
    public PageResult<CheckGroup> findPage(QueryPageBean queryPageBean) {
        if(!StringUtils.isEmpty(queryPageBean.getQueryString())){
            queryPageBean.setQueryString("%" + queryPageBean.getQueryString()+"%");
        }
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        Page<CheckGroup> page = checkGroupDao.findPage(queryPageBean.getQueryString());
        long total = page.getTotal();
        List<CheckGroup> result = page.getResult();
        return new PageResult<CheckGroup>(total,result);

    }

    @Override
    public void delete(int id) {
        int count = checkGroupDao.findCount(id);
        if (count > 0) {
            throw new MyException("改项已被关联使用，删除失败");
        } else {
                checkGroupDao.delete(id);
        }
    }



    /**
     * 通过id检查组信息
     * @param id
     * @return
     */
    @Override
    public CheckGroup findById(int id) {
        return checkGroupDao.findById(id);
    }

    /**
     * 通过检查组id查询选中的检查项id集合
     * @param id
     * @return
     */
    @Override
    public List<Integer> findCheckItemIdsByCheckGroupId(int id) {
        return checkGroupDao.findCheckItemIdsByCheckGroupId(id);
    }

    @Override
    @Transactional
    public void update(CheckGroup checkGroup, Integer[] checkitemIds) {
        checkGroupDao.update(checkGroup);
        Integer id = checkGroup.getId();
        checkGroupDao.deleteGroupAndItem(id);
        if (null != checkitemIds){
            for (Integer checkitemId : checkitemIds) {
                    checkGroupDao.addCheckGroupCheckItem(id,checkitemId);
            }
        }
    }

    @Override
    public List<CheckGroup> findAll() {

        return checkGroupDao.findAll();
    }
}
