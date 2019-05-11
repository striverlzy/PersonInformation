package com.lzy.pi.dao;


import com.lzy.pi.entity.Staff;
import org.springframework.stereotype.Repository;
/**
 * 定义接口
 */
@Repository("selfDao")
public interface SelfDao {
    //从staff传来一个账户名，即传来一个员工对象。根据输入的password与对象里的password做对比
    //防止sql注入
    Staff selectByAccount(String account);
}
