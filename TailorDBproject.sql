USE TailorDBproject;


CREATE TABLE Customer(
CustomerID int IDENTITY(1,1) NOT NULL PRIMARY KEY, 
Email varchar (50) COLLATE SQL_Latin1_General_CP1_CS_AS NOT NULL UNIQUE,
Pass varchar (50) COLLATE SQL_Latin1_General_CP1_CS_AS NOT NULL,
UserName varchar (50) COLLATE SQL_Latin1_General_CP1_CS_AS NOT NULL, 
CustomerAddress varchar (50) COLLATE SQL_Latin1_General_CP1_CS_AS NOT NULL,
CustomerContact int NOT NULL
);
select * from Customer 
select count(*) as cuscount from Customer
delete from Customer where CustomerID = 11
INSERT INTO Customer VALUES
('faruk@gmail.com','abcde','Faruk','Dhaka',020986)
select CustomerID from Customer where [Email]='faruk@gmail.com' and [Pass]='abcde'
select * from Customer

CREATE TABLE Tailor(
TailorID int IDENTITY(1,1) NOT NULL PRIMARY KEY,
TailorName varchar (50)  COLLATE SQL_Latin1_General_CP1_CS_AS NOT NULL,
TailorEmail varchar (50)  COLLATE SQL_Latin1_General_CP1_CS_AS NOT NULL UNIQUE,
TailorContact int NOT NULL,
TailorPass varchar (50)  COLLATE SQL_Latin1_General_CP1_CS_AS NOT NULL,
TailorAddress varchar (100)  COLLATE SQL_Latin1_General_CP1_CS_AS NULL DEFAULT 'Not given'
);
INSERT INTO Tailor VALUES
('Hasan','hasan@gmail.com',029876,'12345','Dhaka'),
('Karim','karim@gmail.com',023456,'abcde','Dhaka')
select * from Tailor
delete from Tailor where TailorID = 5

CREATE TABLE Orders(
OrderID int IDENTITY(1,1) NOT NULL PRIMARY KEY,
CustomerId int NOT NULL FOREIGN KEY REFERENCES Customer(CustomerID),
TailorId int NOT NULL FOREIGN KEY REFERENCES Tailor(TailorID), 
CatalogId int NULL FOREIGN KEY REFERENCES Catalog(catalogID),
fee float NOT NULL,
OrderDate date NOT NULL,
Height float NULL,
Neck float NULL,
Waist float NULL,
Shoulder float NULL,
Arm float NULL,
Wrist float NULL,
Thighs float NULL,
Chest float NULL,
DressType varchar(50) NULL,
Party_Casual varchar(10) NULL,
CompletingDate date NOT NULL,
Completed varchar(5) NULL DEFAULT 'NO',
ExtraDescribe varchar(500) COLLATE SQL_Latin1_General_CP1_CS_AS NULL,
Emergency_make varchar(5) NULL,
Image image NULL,
ImagePath varchar(1000) COLLATE SQL_Latin1_General_CP1_CS_AS NULL
);
INSERT INTO Orders VALUES
(01,01,1000,'2020-09-05',155,14,33,36,10,5,17,36,'2020-09-10','NO','','YES'),
(01,02,1500,'2020-11-05',165,15,35,40,17,7,20,38,'2020-11-10','NO','','')

INSERT INTO Orders(CustomerId,TailorId,CatalogId,fee,OrderDate,Height,Neck,Waist,Shoulder,Arm,Wrist,Thighs,Chest,CompletingDate,ExtraDescribe,Party_Casual) 
VALUES(02,01,01,1200,'2020-08-05',165,19,27,32,10,5,17,24,'2020-08-10',null,'Party')

INSERT INTO Party_Dress_Orders(OrderId) SELECT MAX(OrderID) FROM Orders WHERE Party_Casual = 'Party'

INSERT INTO Orders(CustomerId ,TailorId ,fee ,OrderDate          ,CompletingDate) VALUES
(01,02,200,'10/12/20 1:32 AM','2020-10-10')
select * from Orders where CustomerId =2
delete from Orders where OrderID=3
SELECT * FROM Orders 
update Orders set TailorId = 2 where OrderID = 3
insert into Orders(CustomerId,TailorId,Height,Shoulder,Neck,Arm,Wrist,Chest,Waist,Thighs,ExtraDescribe,Emergency_make,Completed,fee,OrderDate,CompletingDate,DressType)values(01,01,155,23,12,15,5,32,27,0,'','','',900,'Wed Aug 12 2020','2020-8-17','Party Dress')
select OrderID from Orders 

Create Table Casual_Dress_Orders(
	Cas_Id int Identity(1,1) NOT NULL PRIMARY KEY,
	OrderId int NOT NULL FOREIGN KEY REFERENCES Orders(OrderID), 
);
select * from Casual_Dress_Orders


Create Table Party_Dress_Orders(
	Par_Id int Identity(1,1) NOT NULL PRIMARY KEY,
	OrderId int NOT NULL FOREIGN KEY REFERENCES Orders(OrderID),
);
select * from Party_Dress_Orders

select OrderID from Orders where Completed = 'NO'

SELECT Orders.TailorId,Party_Dress_Orders.Par_Id,Party_Dress_Orders.OrderId FROM Orders INNER JOIN Party_Dress_Orders ON Orders.OrderID=Party_Dress_Orders.OrderId WHERE TailorId = 2
select OrderID from Orders where TailorId = 2


CREATE TABLE Catalog(
catalogID int IDENTITY(1,1) NOT NULL PRIMARY KEY,
Imagepath varchar(500) NOT NULL,
DressName varchar(20) NOT NULL
);
INSERT INTO Catalog(Imagepath,DressName) VALUES ('Not required','Not required')
select * from Catalog
