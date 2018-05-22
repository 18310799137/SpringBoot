--创建数据库名称 mydatabase 设置编码为utf-8
create database mydatabase character set utf8;
-- 切换到数据库 mydatabase  
use mydatabase;
-- 如果存在表 t_user 则删除
drop table  if exists t_user;
-- 创建表 t_user
create table t_user(id int,name varchar(20),age int);
-- 在表t_user中添加两条数据
insert into t_user values(1,'zhangsan',30);
insert into t_user values(2,'李四',30); 