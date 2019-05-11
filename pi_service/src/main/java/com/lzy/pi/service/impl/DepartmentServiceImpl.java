package com.lzy.pi.service.impl;

import com.lzy.pi.dao.DepartmentDao;
import com.lzy.pi.entity.Department;
import com.lzy.pi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务层实现接口
 */
import java.util.List;
//@Service对应的是业务层Bean
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    //@Autowired自动注入setter/getter
    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void remove(Integer id) {
        departmentDao.delete(id);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public Department get(Integer id) {
        return departmentDao.selectById(id);
    }

    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}
