create table PRODUCTS(product_id BIGINT IDENTITY PRIMARY KEY,
			product_name varchar(20),
			product_description varchar(20),
			unit_price DOUBLE,
			vendor_id varchar(20),
			category varchar(20));