
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
    


