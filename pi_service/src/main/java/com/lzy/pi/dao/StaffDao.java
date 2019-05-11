package com.lzy.pi.dao;


import com.lzy.pi.entity.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * 定义接口
 */
@Repository("staffDao")
public interface StaffDao {
    void insert(Staff staff);
    void delete(Integer id);
    void update(Staff staff);
    Staff selectById(Integer id);
    List<Staff>selectAll();
}
