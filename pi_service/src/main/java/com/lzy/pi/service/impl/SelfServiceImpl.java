package com.lzy.pi.service.impl;

import com.lzy.pi.dao.SelfDao;
import com.lzy.pi.dao.StaffDao;
import com.lzy.pi.entity.Staff;
import com.lzy.pi.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务层实现接口
 */
@Service("selfService")
public class SelfServiceImpl implements SelfService {

    @Autowired
    private SelfDao selfDao;

    @Autowired
    private StaffDao staffDao;

    public Staff login(String account, String password) {
        Staff staff = selfDao.selectByAccount(account);
        if(staff==null)return null;
        if(staff.getPassword().equals(password))return staff;
        return null;
    }

    public void changePassword(Integer id, String password) {
        Staff staff = staffDao.selectById(id);
        staff.setPassword(password);
        staffDao.update(staff);
    }
}
