DROP TABLE sa.Product;

CREATE TABLE sa.Product(
    ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    PartNumber  VARCHAR(50),
    ProductName VARCHAR(50),
    ProductDesc VARCHAR(255),
    CategoryId INTEGER,
    StartingInventory INTEGER,
    InventoryReceived INTEGER,
    InventorySold INTEGER,
    InventoryOnHand INTEGER,
    MinimumRequired  INTEGER,
    DeletedFlag varchar(1),
    PRIMARY KEY (ID));

CREATE UNIQUE INDEX ID ON sa.Product (ID);
CREATE UNIQUE INDEX PartNumber ON sa.Product (PartNumber);
CREATE UNIQUE INDEX ProductName ON sa.Product (ProductName);

DROP TABLE sa.Category;

CREATE TABLE sa.Category(
    ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    CategoryName VARCHAR(20),
    PRIMARY KEY (ID));

CREATE UNIQUE INDEX ID ON sa.Category (ID);


