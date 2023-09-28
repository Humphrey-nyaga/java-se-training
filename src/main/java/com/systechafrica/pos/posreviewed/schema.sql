use pointofsale;
CREATE TABLE users
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(25),
    password VARCHAR(255)
);
CREATE TABLE orders
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    time  DATETIME NOT NULL,
    total DECIMAL(10, 2) DEFAULT 0.0
);

CREATE TABLE cart
(
    item_id  INT            NOT NULL,
    order_id INT            NOT NULL,
    quantity INT            NOT NULL,
    price    DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (item_id, order_id),
    FOREIGN KEY (order_id) REFERENCES orders (id)
);
1. User adds items
2. Make Payment
3. Create
cart -
          retrieve cart id
4.
Insert cart_items while inclusing the cart_id into database


/**
UPDATE orders AS o
SET o.total = (
    SELECT SUM(c.quantity * c.price)
    FROM cart AS c
    WHERE c.order_id = o.id
)
WHERE o.id = ?;

INSERT INTO orders(time, total) VALUES(?, ?);
**/

SELECT LAST_INSERT_ID();
INSERT INTO cart(item_id, order_id, quantity, price)
VALUES (?, ?, ?, ?)
SELECT item_id, quantity, price
FROM cart
WHERE order_id = ?;
UPDATE orders
SET total = SUM()

SELECT SUM(quantity * price) as total
FROM order
WHERE order_id = 1;
