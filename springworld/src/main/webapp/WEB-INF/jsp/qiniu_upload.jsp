<%--
  Created by IntelliJ IDEA.
  User: zhuoxiuwu
  Date: 2017/3/9
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>七牛云文件上传示例</title>
</head>
<body>
<form method="post" action="http://upload.qiniu.com/"
      enctype="multipart/form-data">
    <input name="key" type="hidden" value="<resource_key>">
    <input name="x:<custom_name>" type="hidden" value="<custom_value>">
    <input name="token" type="hidden" value="<upload_token>">
    <input name="file" type="file"/>
    <input name="crc32" type="hidden"/>
    <input name="accept" type="hidden"/>
    <button type="submit" value="上传"/>
</form>
</body>
</html>
