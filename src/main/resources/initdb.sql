use gym;
drop table if exists user;
CREATE TABLE User(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  firstname VARCHAR(255) NOT NULL,
  middlename VARCHAR(255)DEFAULT NULL,
  lastname VARCHAR(255)NOT NULL,
  age INT not NULL ,
  experience INT not NULL ,
  registered TIMESTAMP DEFAULT now()
);
INSERT INTO User (firstname, lastname, age, experience) VALUES ('Федор', 'Емельяненко',40, 99);