
## 什么是servlet的生命周期
> Servlet 是由 Servlet容器负责加载并实例化的。加载和实例化的时机可以在容器启动时，或者在容器
判断有请求需要处理时。  Servlet实例通常遵循 一个严格的生命周期函数定义（可以查看interface servlet）,
该生命周期规定了 servlet 如何被加载、实例化、初始化、处理客户端请求、以及结束服务。该生命周期可以通过
Javax.servlet.Servlet 接口中的 init、service 和 destroy 这些API来表示。所有的  Servlet 都直接或者间接
的实现了  GenericServlet 或 HttpServlet 抽象类

## Servlet 是如何做请求处理的
>Servlet是由容器初始化的，在 Servlet初始化完成后，如果 有请求需要交由 该Servlet处理，则Servlet容器会根据请求信息
封装响应的 ServletRequest 和 ServletResponse 对象 注入到 service方法中，用户直接在 service方法中编写具体的处理逻辑。


## servlet 是线程安全的吗？

> Web应用程序的并发请求处理通常需要 Web  开发人员去设计适合多线程执行的Servlet,从而保证 service
方法能再一个特定时间点处理多线程并发执行。(即 Servlet 默认是线程不安全的，需要开发人员去处理多线
程安全的问题)
通常 Web 容器对于并发请求将使用同一个 servlet 处理，并且在不同的线程中并发执行 service 方法


## Request 和 Response 对象 的生命周期
每个 Request 对象只在 servlet 的 **service**  方法的作用域内或在过滤器的 **doFilter** 有效；**除非**该组件启用了异步处理 并且调用了 requet 对象的 **startAsync** 方法。在发生异步处理的情况下 **request** 对象一直有效（把request 的引用传给了异步环境）直到调用了 AsyncContext 的 complete方法 。容器通常后复用 request 对象，以避免创建request对象的性能开销。

## 什么是ServletContext

ServletContext 是由容器供应商负责提供的，表示servlet运行所在的 Web 应用的视图。每一个部署到容器的应用 Web 应用都有 Servlet 接口的实例与之关联。在容器分布在多台虚拟机的情况下，每个  JVM 的每个 Web 应用都有一个 ServletContext 实例。如果容器内的 Servlet 没有部署到 Web 应用中，则隐含的作为“默认”Web 应用的一部分，并有一个默认的 ServletContext。在分布式的容器中，默认的 ServletContext 是非分布式的且仅存在于一个 JVM 中。     