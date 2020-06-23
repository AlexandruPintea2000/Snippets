-- # This compiled on  www.sqlfiddle.com  with MySQL 5.6


-- # DB Editor

-- Make "Buyers" table
Create table Buyers (
  id int NOT NULL,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  user_name varchar(255) NOT NULL,
  pass varchar(255) NOT NULL,
  sum_spent double NOT NULL,
  age int NOT NULL,
  PRIMARY KEY (id)
);

-- Make "Orders" table
Create table Orders (
  id int NOT NULL,
  buyer_id int NOT NULL,
  order_name varchar(255) NOT NULL,
  price double NOT NULL,
  sent boolean NOT NULL,
  Primary Key (id),
  Foreign Key (buyer_id) References Buyers(id)
);


-- Add "Buyer"-s
Insert Into Buyers 
Values (1, "first1", "last1", "user1", "pass1", 15.9, 17);

Insert Into Buyers 
Values (2, "first2", "last2", "user2", "pass2", 23.17, 16);

Insert Into Buyers 
Values (3, "first3", "last3", "user3", "pass3", 125.9, 25);

Insert Into Buyers -- deleted later
Values (4, "first4", "last4", "user4", "pass4", 14.7, 14);

Insert Into Buyers 
Values (5, "first5", "last5", "user5", "pass5", 13.5, 23);


-- Add "Order"-s
Insert Into Orders 
Values (1, 5, "Order 1 by user5", 15.7, true);

Insert Into Orders 
Values (2, 3, "Order 1 by user3", 47.1, false);

Insert Into Orders 
Values (3, 2, "Order 1 by user2", 14.5, true);

Insert Into Orders 
Values (4, 1, "Order 1 by user1", 15.7, false);

Insert Into Orders 
Values (5, 5, "Order 2 by user5", 71.4, false);

Insert Into Orders 
Values (6, 5, "Order 3 by user5", 6715.3, true);

Insert Into Orders 
Values (7, 3, "Order 2 by user3", 15.54, true);


-- Modify table data:

-- Modify a user_name
UPDATE Buyers
SET user_name = "new user_name"
WHERE id = 1;

-- Delete a buyer by age
DELETE FROM Buyers WHERE age = 14;

-- Delete an order
DELETE FROM Orders WHERE id = 2;





-- # Query commands

-- Selects Buyer details of users that have age <= 17
SELECT id, age, user_name FROM Buyers Where age <= 17 Order By age;

-- Finds the maximum age of a Buyer, how many Buyers there are, their average age and how much they've spent
SELECT MAX(age) As MaxAges, COUNT(id) AS Number_Of_Buyers, Avg(age) as Average_Age, Sum(sum_spent) As Spendings_total
FROM Buyers;

-- Finds all Buyers that have a username that commences with "user"
SELECT id, user_name, first_name, last_name From Buyers Where user_name LIKE 'user%';

-- Use of the IN operator 
SELECT id, age, user_name From Buyers Where age in (17, 23);

-- Use of the BETWEEN operator 
SELECT id, age, user_name From Buyers Where age BETWEEN 11 and 23;

-- An Inner Join
Select Orders.id, Buyers.first_name, Buyers.last_name, Orders.price, Orders.order_name
From Orders
Inner Join Buyers ON Orders.buyer_id = Buyers.id Order By Orders.price DESC;

-- Use of the UNION operator (find the buyers that have ordered)
Select id From Buyers
UNION
Select buyer_id From Orders;

-- Use of the GROUP BY statement
Select user_name From Buyers Group By user_name DESC;

-- Use of ANY operator (find all buyers but the one with max age)
SELECT id, age, user_name
FROM Buyers
WHERE age < ANY
(SELECT age FROM Buyers);


