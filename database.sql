CREATE DATABASE IF NOT EXISTS lostfound;
USE lostfound;

CREATE TABLE IF NOT EXISTS item (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(50),
    item_name VARCHAR(255),
    description TEXT,
    contact VARCHAR(100),
    image LONGBLOB
);