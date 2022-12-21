INSERT INTO card (id, barcode, holder_name, is_active)
VALUES (1, '1', 'Mr. Holder', true),
       (2, '2', 'Mr. Molder', true),
       (3, '3', 'Mr. Dolder', true);

INSERT INTO item (id, barcode, description, is_on_discount, price)
VALUES (1, '1', 'Milk', false, 5.4),
       (2, '2', 'Chocolate', false, 5.4),
       (3, '3', 'Beer', true, 6),
       (4, '4', 'Meat', true, 10),
       (5, '5', 'Juice', true, 1.4),
       (6, '6', 'Apple', false, 3.2),
       (7, '7', 'Potato', false, 1.7),
       (8, '8', 'Vodka', false, 0.4),
       (9, '9', 'Coca cola', false, 9.4),
       (10, '10', 'Fish', true, 5);
