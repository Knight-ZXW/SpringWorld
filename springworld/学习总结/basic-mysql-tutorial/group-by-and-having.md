## GROUP BY
　　GROUP BY 是在查询时可选的条件，意思是根据 **BY** 指定的规则对数据分组，一般 GROUP BY 会配合聚合函数使用。
```sql
SELECT 
    c1, c2,..., cn, aggregate_function(ci)
FROM
    table
WHERE
    where_conditions
GROUP BY c1 , c2,...,cn;
```
## example

```sql
 SELECT 
  status
 FROM 
  orders
 GROUP BY status;
```
该作用就像
```sql
SELECT DISTINCT status
FROM 
    orders
```
**一般group还是配合聚合函数使用**
```sql
SELECT 
    status,COUNT (*)
FROM 
    orders
GROUP BY ststus;
```
作用：查找各个status的订单数量

## having
WHERE 跟 HAVING 的区别是，WHEER作用于每一行（个体），HAVING作用于每一组。
```sql
SELECT 
    ordernumber,
    SUM(quantityOrdered) AS itemsCount,
    SUM(priceeach) AS total
FROM
    orderdetails
GROUP BY ordernumber
HAVING total > 1000;
```
