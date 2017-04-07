
## inner join
**内连接或等值连接**，inner join产生同时符合A和B的一组数据。想象成根据条件取两个表的交集
inner join 的 inner 可以省略， t1 表示主表,可以INNER JOIN 多次（多个表），join 多个表会对性能有影响。INNER JOIN后面 接 ON
表示 根据 条件，筛选数据join到主表中
```sql
SELECT column_list
FROM t1
INNER JOIN t2 ON join_condition1
INNER JOIN t3 ON join_condition2
...
WHERE where_conditions;
```

### 示例
```sql
SELECT
 productCode,
 productName,
 textDescription
FROM
 products T1
INNER JOIN productlines T2 ON T1.productline = T2.productline;
```

## LEFT JOIN 以及 RIGHT JOIN
LEFT JOIN 会取得左表的完全记录，及时在右表中不存在响应的数据；
RIGHT JOIN 会取得右表中的完全记录，即使在左表中不存在；
取得的结果中，不存在的列值会表示成 NULL

## SELF JOIn
使用自连接可以将自身表的一个镜像当作另一个表来对待;
使用自连接的情况：当表中的某一个字段与这个表中另外字段的相关时，
我们可能用到自连接（自连接的本意就是将一张表看成多张表来做连接）。

