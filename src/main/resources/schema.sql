DROP TABLE IF EXISTS CITY;
CREATE TABLE CITY (
City_code INT AUTO_INCREMENT  PRIMARY KEY,
city_name VARCHAR(50) NOT NULL,
city_pincode INT(8) NOT NULL
);
DROP TABLE IF EXISTS ACCOUNTS;
create table ACCOUNTS (
	Account_Id INT not null,
	status VARCHAR(8) not null,
	Status_Update_Date_Time VARCHAR(88),
	Currency VARCHAR(3) not null,
	Account_Type VARCHAR(8) not null,
	Opening_Date VARCHAR(88),
	CONSTRAINT accounts_pk PRIMARY KEY (Account_Id)
);
