insert into brands (brand_id, name) values (1, 'ZARA');
insert into brands (brand_id, name) values (2, 'BERSHKA');
insert into brands (brand_id, name) values (3, 'OYSHO');
insert into brands (brand_id, name) values (4, 'PULL&BEAR');

insert into products (product_id, name, description, active, color) values (35455, 't-shirt', 'Short-sleeved slim-fit black cotton tee', 1, 'Black');
insert into products (product_id, name, description, active, color) values (38648, 'Jean', 'Wide-legged denim jeans with faded gradients', 1, 'blue');
insert into products (product_id, name, description, active, color) values (13846, 'Blouse', 'Long-sleeved white blouse in lightweight fabric', 1, 'white');
insert into products (product_id, name, description, active, color) values (88654, 'Jacket', 'Denim jacket with side pockets', 1, 'black');

insert into prices (price_id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr) values (1, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR');
insert into prices (price_id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr) values (2, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR');
insert into prices (price_id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr) values (3, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR');
insert into prices (price_id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr) values (4, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');