use db_demo;

select customers.customerNumber , orders.orderNumber
from customers
join orders
on customers.customerNumber = orders.customerNumber
where customers.customerNumber = 124;

select orders.status, count(*) as total
from orders
group by orders.status;

select * from orders
order by orders.orderNumber desc; /*