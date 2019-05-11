package com.lzy.pi.dao;

import com.lzy.pi.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 定义持久化操作接口
 */
//@Repository对应数据访问层Bean
@Repository("departmentDao")
public interface DepartmentDao {
    //增
    void insert(Department department);
    //删
    void delete(Integer id);
    //改
    void update(Department department);
    //根据id查询
    Department selectById(Integer id);
    //查询所有
    List<Department>selectAll();
}
