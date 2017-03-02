##  ClassPathXmlApplicationContext
```java
ApplicationContext context =
new ClassPathXmlApplicationContext("Beans.xml");
```

## AnnotationConfigApplicationContext
@Configuration 作用于类 表明这是一个 配置类
@Bean 作用于方法 表明这是一个 bean ,同时还可以配置 bean的相关属性，如initMethod  和 destoryMethod ，@Scope 用于指定 Bean 类型 ，如单例 或者prototype
@import 也是作用于类 注解允许从另一个配置类中加载 @Bean  定于
内部的代码示例
```java
ApplicationConigApplicationContext ctx = new ApplicationConfigApplicationContext(xxConfig.Class);
ctx.getBean(yy.class);
```

