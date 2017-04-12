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

