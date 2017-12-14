create database if not exists bst530;
use bst530;

--
-- Table structure for users
--

drop table if exists group_member;
drop table if exists points;
drop table if exists groups;
drop table if exists users;
create table users (
uid int unsigned not null auto_increment,
lname varchar(20) not null default 'last name',
fname varchar(20) not null default 'first name',
email varchar(50) not null default 'exampleemail@gamil.com',
description varchar(200) not null default 'What do you feel today',
primary key (uid)
)engine=InnoDB default charset=utf8;


--
-- Table structure for points
--

create table points (
pid int unsigned not null auto_increment,
user_id int unsigned not null,
dateTime datetime not null default CURRENT_TIMESTAMP,
latitude double not null,
longtitude double not null,
primary key (pid),
constraint fk_users_pointsid foreign key (user_id) references users(uid) on delete cascade on update cascade 
)engine=InnoDB default charset=utf8;


--
-- Table structure for groups
--

create table groups (
gid int unsigned not null auto_increment,
name varchar(20) not null default 'group name',
description varchar(100) not null default 'what is the conduct for the group',
size int not null default 10,
grouptype varchar(10) not null default 'family',
primary key (gid)
)engine=InnoDB default charset=utf8;


--
-- Table structure for group_member
--


create table group_member (
group_id int unsigned not null,
user_id int unsigned not null,
constraint fk_users_groupmemberid foreign key (user_id) references users(uid) on delete cascade on update cascade,
constraint fk_groups_groupmemberid foreign key (group_id) references groups(gid) on delete cascade on update cascade
)engine=InnoDB default charset=utf8;
