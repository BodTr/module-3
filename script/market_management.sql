create database Supermarket_management;

use Supermarket_management;

create table customers

(
	cID int not null,
    cName varchar(50),
    cAge int,
    primary key(cID)
);

create table orders
(
	oID int not null,
    cID int,
    oDate datetime,
    oTotalPrice int,
    primary key(oID),
    foreign key (cID) references customers(cID)
);

create table products
(
	pID int not null,
    pName varchar(50),
    pPrice int,
    primary key(pID)
);

create table order_detail
(
	oID int,
    pID int,
    odQTY int,
	foreign key (oID) references orders(oID),
    foreign key (pID) references products(pID),
    primary key(oID, pID)
);

select * from orders
order by orders.oDate desc;

select max(pPrice)order_detail from products;

select customers.cName, products.pName
from orders
join customers
on orders.cID = customers.cID
join order_detail
on order_detail.oID = orders.oID
join products
on order_detail.pID = products.pID;

select customers.cName
from customers
left join orders
on orders.cID = customers.cID
where orders.cID is null;

select orders.oID, orders.oDate, order_detail.odQTY, products.pName, products.pPrice
from orders
join order_detail
on orders.oID = order_detail.oID
join products
on order_detail.pID = products.pID;

select orders.oID, orders.oDate, (order_detail.odQTY * products.pPrice) as `Total`
from orders
join order_detail
on orders

