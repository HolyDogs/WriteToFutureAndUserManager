# WriteToFutureAndUserManage
## 写给未来的信+用户管理系统##
=============================

### `功能`：

------------------------

普通用户登陆普通用户界面，把用户写下的邮件保存在数据库，后台定时器每天对数据库进行检查，如果发现日期与今天相同，用Service实现类把内容提取出来交给邮件发送工具类发送，并在库内删除对应条目。\<br>登陆管理用户，可以对登陆的用户进行管理。

 

### 【相关环境】:

·java8

·Apache Tomcat v9.0

·Apache Maven 3.5.4

·MySQL 8.0
