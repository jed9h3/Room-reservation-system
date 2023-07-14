create database BZU;
use BZU;
create table Floors(Fid integer primary key);
create table Apartments(Aid integer primary key,Fid integer,foreign key(Fid) references Floors (Fid));
create table Rooms(Rid integer primary key,Rstatus integer,Rprice integer,Rtype integer,Aid integer, foreign key(Aid) references Apartments(Aid));
create table Students(Sid integer primary key,Sname varchar(50),Sdob date);
create table Students_phones(Sid integer,Sphone bigint,primary key (Sid,Sphone),foreign key (Sid) references Students(Sid) ON DELETE CASCADE  );
create table Employees(Eid integer primary key,Ename varchar(50),Edob date);
create table Employees_phones(Eid integer,Ephone bigint,primary key (Eid,Ephone),foreign key (Eid) references Employees(Eid) ON DELETE CASCADE  );
create table Payments(Pay_date date,Sid integer,Payed_amount integer,primary key(Pay_date,Sid),foreign key(Sid) references Students(Sid) ON DELETE CASCADE  );
create table Rent(Sid integer,Rid integer,Start_date date,Eid integer,End_date date,Req_amount int,primary key(Sid,Rid,Start_date),foreign key(Sid) references Students(Sid) ON DELETE CASCADE  ,foreign key(Rid)references Rooms(Rid),foreign key(Eid) references Employees(Eid));
insert into Floors value(1);
insert into Floors value(2);
insert into Floors value(3);
insert into Apartments value(100,1);
insert into Apartments value(200,1);
insert into Apartments value(300,2);
insert into Apartments value(400,2);
insert into Apartments value(500,3);
insert into Rooms value(1000,0,600,0,100);
insert into Rooms value(2000,0,600,0,100);
insert into Rooms value(3000,0,600,0,200);
insert into Rooms value(4000,0,600,0,200);
insert into Rooms value(5000,0,600,0,300);
insert into Rooms value(6000,0,600,0,300);
insert into Rooms value(7000,0,600,0,400);
insert into Rooms value(8000,0,600,0,400);
insert into Rooms value(9000,0,600,0,500);
insert into Rooms value(10000,0,600,0,500);
insert into Employees value(20,'khalid','1990-05-09');
insert into Employees value(20,'Amier','1989-11-08');





