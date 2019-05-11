package com.lzy.pi.service;

/**
 * 业务层接口
 */
import com.lzy.pi.entity.Staff;

import java.util.List;

public interface StaffService {
    void add(Staff staff);
    void remove(Integer id);
    void edit(Staff staff);
    Staff get(Integer id);
    List<Staff> getAll();

}
