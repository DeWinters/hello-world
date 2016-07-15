CREATE SCHEMA funwithspring;

CREATE TABLE funwithspring.users (
  id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  age INT NULL,
  PRIMARY KEY (id));

CREATE TABLE funwithspring.sale (
  invoice INT NOT NULL AUTO_INCREMENT,
  memberid INT NULL,
  itemid VARCHAR(45) NULL,
  date VARCHAR(45) NULL,
  price FLOAT NULL,
  PRIMARY KEY (invoice));

CREATE TABLE funwithspring.item (
  itemid TEXT NULL,
  itemname VARCHAR(45) NULL,
  price INT NULL,
  PRIMARY KEY (itemid));
