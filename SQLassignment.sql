================= Queries for creating tables =========================================

CREATE DATABASE assignment1;

CREATE TABLE owner (
   owner_id  int(4) PRIMARY KEY,
   name  varchar(40) NOT NULL,
   surname  varchar(40) NOT NULL,
   street_address  varchar(120) NOT NULL,
   city  varchar(30) NOT NULL,
   state  varchar(30) NOT NULL,
   state_full  varchar(30) NOT NULL,
   zip_code  int(4) NOT NULL
)

CREATE TABLE  pet  (
   pet_id  varchar(7) NOT NULL,
   name  varchar(30) NOT NULL,
   kind  varchar(30) NOT NULL,
   gender  varchar(6) NOT NULL,
   age  int(2) NOT NULL,
   owner_id  int(4) NOT NULL
   FOREIGN KEY (owner_id) REFERENCES owner (owner_id)
)

CREATE TABLE  procedure_detail  (
   procedure_type  varchar(30) NOT NULL,
   procedure_subcode  int(3) NOT NULL,
   description  varchar(200) NOT NULL,
   price  decimal(10,2) NOT NULL,
   PRIMARY KEY (procedure_type , procedure_subcode)
)

CREATE TABLE  procedure_history  (
   pet_id  varchar(7) NOT NULL,
   date  date NOT NULL,
   procedure_type  varchar(30) NOT NULL,
   procedure_subcode  int(3) NOT NULL,
   FOREIGN KEY ( procedure_type , procedure_subcode ) REFERENCES  procedure_detail  ( procedure_type ,  procedure_subcode )
)

======================= Queries for the questions ===============================

select * from procedure_detail
where price > 150
limit 100;

select owner.owner_id, owner.name, owner.surname from pet join owner on pet.owner_id = owner.owner_id where kind = 'Parrot';

select count(*),zip_code from owner group by zip_code;

select distinct pet.pet_id from pet join procedure_history
where  EXTRACT(YEAR_MONTH FROM date) = 201602;

select sum(price) from procedure_history join procedure_detail
join pet join owner
where owner.zip_code = 49503
and EXTRACT(MONTH FROM date) =3;
