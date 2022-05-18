<%--
  Created by IntelliJ IDEA.
  User: lizhihui0916
  Date: 2022/5/18
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyDearJsp.jsp</title>
</head>
<body>
<h1>Using Java Code</h1>
<table>
    <tr><td>name:<%=request.getParameter("name")%></td></tr>
    <tr><td>submit:Send data to server</td></tr>
    <tr><td>class:<%=request.getParameter("lclass")%></td></tr>
    <tr><td>ID:<%=request.getParameter("MyID")%></td></tr>
</table>
<%--    EL--%>
<h1>Using EL</h1>
<table>
    <tr><td>name:${param.name}</td></tr>
    <tr><td>submit:Send data to server</td></tr>
    <tr><td>class:${param.lclass}</td></tr>
    <tr><td>ID:${param.MyID}</td></tr>
</table>
</body>
</html>
