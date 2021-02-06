use newspring1month2021;

insert into role(code, name) values('MANAGER', 'Quản trị hệ thống');
insert into role(code, name) values('USER', 'Người dùng')

insert into user(username, password, fullname, status)
values('admin', 'e10adc3949ba59abbe56e057f20f883e', 'Huỳnh Bá Thắng', 1);
insert into user(username, password, fullname, status)
values('user', 'e10adc3949ba59abbe56e057f20f883e', 'Phạm Thị Minh Thủy', 1);

insert into user_role values(1, 1);
insert into user_role values(2, 2);