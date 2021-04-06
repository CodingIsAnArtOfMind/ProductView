create table productview(
productId integer not null,
productManufacturer varchar(255) not null,
productAvailability varchar(255) not null,
productPrice varchar(255) not null,
productType varchar(255),
primary key(productId)
);


INSERT INTO productview (productId, productManufacturer, productAvailability, productPrice, productType )
VALUES(10001, 'Blackberry', 'Yes', '500 INR', 'Clothing');
INSERT INTO productview (productId, productManufacturer, productAvailability, productPrice, productType )
VALUES(10002,  'Google', 'Yes', '6000 INR', 'Mobile & Laptop');
INSERT INTO productview (productId, productManufacturer, productAvailability, productPrice, productType )
VALUES(10003,  'Honda', 'No', '7960 INR', 'Bikes');
INSERT INTO productview (productId, productManufacturer, productAvailability, productPrice, productType )
VALUES(10004,  'Titan', 'No', '500 INR', 'watch');

