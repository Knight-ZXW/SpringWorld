
## inner join
**内连接或等值连接**：获取表中字段匹配的记录
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