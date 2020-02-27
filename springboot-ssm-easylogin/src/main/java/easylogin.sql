create table user(
id int(11) primary key,
username varchar(45) default NULL,
password varchar(45) default NULL
);


alter table user change id 
  id int(11) auto_increment;
  
  
alter table user add unique (username);