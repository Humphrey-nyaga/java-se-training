USE javase;
DROP TABLE customer;
CREATE TABLE customer(
    id  INT PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(128),
    lastname  VARCHAR(128),
    address VARCHAR(128),
    contact VARCHAR(128),
    email VARCHAR(128));
