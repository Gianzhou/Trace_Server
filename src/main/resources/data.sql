use bst530;
insert into users(fname, lname) values('join','smith');
insert into users(fname, lname) values('Tom','Black');

insert into users(fname, lname) values('Alex', 'kong');
insert into users(fname, lname) values('Lela', 'Huang');


insert into groups(name) values('bst530group');
insert into groups(name, grouptype, size) values('pcDepartment', 'business', 100);

insert into group_member(user_id, group_id) values(1,1);
insert into group_member(user_id, group_id) values(2,1);

insert into group_member(user_id, group_id) values(3,2);
insert into group_member(user_id, group_id) values(4,2);