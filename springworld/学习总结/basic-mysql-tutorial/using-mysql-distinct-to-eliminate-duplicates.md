
--------------

## Introduction to MYSQL DISTINCT clause

When querying data from table, you may get duplicate rows. In order to remove these duplicate rows, you use th **DISTINCT** clause in the **SELECT statement**

The syntax of using **DISTINCT** clause is as follows:
```sql
SELECT DISTINCT
    columns
FROM
    table_name
WHERE
    where_conditions;
```

## MYSQL DISTINCT example

Let's take a look a simple example of using the **DISTINCT** clause to select the unique last names of
emplyees from the **employees** table.

First, we query the last names of **employees** table using the **SELECT** statement as follows:
```sql
SELECT 
    lastname
FROM
    employee
ORDER BY lastname;
```
The result like

![image](http://www.mysqltutorial.org/wp-content/uploads/2011/02/mysql-duplicate-last-name.png)

some employees have the same last name **Bondur** ,**Firrelli** etc.
To remove the duplicate last names, you add **DISTINCT** caluse to the **SELECT** statement as follows:
```sql
SELECT DISTINCT
    lastname
FROM 
    employees
ORDER BY lastname;
```
THe duplicate last names are eliminated in the result set when we used the **DISTINCT** clause.

## MYSQL DISTINCT and NULL values

if a column has **NULL** values and you uese the **DISTINCT** clause for that column,MYSQL keeps one **NULL** value and eliminates the other because the **DISTINCT** clause treats all **NULL** values as the same value.

## MySQL DISTINCT with multiple columns

You can use **DISTINCT** clause with more than one column. In this case,MYSQL uses the combination of all columns to determine the uniqueness of the row in the result set. 

For example, to get the unique combination fo city and state from the **customers** table, you use the following query:
```sql
SELECT DISTINCT
    state,city
FROM 
    customers
WHERE
    state IS NOT NULL
ORDER BY state, city;
```

![image](http://www.mysqltutorial.org/wp-content/uploads/2011/02/MySQL-DISTINCT-multiple-columns-example.png)

without the **DISTINCT* clause,you will get duplicate combination of state and city .

![image](http://www.mysqltutorial.org/wp-content/uploads/2011/02/MySQL-without-DISTINCT-clause-on-multiple-columns.png)

## DISTINCT clause vs GROUP BY clause
If you use **GROUP BY clause** int the select statement without using **aggregate functions,** the **GROUP BY** clause behaves like **DISTINCT** clause.

The following statement uses the **GROUP BY** clause to select the unique states of customers in the customers table.
```sql
SELECT
    state
FROM
    customers
GROUP BY state;
```
------
```sql
SELECT DISTINCT
    state
FROM
    customers;
```
(以上2条sql 语句的执行结果是一样的，区别在于group by 会有个默认的排序效果)

Generally speaking, the DISTINCT clause is a special case of the GROUP BY clause. The difference between DISTINCT clause and GROUP BY clause is that the GROUP BY clause sorts the result set whereas the DISTINCT clause does not.

If you add the ORDER BY clause to the statement that uses the  DISTINCT clause, the result set is sorted and it is the same as the one returned by the statement that uses GROUP BY clause.
```
SELECT DISTINCT
    state
FROM
    customers
ORDER BY state;
```

### MYSQL DISTINCT and aggregate function
You can use the DISTINCT clause with an aggregate function e.g., **SUM**, **AVG**, and **COUNT**, to remove duplicate rows before MySQL applies the aggregate function to the result set.

For example, to count the unique states of customers in the U.S., you use the following query:

```sql
SELECT COUNT(DISTINCT state)
FROM customers
WHERE
    country = 'USA;
```

### MYSQL DISTINCT with LIMIT clause
In case you use the DISTINCT clause with the LIMIT clause, MySQL stops searching immediately when it finds the number of unique rows specified in the LIMIT clause.

The following query selects the first 5 non-null unique states in the customers table.
```
SELECT DISTINCT
    state
FROM
    customers
WHERE
    state IS NOT NULL
LIMIT 5;
```


## 总结
- distinct 作用 select 语句中的 返回字段，表明在返回结果集前，根据该字段对结果集去重
- distinct 也会把字段值为null的结果 视为重复数据，
- distinct (column) 和 group by(column) 的语句可以起到近乎同样的效果，不过 group by 有默认的排序效果；同样的如果给 select distinct 语句再加上 ORDER by，两者可以起到完全相同的效果（在结果上）
- 简单是示范了一些WHERE 条件语句