## servlet 是线程安全的吗？

> Web应用程序的并发请求处理通常需要 Web  开发人员去设计适合多线程执行的Servlet,从而保证 service
方法能再一个特定时间点处理多线程并发执行。(即 Servlet 默认是线程不安全的，需要开发人员去处理多线
程安全的问题)
通常 Web 容器对于并发请求将使用同一个 servlet 处理，并且在不同的线程中并发执行 service 方法


## 什么是servlet的生命周期
> Servlet 是由 Servlet容器负责加载并实例化的。加载和实例化的时机可以在容器启动时，或者在容器
判断有请求需要处理时。  Servlet实例通常遵循 一个严格的生命周期函数定义（可以查看interface servlet）,
该生命周期规定了 servlet 如何被加载、实例化、初始化、处理客户端请求、以及结束服务。该生命周期可以通过
Javax.servlet.Servlet 接口中的 init、service 和 destroy 这些API来表示。所有的  Servlet 都直接或者间接
的实现了  GenericServlet 或 HttpServlet 抽象类

## Servlet 是如何做请求处理的
Servlet是由容器初始化的，在 Servlet初始化完成后，如果 有请求需要交由 该Servlet处理，则Servlet容器会根据请求信息
封装响应的 ServletRequest 和 ServletResponse 对象 注入到 service方法中，用户直接在 service方法中编写具体的处理逻辑。


