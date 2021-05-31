package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckGroupDao {
    void add(CheckGroup checkGroup);

    /**
     * 添加检查组与检查项的关系 参数类型相同时，要取别名
     * 也可以封装到map里
     * @param checkGroupId
     * @param checkitemId
     */
    void addCheckGroupCheckItem(@Param("checkGroupId") Integer checkGroupId, @Param("checkitemId") Integer checkitemId);


    Page<CheckGroup> findPage(String queryString);

    int findCount(int id);

    void delete(int id);


    /**
     * 通过id检查组信息
     * @param id
     * @return
     */
    CheckGroup findById(int id);

    /**
     * 通过检查组id查询选中的检查项id集合
     * @param id
     * @return
     */
    List<Integer> findCheckItemIdsByCheckGroupId(int id);

    void update(CheckGroup checkGroup);

    void deleteGroupAndItem(Integer id);

    List<CheckGroup> findAll();
}
