CREATE TABLE unit_of_measure(
id SERIAL PRIMARY KEY,
name VARCHAR(50) NOT NULL);

CREATE TABLE organization_type(
id SERIAL PRIMARY KEY,
name VARCHAR(50) NOT NULL);

CREATE TABLE address(
id SERIAL PRIMARY KEY,
zip_code VARCHAR(50));

CREATE TABLE organization(
id SERIAL PRIMARY KEY,
name VARCHAR(50),
employees_count BIGINT NOT NULL,
organization_type_id INTEGER REFERENCES organization_type(id),
address_id INTEGER REFERENCES address(id)
);

CREATE TABLE organization(
id SERIAL PRIMARY KEY,
name VARCHAR(50),
employees_count INTEGER,
organization_type_id INTEGER REFERENCES organization_type(id),
address_id INTEGER REFERENCES address(id)
);

CREATE TABLE coordinates(
id SERIAL PRIMARY KEY,
x REAL,
y BIGINT);

CREATE TABLE product(
key VARCHAR(50) PRIMARY KEY,
id SERIAL UNIQUE ,
name VARCHAR(50),
coordinates_id INTEGER REFERENCES coordinates(id),
creation_date TIMESTAMP DEFAULT NOW(),
price REAL,
part_number VARCHAR(50),
manufacturer_id INTEGER REFERENCES organization(id),
unit_of_measure_id INTEGER REFERENCES unit_of_measure(id),
created_by_id INTEGER NOT NULL);


INSERT INTO unit_of_measure(name) VALUES ('KILOGRAMS');
INSERT INTO unit_of_measure(name) VALUES ('METERS');
INSERT INTO unit_of_measure(name) VALUES ('CENTIMETERS');
INSERT INTO unit_of_measure(name) VALUES ('SQUARE_METERS');
INSERT INTO unit_of_measure(name) VALUES ('GRAMS');


INSERT INTO organization_type(name) VALUES ('COMMERCIAL');
INSERT INTO organization_type(name) VALUES ('PUBLIC');
INSERT INTO organization_type(name) VALUES ('GOVERNMENT');
INSERT INTO organization_type(name) VALUES ('TRUST');
INSERT INTO organization_type(name) VALUES ('OPEN_JOINT_STOCK_COMPANY');


CREATE TABLE users(
username VARCHAR(50) PRIMARY KEY,
pass_hash varchar(256) NOT NULL,
salt varchar(256) NOT NULL,
id SERIAL
);

