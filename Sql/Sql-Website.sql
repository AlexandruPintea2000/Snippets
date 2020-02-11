-- #This compiled on  www.sqlfiddle.com  with MySQL 5/6


-- #DB Editor

Create Table Customers(
  id int NOT NULL,
  name varchar(255) NOT NULL,
  age int NOT NULL,
  PRIMARY KEY (id)
);

Insert Into Customers (id, name, age)
Values ( 0, "user1", 17 );

Insert Into Customers (id, name, age)
Values ( 2, "user2", 16 );

Insert Into Customers (id, name, age)
Values ( 3, "user3", 15 );





-- #Query commands

Select id, name, age from Customers Where id = 0 OR name = "user3";


