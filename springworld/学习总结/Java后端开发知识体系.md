## Servlet容器 以及 Servlet
 什么是Servlet，以及了解常用的Servlet 如 tomcat

 > A servlet is a small Java program that runs within a Web server. Servlets
 receive and respond to requests from Web clients, usually across HTTP, the
 HyperText Transfer Protocol.

 Servlet是一个抽象的概念，web服务实际上就是应用程序监听电脑上的80端口，获取 tcp 数据，再使用 http协议解析 再相应的处理，所以在我们
 编写的应用程序之前，实际上还有一个 servlet 容器服务的程序，帮我们处理这些东西，之后再 示例化成 servlet对象，交给我们处理.
