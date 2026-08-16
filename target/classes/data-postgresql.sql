-- PostgreSQL Database - Compatible data (with ON CONFLICT)
INSERT INTO customer (name, email) VALUES
('Alice Johnson', 'alice@email.com'),
('Bob Smith', 'bob@email.com'),
('Charlie Brown', 'charlie@email.com'),
('Diana White', 'diana@email.com')
ON CONFLICT (email) DO NOTHING;

INSERT INTO orders (customer_id, order_date, total_amount, status) VALUES
(1, '2025-01-10 10:00:00', 250.00, 'NEW'),
(1, '2025-01-12 12:30:00', 120.00, 'PAID'),
(2, '2025-01-14 09:15:00', 320.00, 'SHIPPED'),
(3, '2025-01-15 15:45:00', 540.00, 'NEW')
ON CONFLICT DO NOTHING;

INSERT INTO product (name, price, stock) VALUES
('Laptop', 1200.00, 10),
('Mouse', 25.00, 100),
('Keyboard', 80.00, 60),
('Monitor', 300.00, 20)
ON CONFLICT DO NOTHING;

INSERT INTO order_item (order_id, product_id, quantity, unit_price) VALUES
(1, 1, 1, 1200.00),
(1, 2, 2, 25.00),
(2, 3, 1, 80.00),
(3, 4, 1, 300.00),
(3, 2, 3, 25.00),
(4, 1, 1, 1200.00)
ON CONFLICT DO NOTHING;

INSERT INTO department (name) VALUES
('Engineering'),
('HR'),
('Finance')
ON CONFLICT (name) DO NOTHING;

INSERT INTO employee (department_id, name, salary, version) VALUES
(1, 'John Doe', 90000.00, 0),
(1, 'Jane Doe', 98000.00, 0),
(2, 'Mary Smith', 65000.00, 0),
(3, 'Robert Lee', 76000.00, 0)
ON CONFLICT DO NOTHING;

INSERT INTO post (title, content, author_name) VALUES
('Hibernate Basics', 'Understanding entity states and transactions', 'Author 1'),
('N+1 Problem', 'A common Hibernate performance issue', 'Author 2'),
('Hibernate Mapping', 'One-to-many and many-to-one relationships', 'Author 3')
ON CONFLICT DO NOTHING;

INSERT INTO comment (post_id, text) VALUES
(1, 'Great explanation'),
(1, 'Useful details'),
(2, 'Need more examples'),
(3, 'Very clear'),
(3, 'Good mapping example')
ON CONFLICT DO NOTHING;

INSERT INTO author (name) VALUES
('George Orwell'),
('J.K. Rowling'),
('Ernest Hemingway')
ON CONFLICT (name) DO NOTHING;

INSERT INTO book (title, price) VALUES
('1984', 12.99),
('Harry Potter', 15.50),
('The Old Man and the Sea', 10.25)
ON CONFLICT DO NOTHING;

INSERT INTO book_author (book_id, author_id) VALUES
(1, 1),
(2, 2),
(3, 3)
ON CONFLICT DO NOTHING;

INSERT INTO account (account_number, balance, version) VALUES
('ACC-1001', 5000.00, 0),
('ACC-1002', 8000.00, 0),
('ACC-1003', 12000.00, 0)
ON CONFLICT (account_number) DO NOTHING;
