CREATE DATABASE Camping_Tour_Management;
USE Camping_Tour_Management;

CREATE TABLE tbl_account(
	id int primary key auto_increment,
	username nvarchar(255) not null,
	password nvarchar(255) not null,
	role nvarchar(255) not null
);

CREATE TABLE tbl_team(
	id int primary key auto_increment,
	code nvarchar(255) not null,
	name nvarchar(255) not null
);

CREATE TABLE tbl_customer(
	id int primary key auto_increment,
	code nvarchar(255) not null,
	firstName nvarchar(255) not null,
	lastName nvarchar(255) not null,
	birthDate varchar(255) not null,
	address nvarchar(255) not null,
	phoneNumber nvarchar(255) not null,
	email nvarchar(255) not null,
    imagePath nvarchar(255) not null,
    accountId int not null,
	teamId int not null,
	foreign key (teamId) references tbl_team(id) On DELETE CASCADE,
    foreign key (accountId) references tbl_account(id) On DELETE CASCADE 
);

CREATE TABLE tbl_destinate(
	id int primary key auto_increment,
	code nvarchar(255) not null,
	name nvarchar(255) not null,
	description nvarchar(255) not null,
    timeStay nvarchar(255) not null,
    sleepPlace nvarchar(255) not null,
	address nvarchar(255) not null
);

CREATE TABLE tbl_guide(
    id int primary key auto_increment,
    code nvarchar(255) not null, 
    firstName nvarchar(255) not null,
    lastName nvarchar(255) not null, 
    birthDate varchar(255) not null,
    address nvarchar(255) not null,
    phoneNumber nvarchar(255) not null,
    imagePath nvarchar(255) not null,
    email nvarchar(255) not null,
    accountId int not null,
    foreign key (accountId) references tbl_account(id) On DELETE CASCADE
);

CREATE TABLE tbl_tour(
	id int primary key auto_increment,
	code nvarchar(255) not null,
	name nvarchar(255) not null,
	description nvarchar(255) not null,
	startDate nvarchar(255) not null,
	destinateId int not null,
	guideId int,
	price int not null,
	availables int not null,
	Foreign key (destinateId) references tbl_destinate(id) On DELETE CASCADE,
	Foreign key (guideId) references tbl_guide(id) On DELETE CASCADE
);

CREATE TABLE tbl_customer_tour(
	customerId int not null,
	tourId int not null,
	rate float not null,
	Foreign key (customerId) references tbl_customer(id) On DELETE CASCADE,
	Foreign key (tourId) references tbl_tour(id) On DELETE CASCADE
);

insert into tbl_account values(1,"admin","1","Toàn quyền hệ thống");

insert into tbl_team values(1,"KTPM01","Kỹ thuật phần mềm 01");
insert into tbl_team values(2,"KTPM02","Kỹ thuật phần mềm 02");
insert into tbl_team values(3,"KTPM03","Kỹ thuật phần mềm 03");
insert into tbl_team values(4,"KTPM04","Kỹ thuật phần mềm 04");

insert into tbl_account values(2,"HD01","HD01","Tài khoản hướng dẫn viên");
insert into tbl_account values(3,"HD02","HD02","Tài khoản hướng dẫn viên");
insert into tbl_account values(4,"KH01","KH01","Tài khoản khách hàng");
insert into tbl_account values(5,"KH02","KH02","Tài khoản khách hàng");
insert into tbl_account values(6,"KH03","KH03","Tài khoản khách hàng");
insert into tbl_account values(7,"KH04","KH04","Tài khoản khách hàng");
insert into tbl_account values(8,"KH05","KH05","Tài khoản khách hàng");
insert into tbl_account values(9,"KH06","KH06","Tài khoản khách hàng");
insert into tbl_account values(10,"KH07","KH07","Tài khoản khách hàng");

insert into tbl_guide values(2,"HD01","Lân","Nguyễn Văn","20/04/1999","Hà Nội","0123456789","src\\images\\user.png","lan@gmail.com",2);
insert into tbl_guide values(3,"HD02","Lan","Trần Văn","15/04/1997","Hà Nội","0123456789","src\\images\\user.png","lantran@gmail.com",3);

insert into tbl_customer values(4,"KH01","Anh","Lưu Hoàng","04/02/2004","Hà Nội","0383291503","anh@gmail.com","src\\images\\user.png",4,3);
insert into tbl_customer values(5,"KH02","Anh","Đỗ Tuấn","10/06/2004","Thái Nguyên","0383291503","anh@gmail.com","src\\images\\user.png",5,3);
insert into tbl_customer values(6,"KH03","Ngân","Nguyễn Thị Kim","10/06/2004","Hà Nội","0383291503","ngan@gmail.com","src\\images\\user.png",6,3);
insert into tbl_customer values(7,"KH04","Văn","Đào Ngọc","05/04/2004","Hưng Yên","0383291503","van@gmail.com","src\\images\\user.png",7,3);
insert into tbl_customer values(8,"KH05","Anh","Lê Ngọc","05/05/2004","Hưng Yên","0383291503","anh@gmail.com","src\\images\\user.png",8,4);
insert into tbl_customer values(9,"KH06","Liễu","Phạm Thị","10/04/2004","Hà Nam","0383291503","lieu@gmail.com","src\\images\\user.png",9,4);
insert into tbl_customer values(10,"KH07","Hiệp","Đào Ngọc","10/10/2004","Hưng Yên","123456789","hiep@gmail.com","src\\images\\user.png",10,4);

insert into tbl_destinate values(1,"DN01","Hồ Tuyền Lâm","Không có","2 ngày 1 đêm","Ngủ lều","Đà Lạt");
insert into tbl_destinate values(2,"DN02","Đảo Bãi Cóc","Không có","2 ngày 2 đêm","Ngủ lều","Bà Rịa–Vũng Tàu");
insert into tbl_destinate values(3,"DN03","Đảo Robinson Nha Trang","Không có","2 ngày 2 đêm","Ngủ lều","Khánh Hòa");

Insert into tbl_tour values(1,"TQ01","Tour Cắm Trại Trong Rừng Ở Hồ Tuyền Lâm Đà Lạt","2 Ngày 1 Đêm Năm 2024","10/12/2024",1,2,650000,60);
Insert into tbl_tour values(2,"TQ02","Tour Cắm Trại - Câu Cá - Bãi Cóc - Vịnh Vĩnh Hy - Ninh Chữ","2 Ngày 2 Đêm Năm 2024","20/12/2024",2,2,1990000,80);
Insert into tbl_tour values(3,"TQ03","Tour Cắm Trại Câu Cá - Mực Ở Đảo Robinson Nha Trang","2 Ngày 2 Đêm Năm 2024","25/12/2024",3,3,1990000,60);

INSERT INTO tbl_customer_tour VALUES (4,1,0);
INSERT INTO tbl_customer_tour VALUES (4,2,0);
INSERT INTO tbl_customer_tour VALUES (4,3,0);
INSERT INTO tbl_customer_tour VALUES (5,1,0);
INSERT INTO tbl_customer_tour VALUES (5,2,0);
INSERT INTO tbl_customer_tour VALUES (6,1,0);
INSERT INTO tbl_customer_tour VALUES (7,1,0);
DROP DATABASE Camping_Tour_Management;

