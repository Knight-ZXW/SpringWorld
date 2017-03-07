## xml 配置

- 可以使用 properties 配置信息 替换 dataSource 中的 properties
- **typeAliases** 可以给 给 Java 类型设置一个简短的名字，它只和XML配置有关
作用是减少 类完全限定名称的冗余;也可以指定一个 package ,mybatis会自动搜索
包下的Model.
- 通过typeHandlers 可以自定义自己的 sql数据类型与Java 类型的转换
- mapper 可以指定是绝对路径、包路径、抽象的mapper类，或者是制定一个packge,会自动扫描
