DROP TABLE IF EXISTS sale_records;
DROP TABLE IF EXISTS products;

CREATE TABLE products (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(120) NOT NULL,
    sku VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    reorder_level INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    supplier_name VARCHAR(120) NOT NULL,
    category VARCHAR(80) NOT NULL
);

CREATE TABLE sale_records (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(120) NOT NULL,
    category VARCHAR(80) NOT NULL,
    quantity_sold INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    sale_date DATE NOT NULL
);
