--- CATEGORY TABLE
CREATE TABLE sa.category_tbl (
    id                INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    category_name     VARCHAR(30) NOT NULL,
    deleted_flag      VARCHAR(1),
    created_datetime  TIMESTAMP,
    modified_datetime TIMESTAMP,
    modified_by       VARCHAR(20),
    PRIMARY KEY       (ID));

CREATE UNIQUE INDEX id ON sa.category_tbl (ID);
CREATE UNIQUE INDEX category_name ON sa.category_tbl (category_name);


--- PRODUCT TABLE
CREATE TABLE sa.product_tbl  (
    id                INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    product_number    VARCHAR(20) NOT NULL,
    product_name      VARCHAR(40) NOT NULL,
    product_desc      VARCHAR(120),
    category_id       INT NOT NULL,
    min_inv           INT DEFAULT 0,
    max_inv           INT DEFAULT 0,
    start_inv         INT DEFAULT 0,
    received_inv      INT DEFAULT 0,
    sold_inv          INT DEFAULT 0,
    onhand_inv        INT DEFAULT 0,
    deleted_flag      VARCHAR(1) NOT NULL,
    created_datetime  TIMESTAMP NOT NULL,
    modified_datetime TIMESTAMP NOT NULL,
    modified_by       VARCHAR(20),
    PRIMARY KEY (ID));

CREATE UNIQUE INDEX id ON sa.product_tbl (id);
CREATE UNIQUE INDEX product_number ON sa.product_tbl (product_number);
CREATE UNIQUE INDEX product_name ON sa.product_tbl (product_name);



--- USER TABLE
CREATE TABLE sa.user_tbl(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    user_name VARCHAR(20),
    user_group VARCHAR(20),
    password VARCHAR(120),
    deleted_flag varchar(1),
    created_datetime TimeStamp,
    modified_datetime TimeStamp,
    modified_by varchar(20),
    PRIMARY KEY (ID));

CREATE UNIQUE INDEX id ON sa.user_tbl (id);
CREATE UNIQUE INDEX user_name ON sa.user_tbl (user_name);


--- SUPPLIER TABLE
CREATE TABLE sa.supplier_tbl(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    supplier_name VARCHAR(20),
    deleted_flag varchar(1),
    created_datetime TimeStamp,
    modified_datetime TimeStamp,
    modified_by varchar(20),
    PRIMARY KEY (ID));

CREATE UNIQUE INDEX id ON sa.supplier_tbl (ID);
CREATE UNIQUE INDEX supplier_name ON sa.supplier_tbl (supplier_name);

--- PURCHASE TABLE
CREATE TABLE sa.purchase_tbl(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    purchase_date TimeStamp,
    product_id INT,
    supplier_id INT,
    purchase_qty INT,
    deleted_flag varchar(1),
    created_datetime TimeStamp,
    modified_datetime TimeStamp,
    modified_by varchar(20),
    PRIMARY KEY (ID));

CREATE UNIQUE INDEX id ON sa.purchase_tbl (id);
CREATE INDEX supplier_id ON sa.purchase_tbl(supplier_id);
CREATE INDEX product_id ON sa.purchase_tbl(product_id);
CREATE INDEX purchase_date ON sa.purchase_tbl(purchase_date);



CREATE TABLE sa.order_tbl(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    order_date TimeStamp,
    customer_name VARCHAR(60),
    product_id INT,
    order_qty INT,
    deleted_flag varchar(1),
    created_datetime TimeStamp,
    modified_datetime TimeStamp,
    modified_by varchar(20),
    PRIMARY KEY (ID));

CREATE UNIQUE INDEX id ON sa.order_tbl (id);
CREATE INDEX product_id ON sa.order_tbl(product_id);
CREATE INDEX order_date ON sa.order_tbl(order_date);

