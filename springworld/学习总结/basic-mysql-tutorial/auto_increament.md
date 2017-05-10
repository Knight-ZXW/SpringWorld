## AUTO_INCREMENT 
AUTO_INCREMENT 用于表示 键值自增长，可以避免手动计算键值，并且让sql引擎保证建值的不重复问题。
我们在插入了一条 带自增长主键的记录后，希望获得刚才插入的主键值，可以通过 **LAST_INSERT_ID();** 函数来获得

```sql
INSERT INTO tbl(description)
VALUES('record 1'),
      ('record 2'),
      ('record 3');
 
SELECT LAST_INSERT_ID();
```

以上，如果你同时插入多条记录，**LAST_INSERT_ID()** 只会返回第一条记录的ID.