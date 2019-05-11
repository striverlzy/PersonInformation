package com.lzy.pi.entity;


import java.util.Date;

/**
 * 日志实体类
 */
public class Log {
    private Date oprTime;//操作时间
    private String type;//类型：系统日志、登录日志、操作日志
    private String operator;//操作员
    private String moudle;//在哪个部分
    private String operation;//进行什么操作
    private String result;//结果是什么

    public Date getOprTime() {
        return oprTime;
    }

    public void setOprTime(Date oprTime) {
        this.oprTime = oprTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getMoudle() {
        return moudle;
    }

    public void setMoudle(String moudle) {
        this.moudle = moudle;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
