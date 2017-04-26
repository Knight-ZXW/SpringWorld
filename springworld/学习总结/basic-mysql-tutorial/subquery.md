
## inner query
Inner Query 也可以叫它 Subquery，不过叫什么不重要，没有什么比一个例子来的更简洁明了的。

![image](http://www.mysqltutorial.org/wp-content/uploads/2013/02/mysql-subquery.gif)

一个子查询必须用括号抱起来。


在 WHERE 跟 子查询的结果中间，可以使用比较语句如 =、>,<等，还包括其他的例如:IN 、NOT IN、EXISTS

子查询中，也可以 接WHERE 语句，甚至和外查询做比较如
```
SELECT
 productname,
 buyprice
FROM
 products AS p1
WHERE
 buyprice > (
 SELECT
 AVG(buyprice)
 FROM
 products
 WHERE
 productline = p1.productline
 )
```
