-- # This compiled on  www.sqlfiddle.com  with MySQL 5.6


-- # DB Editor

-- Make "Users" table, add entries

Create Table Users(
  id int NOT NULL,
  username varchar(255) NOT NULL,
  pass varchar(255) NOT NULL,
  age int NOT NULL,
  PRIMARY KEY (id)
);

Insert Into Users (id, username, pass, age)
Values ( 1, "user1", "pass1", 17 );

Insert Into Users (id, username, pass, age)
Values ( 2, "user2", "pass2", 16 );

Insert Into Users (id, username, pass, age)
Values ( 3, "user3", "pass3", 15 );



-- Make "Posts" table, add entries

Create Table Posts(
  id int NOT NULL,
  userId int NOT NULL,
  postContent varchar(700) NOT NULL,
  PRIMARY KEY (id)
);

Insert Into Posts (id, userId, postContent)
Values ( 1, 1, "This is post1 (made by user 1)");

Insert Into Posts (id, userId, postContent)
Values ( 2, 1, "This is post2 (made by user 1)");

Insert Into Posts (id, userId, postContent)
Values ( 3, 2, "This is post3 (made by user 2)");

Insert Into Posts (id, userId, postContent)
Values ( 4, 2, "This is post3 (made by user 2)");

Insert Into Posts (id, userId, postContent)
Values ( 5, 3, "This is post3 (made by user 3)");





-- # Query commands

-- Query for finding 2 users
Select id, username, pass, age from Users Where id = 1 OR username = "user3";

-- Query for finding the posts of 2 users
Select id, postContent from Posts Where userId = ( Select id from Users where username="user1" ) OR userId = 3;


