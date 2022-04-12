<%@ page import="com.LiZhihui.model.User" %><%--
  Created by IntelliJ IDEA.
  User: lizhihui0916
  Date: 2022/4/4
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>
    User Info
</h1>
<%User user=(User)request.getAttribute("user");%>
<table border="6">
        <tr><td>Username:</td><td><%=user.getUsername()%></td></tr>
        <tr><td>Password:</td><td><%=user.getPassword()%></td></tr>
        <tr><td>Email:</td><td><%=user.getEmail()%></td></tr>
        <tr><td>Gender:</td><td><%=user.getGender()%></td></tr>
        <tr><td>Birth Date:</td><td><%=user.getBirthdate()%></td></tr>
</table>
<%@include file="footer.jsp"%>