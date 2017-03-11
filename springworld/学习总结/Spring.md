
## 注解
spring bean 提供了3种注解分别是
**Repository** 对应DAO层
**Service**  对应Service实现
**Controller** 对应Contoller的实现


## mybatis-spring的注解
给POJO 类加上 Alias("xxx") 注解，这样在mapper.xml中就可以直接使用别名了

在mapper.xml中加上 <cache/> 这样 **resultType** 就不用全限定名称了;
<cache /> 启用了基于 namesapce="..." 的全局缓存

