# PersonInformation
基于Spring+MyBatis+Servlet整合的人员信息管理系统。
·三层架构
--持久层 MyBatis
--表现层 Servlet+JSP
--Spring 管理对象、切面处理

·基于MVC模式
--视图Jsp
--模型 JavaBean
--控制器 Servlet+JavaBean

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
