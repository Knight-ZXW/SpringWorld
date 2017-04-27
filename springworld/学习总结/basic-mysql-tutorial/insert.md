## insert 插入语句
基本语句
```sql
INSERT INTO table(column1,column2...)
VALUES (value1,value2,...);
```

同时插入多行
```sql
INSERT INTO tasks(subject,start_date,end_date,description)
VALUES ('Task 1','2010-01-01','2010-01-02','Description 1'),
       ('Task 2','2010-01-01','2010-01-02','Description 2'),
       ('Task 3','2010-01-01','2010-01-02','Description 3');
```
如果你完整的插入每个字段，则可以省略掉 申明字段
```sql
INSERT INTO table
VALUES (value1,value2,...);
```
```sql
INSERT INTO tasks 
VALUES ('Task 1','2010-01-01','2010-01-02','Description 1');
```

INSERT 语句还能与 QUERY语句配合 实现诸如复制整个表的效果
```sql
INSERT INTO table_1
SELECT c1, c2, FROM table_2;
``` 
比如我们复制整个task表到task1
首先创建一个属性和tasks表一样的tasks_1空表
```sql
CREATE TABLE tasks_1 LIKE tasks;
```
接着插入所有了来自tasks表的数据到tasks_1
```sql
INSERT INTO tasks_1
SELECT * FROM tasks;
```


在使用INSET语句的时候，可能会遇到由于冲突（PRIMIARY 或者 UNIQUE），导致插入报错的问题
错误信息类似：**Error Code: 1062. Duplicate entry '4' for key 'PRIMARY' 0.016 sec**
这个使用使用 ON DUPLICATE KEY UPDATE ，效果是当主键已经存在时，不执行插入转而使用UPDATE更新该条数据
例如：
```sql
INSERT INTO tasks(task_id,subject,start_date,end_date,description)
VALUES (4,'Test ON DUPLICATE KEY UPDATE','2010-01-01','2010-01-02','Next Priority')
ON DUPLICATE KEY UPDATE 
   task_id = task_id + 1, 
   subject = 'Test ON DUPLICATE KEY UPDATE';
```
ON DUPLICATE KEY ,指定了如果已经存在 执行UPDATE时执行的操作
