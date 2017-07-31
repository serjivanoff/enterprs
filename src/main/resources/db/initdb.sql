use gym;
drop table if EXISTS contacts;
drop table if EXISTS addresses;
drop table if exists users;

CREATE TABLE users(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  firstname VARCHAR(255) NOT NULL,
  middlename VARCHAR(255)DEFAULT NULL,
  lastname VARCHAR(255)NOT NULL,
  age INT not NULL ,
  experience INT not NULL ,
  registered TIMESTAMP DEFAULT now()
);

CREATE TABLE addresses(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  country VARCHAR(32),
  city VARCHAR(32),
  street VARCHAR(32)
);

CREATE TABLE contacts(
  user_id INT,
  phone VARCHAR (20),
  email VARCHAR(20),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  address_id INT,
  FOREIGN KEY (address_id) REFERENCES addresses(id) ON DELETE CASCADE
);

INSERT INTO users (firstname, lastname, age, experience) VALUES ('Firstame', 'Secondnameson',40, 999);
INSERT INTO addresses(country, city, street) VALUES ('USA','NY','1-st Avenue');
INSERT INTO contacts VALUES (1,'+7-123-4567891','mail@dot.com',1);