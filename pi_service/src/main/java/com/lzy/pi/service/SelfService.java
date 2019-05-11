package com.lzy.pi.service;

import com.lzy.pi.entity.Staff;

public interface SelfService {
    Staff login(String account,String password);
    void changePassword(Integer id,String password);
}
