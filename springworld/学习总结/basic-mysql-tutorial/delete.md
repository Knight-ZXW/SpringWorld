## delete
　　从表中删除指定数据，基本语法如下
```sql
DELETE FROM table   
[WHERE conditions] [ORDER BY ...] [LIMIT rows]
```

### 同 update 语句一样，delete也能联合多表操作。联合多表时，DELETE 后面接的表  表名要处理删除操作的表，如果你只想删除其中某一张表的数据，你也可以只指定其中一张表。
```sql
DELETE table_1, table_2,...
FROM table-refs   
[WHERE conditions]
 
DELETE FROM table_1, table_2,...
USING table-refs
[WHERE conditions]
```

再来个简单的例子
```sql
DELETE employees, 
    offices 
FROM employees, 
 offices 
WHERE employees.officeCode = offices.officeCode  AND 
      offices.officeCode = 1
```

#### INNER JOIN 和  LEFT JOIN 的例子
```sql
FROM offices
INNER JOIN employees 
      ON employees.officeCode = employees.officeCode
WHERE offices.officeCode = 5
```

```sql
DELETE T1
FROM T1 
LEFT JOIN T2 ON T1.key = T2.key 
WHERE T2.key IS NULL
```