DROP TABLE IF EXISTS sale_records;
DROP TABLE IF EXISTS products;

CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(120) NOT NULL,
    sku VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    reorder_level INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    supplier_name VARCHAR(120) NOT NULL,
    category VARCHAR(80) NOT NULL
);

CREATE TABLE sale_records (
    id INT PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(120) NOT NULL,
    category VARCHAR(80) NOT NULL,
    quantity_sold INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    sale_date DATE NOT NULL
);

INSERT INTO products (name, sku, quantity, reorder_level, unit_price, supplier_name, category) VALUES
('Bread Rolls', 'INV-001', 40, 20, 4.50, 'Fresh Bake Ltd', 'Bakery'),
('Chicken Wrap', 'INV-002', 18, 25, 35.00, 'Farm Foods', 'Meals'),
('Soft Drink', 'INV-003', 60, 30, 14.00, 'Cool Beverages', 'Drinks'),
('Coffee Cups', 'INV-004', 12, 20, 22.00, 'Cafe Source', 'Supplies'),
('Burger Patty', 'INV-005', 15, 18, 19.00, 'Farm Foods', 'Meals'),
('Potato Chips', 'INV-006', 55, 15, 12.50, 'Snack World', 'Snacks');

INSERT INTO sale_records (item_name, category, quantity_sold, unit_price, sale_date) VALUES
('Chicken Wrap', 'Meals', 35, 35.00, '2026-04-01'),
('Soft Drink', 'Drinks', 72, 14.00, '2026-04-01'),
('Bread Rolls', 'Bakery', 54, 4.50, '2026-04-02'),
('Coffee Cups', 'Supplies', 18, 22.00, '2026-04-02'),
('Burger Patty', 'Meals', 29, 19.00, '2026-04-03'),
('Potato Chips', 'Snacks', 48, 12.50, '2026-04-03');
