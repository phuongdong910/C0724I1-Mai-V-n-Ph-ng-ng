create database sales_management;
use sales_management;

CREATE TABLE Customers (
    CustomerID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    CustomerName VARCHAR(100),
    ContactName VARCHAR(100),
    Country VARCHAR(50)
);

INSERT INTO Customers (CustomerName, ContactName, Country) 
VALUES 
('Alice Company', 'Alice', 'USA'),
('Bob Shop', 'Bob', 'Canada'),
('Carol Market', 'Carol', 'UK');

CREATE TABLE Employees (
    EmployeeID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    EmployeeName VARCHAR(100),
    Position VARCHAR(50),
    HireDate DATE
);

INSERT INTO Employees (EmployeeName, Position, HireDate) 
VALUES 
('John Doe', 'Manager', '2015-06-12'),
('Jane Smith', 'Salesperson', '2017-09-20'),
('Chris Evans', 'Accountant', '2019-04-15');

CREATE TABLE Shippers (
    ShipperID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ShipperName VARCHAR(100),
    Phone VARCHAR(20)
);

INSERT INTO Shippers (ShipperName, Phone) 
VALUES 
('DHL', '123-456-7890'),
('FedEx', '987-654-3210'),
('UPS', '555-333-2222');

CREATE TABLE Orders (
    OrderID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    OrderDate DATE,
    CustomerID INT,
    EmployeeID INT,
    ShipperID INT,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
    FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID),
    FOREIGN KEY (ShipperID) REFERENCES Shippers(ShipperID)
);

INSERT INTO Orders (OrderDate, CustomerID, EmployeeID, ShipperID)
VALUES 
('2024-01-15', 1, 1, 1),
('2024-02-20', 2, 2, 2),
('2024-03-10', 3, 3, 3);

CREATE TABLE Categories (
    CategoryID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    CategoryName VARCHAR(100),
    Description VARCHAR(255)
);

INSERT INTO Categories (CategoryName, Description)
VALUES 
('Electronics', 'Devices and gadgets'),
('Clothing', 'Men and Women Clothing'),
('Food', 'Groceries and food items');

CREATE TABLE Suppliers (
    SupplierID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SupplierName VARCHAR(100),
    ContactName VARCHAR(100),
    Country VARCHAR(50)
);

INSERT INTO Suppliers (SupplierName, ContactName, Country) 
VALUES 
('Tech Corp', 'Jake', 'USA'),
('Fashion Inc', 'Laura', 'France'),
('Foodies Ltd', 'Matt', 'Italy');

CREATE TABLE Products (
    ProductID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ProductName VARCHAR(100),
    SupplierID INT,
    CategoryID INT,
    UnitPrice DECIMAL(10, 2),
    FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID),
    FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)
);

INSERT INTO Products (ProductName, SupplierID, CategoryID, UnitPrice)
VALUES 
('Laptop', 1, 1, 800.00),
('T-shirt', 2, 2, 20.00),
('Pizza', 3, 3, 15.00);

CREATE TABLE OrderDetails (
    OrderDetailID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    OrderID INT,
    ProductID INT,
    Quantity INT,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

INSERT INTO OrderDetails (OrderID, ProductID, Quantity)
VALUES 
(1, 1, 2), -- Order 1, 2 Laptops
(2, 2, 5), -- Order 2, 5 T-shirts
(3, 3, 3); -- Order 3, 3 Pizzas

-- 1.lấy danh sách đơn hàng với thông tin khách hàng......
select o.OrderID, o.OrderDate,
 c.CustomerID, c.CustomerName, c.ContactName, c.Country,
 e.EmployeeID, e.Position, e.HireDate,
 s.ShipperID, s.ShipperName, s.Phone
 from orders o 
 inner join customers c on o.CustomerID = c.CustomerID
 inner join employees e on o.EmployeeID = e.EmployeeID
 inner join shippers s on o.ShipperID = s.ShipperID;
 
 -- 2.Tong gia tri don hang cho moi khach hang
 
 select  c.CustomerID, c.CustomerName,
 SUM(p.UnitPrice*od.Quantity) as TotalOderValue
 
 From orders o 
 inner join orderdetails od on o.OrderID = od.OrderID
 inner join products p on od.ProductID = p.ProductID
 inner join customers c on o.CustomerID = c.CustomerID
 Group by  c.CustomerID, c.CustomerName;
 
 -- Tim san pham ban chay nhat
 select p.ProductName, p.UnitPrice, sum(od.Quantity) as TotalQuantitySold
 from orderdetails od
 inner join products p on od.ProductID = p.ProductID
 Group by p.ProductName, p.Unitprice
 order by TotalQuantiTySold Desc;
 
 -- Lay danh sach tat ca don hang  cua khach hang co ten 'Alice Company' va hien thi chi tiet san pham va so luong
 
 select o.OrderID, o.OrderDate,  p.ProductName, p.UnitPrice, od.Quantity
 from orders o 
 inner join orderdetail od on od.OrderID = o.OrderID
 inner join products p on od.ProductID = p.ProductID
 inner join customers c on o.CustomerID = c.CustomerID
where c.Customername = 'Alice Company'; 
 
 
 