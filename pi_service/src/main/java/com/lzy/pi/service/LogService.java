package com.lzy.pi.service;

import com.lzy.pi.entity.Log;

import java.util.List;

public interface LogService {
    //记录系统日志
    void addSystemLog(Log log);
    //登录日志
    void addLoginLog(Log log);
    //操作日志
    void addOperationLog(Log log);

    List<Log> getSystemLog();
    List<Log> getLoginLog();
    List<Log> getOperationLog();
}
