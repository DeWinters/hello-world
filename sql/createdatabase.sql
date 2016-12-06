CREATE SCHEMA funwithspring;

CREATE TABLE funwithspring.users (
  id INT NOT NULL AUTO_INCREMENT,
  invoiceName VARCHAR(45) NULL, //dead
  password VARCHAR(45) NULL,    //dead
  age INT NULL,                 //dead
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


select * from invoice where collection_time between '2016-11-01 00:00:00' and '2016-11-01 00:00:00'


insert into route (id_origin, id_destined, day_tarif, night_tarif)values
(25,11,35.00,35.00),
(25,12,27.50,27.50),
(25,13,25.00,25.00),
(25,14,25.00,25.00),
(25,15,25.00,25.00),

(25,17,27.50,27.50),
(25,18,25.00,25.00),

(25,20,25.00,25.00),
(25,21,35.00,35.00),

(25,24,25.00,25.00),

(25,28,35.00,35.00),
(25,29,35.00,35.00),
(25,30,35.00,35.00),
(25,32,25.00,25.00),
(25,33,35.00,35.00),
(25,34,35.00,35.00),
(25,35,35.00,35.00),
(25,36,35.00,35.00)

insert into route (id_origin, id_destined, day_tarif, night_tarif)values
(24,25,25.00,25.00),
(20,25,25.00,25.00),
(15,25,25.00,25.00),
(12,25,27.50,27.50),
(35,25,35.00,35.00),
(36,25,35.00,35.00),
(33,25,35.00,35.00),
(34,25,35.00,35.00),
(11,25,35.00,35.00),
(21,25,35.00,35.00),
(2,25,35.00,35.00),
(29,25,35.00,35.00),
(28,25,35.00,35.00),
(30,25,35.00,35.00),
(17,25,27.50,27.50),
(13,25,25.00,25.00),
(18,25,25.00,25.00),
(32,25,25.00,25.00),
(3,25,25.00,25.00),
(14,25,25.00,25.00),
(1,25,40.00,40.00)

