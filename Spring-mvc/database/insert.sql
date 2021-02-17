use newspring1month2021;

insert into role(code, name) values('ADMIN', 'Quản trị hệ thống');
insert into role(code, name) values('USER', 'Người dùng')

insert into user(username, password, fullname, status)
values('admin', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 'Huỳnh Bá Thắng', 1);
insert into user(username, password, fullname, status)
values('user', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 'Phạm Thị Minh Thủy', 1);

insert into user_role values(1, 1);
insert into user_role values(2, 2);