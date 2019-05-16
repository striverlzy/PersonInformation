# PersonInformation
基于Spring+MyBatis+Servlet整合的人员信息管理系统。

主要实现的功能是部门与员工信息的增删改查以及日志处理（登录日志、系统日志、操作日志）。<br>


·三层架构<br>
--持久层 MyBatis<br>
--表现层 Servlet+JSP<br>
--Spring 管理对象、切面处理<br>

·基于MVC模式<br>
--视图Jsp<br>
--模型 JavaBean<br>
--控制器 Servlet+JavaBean<br>

部门管理
·部门信息的增删改查
·步骤
--实体类
--Dao接口与sql映射文件（持久层）
--Service接口与其实现类（业务层）
--控制器（表现层）
--页面（表现层）

员工管理
·员工信息的增删改查
··员工与部门的关联关系
--默认登录密码

登录与个人中心
·登录、退出、个人信息、修改密码
·Serssion操作
·登录过滤器

日志处理
·日志查看、自动记录
--业务功能设计
--通知处理
