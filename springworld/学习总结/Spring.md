
## 注解
spring bean 提供了3种注解分别是
**Repository** 对应DAO层
**Service**  对应Service实现
**Controller** 对应Contoller的实现

>为什么 @Repository 只能标注在 DAO 类上呢？
这是因为该注解的作用不只是将类识别为 Bean，同时它还能将所标注的类中抛出的数据访问异常封装为 Spring 的数据访问异常类型。
Spring 本身提供了一个丰富的并且是与具体的数据访问技术无关的数据访问异常结构，用于封装不同的持久层框架抛出的异常，使得异常独立于底层的框架。



## mybatis-spring的注解
给POJO 类加上 Alias("xxx") 注解，这样在mapper.xml中就可以直接使用别名了

在mapper.xml中加上 <cache/> 这样 **resultType** 就不用全限定名称了;
<cache /> 启用了基于 namesapce="..." 的全局缓存

