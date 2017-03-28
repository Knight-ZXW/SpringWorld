
## introduction to MYSQL SELECT statemention


　　The **SELECT** statement controls which columns and rows that you want to see. For example ,if you are only interested int the firs name,last name, and job title of all emplyees or you just want to see information of everty employee whose job title is the sales rep,the **SELECT** statement helps you to do this.(提到的这些字段及表，位于示例数据库中)
　　Let's take look into the syntax of the **SELECT** statement:
```sql
SELECT 
    column_1, column_2, ...
FROM
    table_1
[INNER | LEFT |RIGHT] JOIN table_2 ON conditions
WHERE
    conditions
GROUP BY column_1
HAVING group_conditions
ORDER BY column_1
LIMIT offset, length;
```
THE **SELECT** statement consists of serveral clauses as explained in the following list:
- SELECT followed by a list of comma-separated columns or an asterisk(*) to indicate that you want to return all columns.
- From specifies the table or view where you want to query the data
- JOIN gets data form other tables based on certain join conditions (JOIN 会专门介绍，这个操作符会加入数据集到当前的操作中)
- WHERE filters rows in the result set.
- GROUP BY groups a set of rows into groups and applies aggregate functions on each group
- HAVING filters group based on groups defined by GROUP BY caluse (HAVING 的作用类似于where,不过他是对group的数据集起作用的，是group的过滤符)
- ORDER BY specifies a list of columns for sorting
- LIMIT constrains the number of returned rows.

THE **SELECT** and  **FROM** caluse are required in the statement . Other parts are optinal.

> 接下来先简答的介绍 **select** 操作符，其他的会在专门的章节讲解
## MYSQL SELECT statement examples
The **SELECT** statment allows you to query partial data of a table by specifying a list of commaspearated columns in the **SELECT** clause. FOR example, if you want to view only first name,last name,and job title of the employees, you ues the following query:

```
SELECT lsatname,firstname,jobtitle
FROM
    emloyees;

```
OR if you want to get data for all columns in the **employee* table, you cal list all column names in the **SELECT** clause. Or you just simply use the asterisk(*) to indicate that you want to get data form all columns of the table as following query:
```sql
SELECT * FROM employee;
```

> (*)操作符返回所有的列信息，在实际的开发中，不应该使用这个来查询数据，我们应该显示声明我们需要的字段，这样可以减少不必要的 硬盘IO操作(更多的数据意味着更多的IO);以及网络IO（这里的IO是指 mysql服务器 和 应用服务器之间的数据流）
