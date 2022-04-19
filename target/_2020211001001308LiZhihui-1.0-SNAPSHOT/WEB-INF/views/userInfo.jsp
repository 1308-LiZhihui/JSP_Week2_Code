<%@ page import="com.LiZhihui.model.User" %><%--
  Created by IntelliJ IDEA.
  User: lizhihui0916
  Date: 2022/4/4
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%--<%--%>
<%--        Cookie[] allCookies=request.getCookies();--%>
<%--        for(Cookie c:allCookies){--%>
<%--                out.println("<br/>"+c.getName()+"---"+c.getValue());--%>

<%--        }--%>
<%--%>--%>
<h1>
    User Info
</h1>
<%User u=(User)session .getAttribute("user");%>
<table border="6">
        <tr><td>Username:</td><td><%=u.getUsername()%></td></tr>
        <tr><td>Password:</td><td><%=u.getPassword()%></td></tr>
        <tr><td>Email:</td><td><%=u.getEmail()%></td></tr>
        <tr><td>Gender:</td><td><%=u.getGender()%></td></tr>
        <tr><td>Birth Date:</td><td><%=u.getBirthdate()%></td></tr>
</table>
<a href="updateUser">Update User</a>
<%@include file="footer.jsp"%>