create database ses;
use ses;

drop table if exists user_role;
drop table if exists user;
drop table if exists role;


create table user(
    id varchar(50) PRIMARY KEY,
    username varchar(32),
    password varchar(32)
);

create table role(
    id varchar(50) PRIMARY KEY,
    roleName varchar(32),
    roleDesc varchar(32)
);

create table user_role(
    userId varchar(50),
    roleId varchar(50),
    primary key(userId, roleId),
    foreign key(userId) references user(id),
    foreign key(roleId) references role(id)
);

insert into user(id, username, password) values (uuid(), "admin", "admin");
insert into user(id, username, password) values (uuid(), "2016101825", "101825");
insert into user(id, username, password) values (uuid(), "1984992122", "640108");

insert into role(id, roleName, roleDesc) values (uuid(), "ADMIN", "管理员");
insert into role(id, roleName, roleDesc) values (uuid(), "STUDENT", "学生");
insert into role(id, roleName, roleDesc) values (uuid(), "TEACHER", "教师");


/*insert into user_role(userId, roleId) VALUES ("user表的uuid", "role表的uuid");
insert into user_role(userId, roleId) VALUES ("user表的uuid", "role表的uuid");
insert into user_role(userId, roleId) VALUES ("user表的uuid", "role表的uuid");
insert into user_role(userId, roleId) VALUES ("user表的uuid", "role表的uuid");*/


insert into permission(id) value (uuid());

alter table permission change permissionId permissionId varchar(4);
alter table permission change parPermissionId parPermissionId varchar(4);

drop table role_permission;
drop table permission;

create table permission(
    id varchar(50) primary key,
    permissionName varchar(30),
    permissionId varchar(4)
);

alter table permission add parPermissionId int;

create table role_permission(
    roleId varchar(50),
    permissionId varchar(50),
    primary key(roleId, permissionId),
    foreign key (roleId) references role(id),
    foreign key (permissionId) references permission(id)
);


insert into role_permission(roleId, permissionId) VALUES ("022a39cc-62aa-11ea-8bc3-0242ac110002", "bc7661a7-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("022a39cc-62aa-11ea-8bc3-0242ac110002", "bcd61bde-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("022a39cc-62aa-11ea-8bc3-0242ac110002", "bd359f88-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("022a39cc-62aa-11ea-8bc3-0242ac110002", "bbd163bc-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("022a39cc-62aa-11ea-8bc3-0242ac110002", "bda81b55-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("022a39cc-62aa-11ea-8bc3-0242ac110002", "bdfaf2f4-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("022a39cc-62aa-11ea-8bc3-0242ac110002", "be4cba34-651f-11ea-b102-0242ac110002");

insert into role_permission(roleId, permissionId) VALUES ("02391c16-62aa-11ea-8bc3-0242ac110002", "ba8cf238-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("02391c16-62aa-11ea-8bc3-0242ac110002", "bad0d8aa-651f-11ea-b102-0242ac110002");

insert into role_permission(roleId, permissionId) VALUES ("024da70d-62aa-11ea-8bc3-0242ac110002", "bb6d42e9-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("024da70d-62aa-11ea-8bc3-0242ac110002", "bb2014be-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("024da70d-62aa-11ea-8bc3-0242ac110002", "bbd163bc-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("024da70d-62aa-11ea-8bc3-0242ac110002", "bc1f3dca-651f-11ea-b102-0242ac110002");

create table buttion(
    id varchar(50) primary key,
    buttonName varchar(30),
    parMenu varchar(4),
    url varchar(50),
    foreign key (parMenu) references permission(id)
);

alter table buttion rename to button;

alter table button change parMenu parMenu varchar(50);
insert into button(id) value (uuid());

insert into permission(id) value (uuid());

alter table permission change permissionId permissionId varchar(4);
alter table permission change parPermissionId parPermissionId varchar(4);

drop table role_permission;
drop table permission;

create table permission(
                           id varchar(50) primary key,
                           permissionName varchar(30),
                           permissionId varchar(4)
);

alter table permission add parPermissionId int;

create table role_permission(
                                roleId varchar(50),
                                permissionId varchar(50),
                                primary key(roleId, permissionId),
                                foreign key (roleId) references role(id),
                                foreign key (permissionId) references permission(id)
);


insert into role_permission(roleId, permissionId) VALUES ("022a39cc-62aa-11ea-8bc3-0242ac110002", "bc7661a7-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("022a39cc-62aa-11ea-8bc3-0242ac110002", "bcd61bde-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("022a39cc-62aa-11ea-8bc3-0242ac110002", "bd359f88-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("022a39cc-62aa-11ea-8bc3-0242ac110002", "bbd163bc-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("022a39cc-62aa-11ea-8bc3-0242ac110002", "bda81b55-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("022a39cc-62aa-11ea-8bc3-0242ac110002", "bdfaf2f4-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("022a39cc-62aa-11ea-8bc3-0242ac110002", "be4cba34-651f-11ea-b102-0242ac110002");

insert into role_permission(roleId, permissionId) VALUES ("02391c16-62aa-11ea-8bc3-0242ac110002", "ba8cf238-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("02391c16-62aa-11ea-8bc3-0242ac110002", "bad0d8aa-651f-11ea-b102-0242ac110002");

insert into role_permission(roleId, permissionId) VALUES ("024da70d-62aa-11ea-8bc3-0242ac110002", "bb6d42e9-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("024da70d-62aa-11ea-8bc3-0242ac110002", "bb2014be-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("024da70d-62aa-11ea-8bc3-0242ac110002", "bbd163bc-651f-11ea-b102-0242ac110002");
insert into role_permission(roleId, permissionId) VALUES ("024da70d-62aa-11ea-8bc3-0242ac110002", "bc1f3dca-651f-11ea-b102-0242ac110002");

create table buttion(
                        id varchar(50) primary key,
                        buttonName varchar(30),
                        parMenu varchar(4),
                        url varchar(50),
                        foreign key (parMenu) references permission(id)
);

alter table buttion rename to button;
alter table button rename to menu;

alter table button change parMenu parMenu varchar(50);
insert into button(id) value (uuid());

alter table menu change buttonName menuName varchar(30);

insert into menu(id) value (uuid());

select * from permission where id = "bbd163bc-651f-11ea-b102-0242ac110002";
select * from menu where parMenu = "bbd163bc-651f-11ea-b102-0242ac110002";

select * from user where username = "1984992122";
select * from user_role where userId = "2723a6d9-61f8-11ea-8bc3-0242ac110002";
select * from role where id = "024da70d-62aa-11ea-8bc3-0242ac110002";
select * from role_permission where roleId = "024da70d-62aa-11ea-8bc3-0242ac110002";
select * from permission where id in (select permissionId from role_permission where roleId = "024da70d-62aa-11ea-8bc3-0242ac110002");

select * from user where username = "admin";
select * from user_role where userId = "c4e1cf0b-61f6-11ea-8bc3-0242ac110002";
select * from permission where id in (select permissionId from role_permission where roleId = "022a39cc-62aa-11ea-8bc3-0242ac110002");
select * from permission where id in (select permissionId from role_permission where roleId = "024da70d-62aa-11ea-8bc3-0242ac110002");

use ses;

delete from menu where id = "c2828b6b-6525-11ea-b102-0242ac110002";
delete from menu where id = "c2aa7a7f-6525-11ea-b102-0242ac110002" and menuName = "修改学生信息";
delete from menu where id = "c2d77798-6525-11ea-b102-0242ac110002" and menuName = "添加学生信息";

select * from menu where menuName = "添加学生信息";

alter table menu add logo varchar(20);
