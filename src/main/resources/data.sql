--PRODUCTS
INSERT INTO sa.category_tbl (category_name, deleted_flag, created_datetime, modified_datetime, modified_by) VALUES ('Lubricants', 'N', current_timestamp, current_timestamp, 'admin');
INSERT INTO sa.category_tbl (category_name, deleted_flag, created_datetime, modified_datetime, modified_by) VALUES ('Electricals', 'N', current_timestamp, current_timestamp, 'admin');
INSERT INTO sa.category_tbl (category_name, deleted_flag, created_datetime, modified_datetime, modified_by) VALUES ('Batteries', 'N', current_timestamp, current_timestamp, 'admin');
INSERT INTO sa.category_tbl (category_name  deleted_flag, created_datetime, modified_datetime, modified_by) VALUES ('Tires', 'N', current_timestamp, current_timestamp, 'admin');
INSERT INTO sa.category_tbl (category_name, deleted_flag, created_datetime, modified_datetime, modified_by) VALUES ('Accessories', 'N', current_timestamp, current_timestamp, 'admin');
INSERT INTO sa.category_tbl (category_name, deleted_flag, created_datetime, modified_datetime, modified_by) VALUES ('Belts', 'N', current_timestamp, current_timestamp,'admin');
INSERT INTO sa.category_tbl (category_name, deleted_flag, created_datetime, modified_datetime, modified_by) VALUES ('Bolts and nuts', 'N', current_timestamp, timestamp. 'admin');
INSERT INTO sa.category_tbl (category_name, deleted_flag, created_datetime, modified_datetime, modified_by) VALUES ('Engine', 'N', current_timestamp, current_timestamp, 'admin');

-- USER
insert into sa.inventoryuser(username, usergroup, password, createddate, modifieddate, modifiedby, deletedflag) values ('admin', 'admin','$2a$11$9/pwbeqZPzFh3Yc27C.Y/OQ9lAWCmnT7klpNaUJ.3xd05Ww028FZS', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'N')

