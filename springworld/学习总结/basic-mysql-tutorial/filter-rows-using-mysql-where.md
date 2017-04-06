
## introduction to MYSQL WHERE clause
   如果只使用 **select** 查询数据，则会默认返回该表所有的数据，一般我们会加上 where 语句根据条件筛选出需要的数据。
   
```sql
SELECT 
    lastname,firstname,jobtitle
FROM
    employee
WHERE 
    jobtitle = 'sales REp'

```
**where** 之后的表达式可以是逻辑复合的，比如使用 AND,OR等等连接2个条件。
```sql
SELECT 
    lastname, firstname, jobtitle
FROM
    employees
WHERE
    jobtitle = 'Sales Rep' AND officeCode = 1;
```

另外，也支持一些数学上常用的比较符


Operator  | Description 
---|---
=| 等于（支持几乎所有的类型）
<> or != |	不等于
<  |	小与（支持时间、数字）.
>  |	大于
<= |	小于等于
>= |    大于等于

> and 操作 Null and False的结果是False,Null and Null或者Null and True 结果都是Null
> Or 操作 在True or Null 返回 True,False OR Null、Null or Null  结果都是Null

## Limit clause

```sql
SELECT 
    column1,column2,...
FROM
    table
LIMIT offset , count;
```
offset 即获取的数据结果的偏移，cout即结果的数量，注意 offset 的坐标是从0开始的
![image](http://www.mysqltutorial.org/wp-content/uploads/2011/03/mysql-limit-offset.jpg)

如果LIMIT 后面只跟一个参数，那么其实是表示count,即 **LIMIT count**。它等价于 **LIMIT 0,count**

## IN Operator
```sql
SELECT column1,column2
FROM TABLE_NAME 
WHERE 
(column1) [NOT]IN(constant column1 list|子查询结果集)
```
WHERE .. IN.. 语句， **In** 后面可以接一个list 或者是个子查询；
在 IN list的情况下，由于字段值都是已知的，sql会首先对这些值做一个排序然后用二分查找的方式快速判断，所以效率是很高的。
```sql
SELECT 
    officeCode, city, phone, country
FROM
    offices
WHERE
    country IN ('USA' , 'France');
```
IN  后面也可以接一个子查询, WHERE IN ，mysql会首先执行子查询得到结果集，再执行整个sql语句。
```sql
SELECT 
    orderNumber, customerNumber, status, shippedDate
FROM
    orders
WHERE
    orderNumber IN (SELECT 
            orderNumber
        FROM
            orderDetails
        GROUP BY orderNumber
        HAVING SUM(quantityOrdered * priceEach) > 60000);
```　
　
### 注意NOT IN 与Null值遇上的一个情况
表中存在 name 为 xiaoming1 xiaoming2 以及 null，当判断name NOT IN (xiaoming1 ,NULL)
(一般我们不会写出这样的语句，但是注意，如果IN后面接子查询的情况下存在这种情况)等同于
where name<>xiaoming1 and name<>NULL 而 name 与 NULL比较会返回false,导致这个表示式的值一定是false,**所以我们在子查询中应该过滤掉NULL的情况**

## BETWEEN 

**BETWEEN** 很好理解,表达式如下
```sql
expr [NOT] BETWEEN  下限 AND 上限
```

##LIKE
like 用于 模糊查询，支持表达式方式
LIKE 提供了2个 **通配符** 一个是 % 表示0或者多个 字符， _ 表示任意单个字符
```sql
WHERE 
COLUMN LIKE '[表达式]'
```

##ORDER BY
ORDER BY用于结果集的排序，ORDER BY 后面指定用于排序的字段，
```sql
SELECT column1, column2,...
FROM tbl
ORDER BY column1 [ASC|DESC], column2 [ASC|DESC],...
```
其中 ASC表示升序 DESC表示降序， ORDER BY 支持在遇到排序结果时根据多个字段依次排序，

## UNION
UNION用于合并 多个 SELECT 语句的结果集。
UNION 的SELECT语句必须拥有相同的列、顺序及数据类型(或者支持转换，以第一个SELECT语句为主)，这样才能合并。
UNION 在合并时会去掉相同值的数据，如果需要保留相同的数据 则使用 UNION　ALL
```sql
SELECT column1, column2
UNION [DISTINCT | ALL]
SELECT column1, column2
UNION [DISTINCT | ALL]
```

## Alias
Alias  用于指定别名，你可以用于给列 或者表指定别名。
AS 是可以省略的

```sql
SELECT
 CONCAT_WS(', ', lastName, firstname) AS `Full name`
FROM
 employees;
```

在这个例子中，我们从 employees 中查询 lastName, firstname 并且使用 CONCAT_WS函数用 符号,连接值，且 以Full Name作为列名，
如果不适用 AS 起个别名，得到的结果的列名 会是 **CONCAT_WS(',',lastName,firstname)**

　　在执行一些负责的sql语句中可能会用到多张表，如果2个表有相同的字段名，我们需要在使用这个字段的时候加上表名，否则sql语句会出错,。
这个例子中，我们给2个表名起了别名以方便sql语句的编写，如果不起别名，则你需要带上表名的全称

```sql
SELECT
 customerName,
 COUNT(o.orderNumber) total
FROM
 customers c
INNER JOIN orders o ON c.customerNumber = o.customerNumber
GROUP BY
 customerName
ORDER BY
 total DESC;
```




