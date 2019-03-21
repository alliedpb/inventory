DROP TABLE sa.Product;


CREATE TABLE sa.Product(
    ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    ProductName VARCHAR(50),
    ProductDesc VARCHAR(255),
    PartNumber  VARCHAR(50),
    ProductLabel VARCHAR(50),
    StartingInventory BIGINT,
    InventoryReceived BIGINT,
    InventorySold BIGINT,
    InventoryOnHand BIGINT,
    MinimumRequired  BIGINT,
    PRIMARY KEY (ID));

CREATE UNIQUE INDEX ID ON sa.Product (ID);
CREATE UNIQUE INDEX PartNumber ON sa.Product (PartNumber);
CREATE UNIQUE INDEX ProductName ON sa.Product (ProductName);

