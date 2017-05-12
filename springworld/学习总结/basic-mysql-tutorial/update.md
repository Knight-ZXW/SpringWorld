## UPDATE STATEMENT
update ,顾名思义，用于更新表中的 一列或者一组甚至是全部列的数据
```sql
UPDATE [LOW_PRIORITY] [IGNORE] table_name 
SET 
    column_name1 = expr1,
    column_name2 = expr2,
    ...
WHERE
    condition;
```

LOW_LOW_PRIORITY
表示更新操作的优先级降低，具体表现在，比如如果有连接正在读取数据，则更新操作 会等 query 结束后再执行更新操作,不会去占有锁。当然，要
注意的是，这个可能存在阻塞的情况，如果一直有查询在的话，那么意味着你的更新操作会一直被滞后。
IGNORE
忽略错误，即使中间某条更新出错，继续执行剩余的列的更新操作。

## UPDATE SET 数据使用 子查询的数据
UPDATE SET 语句的 要更新的值不一定必须是显示指定具体数据的，也可以是来自一个子查询返回的结果，比如
```sql
UPDATE customers 
SET 
    salesRepEmployeeNumber = (SELECT 
            employeeNumber
        FROM
            employees
        WHERE
            jobtitle = 'Sales Rep'
        LIMIT 1)
WHERE
    salesRepEmployeeNumber IS NULL;
```
在这条语句中，我们选择所有 salesRepEmpliyeeNumber 是NULL 的集合，将它们的 salesRepEmployeeNumber 值设置为 来自一个子查询，该子查询 查询employee表，并且jobtitle 是 **Sales Rep** 的数据，并且使用 RAND() 函数 打乱集合，使用 LMIT 限制结果集返回一个。

