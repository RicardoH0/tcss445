create database finalPj;
use finalPj;

CREATE TABLE category
(
	AccountId INT PRIMARY KEY,
        First_name VARCHAR(25),
   	Last_name VARCHAR(25),
	AccountName VARCHAR(25),
	AccountPT VARCHAR(50),
	AccountDOB VARCHAR(25),
	AccountCountry VARCHAR(25),
	Password varchar(250),
    	MobileNumber varchar(250)
);
Alter table category Add password varchar(250);
Alter table category Add mobile_number varchar(250) after password;
Alter table category Add accountName VARCHAR(25) after last_name;
Alter table category DROP COLUMN accountName;
select * from category;
