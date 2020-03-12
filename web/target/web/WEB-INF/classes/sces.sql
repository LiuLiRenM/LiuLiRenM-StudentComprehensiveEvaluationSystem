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