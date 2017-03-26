prompt PL/SQL Developer import file
prompt Created on 2016年10月14日 by Administrator
set feedback off
set define off
prompt Creating CRM_MENU...
create table CRM_MENU
(
  menu_id    NUMBER(10) not null,
  menu_name  VARCHAR2(20),
  parent_id  NUMBER(10),
  menu_url   VARCHAR2(100),
  prompt     VARCHAR2(100),
  menu_level NUMBER(1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table CRM_MENU
  is '此乃菜单表';
alter table CRM_MENU
  add constraint PK_CRM_MENU primary key (MENU_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table CRM_MENU
  add constraint MENU_PARENT_FK foreign key (PARENT_ID)
  references CRM_MENU (MENU_ID);

prompt Creating CRM_MODULE...
create table CRM_MODULE
(
  module_id   NUMBER(10) not null,
  module_name VARCHAR2(20),
  module_url  VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table CRM_MODULE
  is '此乃模块表';
alter table CRM_MODULE
  add constraint PK_CRM_MODULE primary key (MODULE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating CRM_ROLE...
create table CRM_ROLE
(
  role_id   NUMBER(10) not null,
  role_name VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table CRM_ROLE
  is '此乃角色表';
alter table CRM_ROLE
  add constraint PK_CRM_ROLE primary key (ROLE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating CRM_ROLE_MENU...
create table CRM_ROLE_MENU
(
  role_id NUMBER(10) not null,
  menu_id NUMBER(10) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table CRM_ROLE_MENU
  add constraint PK_CRM_ROLE_MENU primary key (ROLE_ID, MENU_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table CRM_ROLE_MENU
  add constraint ROLE_MENU_MENUFK foreign key (MENU_ID)
  references CRM_MENU (MENU_ID);
alter table CRM_ROLE_MENU
  add constraint ROLE_MENU_ROLEFK foreign key (ROLE_ID)
  references CRM_ROLE (ROLE_ID);

prompt Creating CRM_ROLE_MODULE...
create table CRM_ROLE_MODULE
(
  rm_id      NUMBER(10) not null,
  role_id    NUMBER(10),
  module_id  NUMBER(10),
  power_code NUMBER(4)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table CRM_ROLE_MODULE
  add constraint PK_CRM_ROLE_MODULE primary key (RM_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table CRM_ROLE_MODULE
  add constraint RM_ROLE_FK foreign key (ROLE_ID)
  references CRM_ROLE (ROLE_ID);
alter table CRM_ROLE_MODULE
  add constraint ROLE_MODULE_MODULE_FK foreign key (MODULE_ID)
  references CRM_MODULE (MODULE_ID);

prompt Creating CRM_USER...
create table CRM_USER
(
  user_id NUMBER(10) not null,
  uname   VARCHAR2(20),
  email   VARCHAR2(20),
  pwd     VARCHAR2(200)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table CRM_USER
  is '此乃用户表';
alter table CRM_USER
  add constraint PK_CRM_USER primary key (USER_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating CRM_USER_ROLE...
create table CRM_USER_ROLE
(
  role_id NUMBER(10) not null,
  user_id NUMBER(10) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table CRM_USER_ROLE
  is '此乃用户和角色的中间表';
alter table CRM_USER_ROLE
  add constraint PK_CRM_USER_ROLE primary key (ROLE_ID, USER_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table CRM_USER_ROLE
  add constraint USER_FK foreign key (USER_ID)
  references CRM_USER (USER_ID);
alter table CRM_USER_ROLE
  add constraint USER_ROLE_ROLEFK foreign key (ROLE_ID)
  references CRM_ROLE (ROLE_ID);

prompt Disabling triggers for CRM_MENU...
alter table CRM_MENU disable all triggers;
prompt Disabling triggers for CRM_MODULE...
alter table CRM_MODULE disable all triggers;
prompt Disabling triggers for CRM_ROLE...
alter table CRM_ROLE disable all triggers;
prompt Disabling triggers for CRM_ROLE_MENU...
alter table CRM_ROLE_MENU disable all triggers;
prompt Disabling triggers for CRM_ROLE_MODULE...
alter table CRM_ROLE_MODULE disable all triggers;
prompt Disabling triggers for CRM_USER...
alter table CRM_USER disable all triggers;
prompt Disabling triggers for CRM_USER_ROLE...
alter table CRM_USER_ROLE disable all triggers;
prompt Disabling foreign key constraints for CRM_MENU...
alter table CRM_MENU disable constraint MENU_PARENT_FK;
prompt Disabling foreign key constraints for CRM_ROLE_MENU...
alter table CRM_ROLE_MENU disable constraint ROLE_MENU_MENUFK;
alter table CRM_ROLE_MENU disable constraint ROLE_MENU_ROLEFK;
prompt Disabling foreign key constraints for CRM_ROLE_MODULE...
alter table CRM_ROLE_MODULE disable constraint RM_ROLE_FK;
alter table CRM_ROLE_MODULE disable constraint ROLE_MODULE_MODULE_FK;
prompt Disabling foreign key constraints for CRM_USER_ROLE...
alter table CRM_USER_ROLE disable constraint USER_FK;
alter table CRM_USER_ROLE disable constraint USER_ROLE_ROLEFK;
prompt Loading CRM_MENU...
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (22, '客户关系管理系统', null, null, '客户关系管理系统', 1);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (1, '营销管理', 22, null, '营销管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (2, '销售机会管理', 1, null, '销售机会管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (3, '客户开发计划', 1, null, '客户开发计划', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (4, '客户管理', 22, null, '客户管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (5, '客户信息管理', 4, null, '客户信息管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (6, '客户流失管理', 4, null, '客户流失管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (7, '客户流失预警', 6, null, '客户流失预警', 3);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (8, '暂缓客户流失', 6, null, '暂缓客户流失', 3);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (9, '确认客户流失', 6, null, '确认客户流失', 3);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (10, '服务管理', 22, null, '服务管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (11, '服务创建', 10, null, '服务创建', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (12, '服务分配', 10, null, '服务分配', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (13, '统计报表', 22, null, '统计报表', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (14, '客户贡献分析', 13, null, '客户贡献分析', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (15, '客户构成分析', 13, null, '客户构成分析', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (16, '客户服务分析', 13, null, '客户服务分析', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (17, '客户流失分析', 13, null, '客户流失分析', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (18, '系统管理', 22, null, '系统管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (19, '用户管理', 18, 'power/usersAction.action', '用户管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (20, '角色管理', 18, 'power/roleAction!findAll.action', '角色管理', 2);
insert into CRM_MENU (menu_id, menu_name, parent_id, menu_url, prompt, menu_level)
values (21, '菜单管理', 18, 'power/menuAction!findAll.action', '菜单管理', 2);
commit;
prompt 22 records loaded
prompt Loading CRM_MODULE...
insert into CRM_MODULE (module_id, module_name, module_url)
values (10, '模块管理', 'power/moduleAction');
insert into CRM_MODULE (module_id, module_name, module_url)
values (1, '用户管理', 'power/usersAction');
insert into CRM_MODULE (module_id, module_name, module_url)
values (2, '角色管理', 'power/roleAction');
insert into CRM_MODULE (module_id, module_name, module_url)
values (3, '菜单管理', 'power/menuAction');
insert into CRM_MODULE (module_id, module_name, module_url)
values (4, '销售机会管理', 'power/salAction');
insert into CRM_MODULE (module_id, module_name, module_url)
values (5, '客户开发计划', 'power/cousAction');
insert into CRM_MODULE (module_id, module_name, module_url)
values (6, '客户信息管理', 'power/couAction');
insert into CRM_MODULE (module_id, module_name, module_url)
values (7, '服务管理', 'power/serviceAction');
insert into CRM_MODULE (module_id, module_name, module_url)
values (8, '客户流失管理', 'power/cAction');
insert into CRM_MODULE (module_id, module_name, module_url)
values (9, '授权管理', 'power/roleModuleAction');
commit;
prompt 10 records loaded
prompt Loading CRM_ROLE...
insert into CRM_ROLE (role_id, role_name)
values (1, '管理员');
insert into CRM_ROLE (role_id, role_name)
values (2, '客户经理');
insert into CRM_ROLE (role_id, role_name)
values (3, ' 测试');
commit;
prompt 3 records loaded
prompt Loading CRM_ROLE_MENU...
insert into CRM_ROLE_MENU (role_id, menu_id)
values (1, 1);
insert into CRM_ROLE_MENU (role_id, menu_id)
values (1, 2);
insert into CRM_ROLE_MENU (role_id, menu_id)
values (1, 13);
insert into CRM_ROLE_MENU (role_id, menu_id)
values (1, 14);
insert into CRM_ROLE_MENU (role_id, menu_id)
values (1, 15);
insert into CRM_ROLE_MENU (role_id, menu_id)
values (1, 16);
insert into CRM_ROLE_MENU (role_id, menu_id)
values (1, 17);
insert into CRM_ROLE_MENU (role_id, menu_id)
values (1, 18);
insert into CRM_ROLE_MENU (role_id, menu_id)
values (1, 19);
insert into CRM_ROLE_MENU (role_id, menu_id)
values (1, 20);
insert into CRM_ROLE_MENU (role_id, menu_id)
values (1, 21);
insert into CRM_ROLE_MENU (role_id, menu_id)
values (1, 22);
commit;
prompt 12 records loaded
prompt Loading CRM_ROLE_MODULE...
insert into CRM_ROLE_MODULE (rm_id, role_id, module_id, power_code)
values (8, 1, 1, 9);
insert into CRM_ROLE_MODULE (rm_id, role_id, module_id, power_code)
values (2, 1, 4, 2);
insert into CRM_ROLE_MODULE (rm_id, role_id, module_id, power_code)
values (3, 1, 6, 6);
insert into CRM_ROLE_MODULE (rm_id, role_id, module_id, power_code)
values (4, 1, 5, 1);
insert into CRM_ROLE_MODULE (rm_id, role_id, module_id, power_code)
values (5, 1, 3, 15);
insert into CRM_ROLE_MODULE (rm_id, role_id, module_id, power_code)
values (6, 1, 2, 15);
insert into CRM_ROLE_MODULE (rm_id, role_id, module_id, power_code)
values (7, 1, 9, 15);
insert into CRM_ROLE_MODULE (rm_id, role_id, module_id, power_code)
values (1, 3, 9, 1);
insert into CRM_ROLE_MODULE (rm_id, role_id, module_id, power_code)
values (9, 1, 10, 15);
commit;
prompt 9 records loaded
prompt Loading CRM_USER...
insert into CRM_USER (user_id, uname, email, pwd)
values (1, 'admin', 'admin@admin.com', 'admin');
commit;
prompt 1 records loaded
prompt Loading CRM_USER_ROLE...
insert into CRM_USER_ROLE (role_id, user_id)
values (1, 1);
insert into CRM_USER_ROLE (role_id, user_id)
values (2, 1);
commit;
prompt 2 records loaded
prompt Enabling foreign key constraints for CRM_MENU...
alter table CRM_MENU enable constraint MENU_PARENT_FK;
prompt Enabling foreign key constraints for CRM_ROLE_MENU...
alter table CRM_ROLE_MENU enable constraint ROLE_MENU_MENUFK;
alter table CRM_ROLE_MENU enable constraint ROLE_MENU_ROLEFK;
prompt Enabling foreign key constraints for CRM_ROLE_MODULE...
alter table CRM_ROLE_MODULE enable constraint RM_ROLE_FK;
alter table CRM_ROLE_MODULE enable constraint ROLE_MODULE_MODULE_FK;
prompt Enabling foreign key constraints for CRM_USER_ROLE...
alter table CRM_USER_ROLE enable constraint USER_FK;
alter table CRM_USER_ROLE enable constraint USER_ROLE_ROLEFK;
prompt Enabling triggers for CRM_MENU...
alter table CRM_MENU enable all triggers;
prompt Enabling triggers for CRM_MODULE...
alter table CRM_MODULE enable all triggers;
prompt Enabling triggers for CRM_ROLE...
alter table CRM_ROLE enable all triggers;
prompt Enabling triggers for CRM_ROLE_MENU...
alter table CRM_ROLE_MENU enable all triggers;
prompt Enabling triggers for CRM_ROLE_MODULE...
alter table CRM_ROLE_MODULE enable all triggers;
prompt Enabling triggers for CRM_USER...
alter table CRM_USER enable all triggers;
prompt Enabling triggers for CRM_USER_ROLE...
alter table CRM_USER_ROLE enable all triggers;
set feedback on
set define on
prompt Done.
