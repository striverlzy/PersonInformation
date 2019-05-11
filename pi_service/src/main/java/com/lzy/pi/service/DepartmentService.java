package com.lzy.pi.service;

import com.lzy.pi.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 业务层接口
 */

public interface DepartmentService {

    void add(Department department);
    void remove(Integer id);
    void edit(Department department);
    Department get(Integer id);
    List<Department>getAll();

}
