CREATE SCHEMA funwithspring;

CREATE TABLE funwithspring.users (
  id INT NOT NULL AUTO_INCREMENT,
  invoiceName VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  age INT NULL,
  //invoice_num TEXT(11),
  //date_stamp Date,
  //client TEXT(45),
  //driver text(45),
  //origin text(45),
  //destination text(45),
  //retour Boolean,
  //wknd Boolean,
  //human Boolean,
  //prise Boolean,
  //interne Boolean,
  //urgence Boolean,
  //abusive Boolean,
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

/** new table **/
CREATE TABLE funwithspring.tarif (
  tarif_id INT NOT NULL AUTO_INCREMENT,
  stop1 TEXT(45) NULL,
  stop2 TEXT(45) NULL,
  tarif_rate float,
  region Text(45),
  PRIMARY KEY (tarif_id));
