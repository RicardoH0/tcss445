create database finalPj;
use finalPj;

CREATE TABLE category
(
	accountId INT PRIMARY KEY,
	accountName VARCHAR(25),
	accountPT VARCHAR(50),
	accountDOB VARCHAR(25),
	accountCountry VARCHAR(25),
	accountGender VARCHAR(25)
);
Alter table category Add password varchar(250);
Alter table category Add mobile_number varchar(250) after password;
Alter table category Add accountName VARCHAR(25) after last_name;
Alter table category DROP COLUMN accountName;
select * from category;