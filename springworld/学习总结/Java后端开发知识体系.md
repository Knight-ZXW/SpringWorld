##
- 什么是 web Application 和app application如常说的 tomcat、jetty
- tomcat源码是用Java写的，tomcat以及 Apache http server ，Apache http server 是用c语言开发的；tomcat是Java语言编写的一个servlet容器
- 什么是AJP协议
## Servlet容器 以及 Servlet
 什么是Servlet，以及了解常用的Servlet 如 tomcat

 > A servlet is a small Java program that runs within a Web server. Servlets
 receive and respond to requests from Web clients, usually across HTTP, the
 HyperText Transfer Protocol.

 Servlet是一个抽象的概念，web服务实际上就是应用程序监听电脑上的80端口，获取 tcp 数据，再使用 http协议解析 再做相应的处理，所以在我们
 编写的应用程序处理之前，实际上还有一个 servlet 容器服务的程序，帮我们处理这些东西，之后经过层层过滤 转换成 servlet对象，交给我们的app
 处理

 ## spring 框架的整个生态
 todo

