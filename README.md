# PersonInformation
基于Spring+MyBatis+Servlet整合的人员信息管理系统。

主要实现的功能是部门与员工信息的增删改查以及日志处理（登录日志、系统日志、操作日志）。<br>


### ·三层架构<br>
--持久层 MyBatis<br>
--表现层 Servlet+JSP<br>
--Spring 管理对象、切面处理<br>

### ·基于MVC模式<br>
--视图Jsp<br>
--模型 JavaBean<br>
--控制器 Servlet+JavaBean<br>

### 部门管理<br>
·部门信息的增删改查<br>
·步骤<br>
--实体类<br>
--Dao接口与sql映射文件（持久层）<br>
--Service接口与其实现类（业务层）<br>
--控制器（表现层）<br>
--页面（表现层）<br>
![image](https://github.com/striverlzy/PersonInformation/blob/master/1.png)<br>

### 员工管理<br>
·员工信息的增删改查<br>
··员工与部门的关联关系<br>
--默认登录密码<br>
![image](https://github.com/striverlzy/PersonInformation/blob/master/2.png)<br>

### 登录与个人中心<br>
·登录、退出、个人信息、修改密码<br>
·Serssion操作<br>
·登录过滤器<br>
![image](https://github.com/striverlzy/PersonInformation/blob/master/5.png)<br>

### 日志处理<br>
·日志查看、自动记录<br>
--业务功能设计<br>
--通知处理<br>
![image](https://github.com/striverlzy/PersonInformation/blob/master/3.png)<br>
![image](https://github.com/striverlzy/PersonInformation/blob/master/4.png)<br>

### [欢迎访问我的博客](https://blog.csdn.net/qq_41937388)


