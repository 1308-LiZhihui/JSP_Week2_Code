<%--
  Created by IntelliJ IDEA.
  User: lizhihui0916
  Date: 2022/3/27
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>Login</h1>
<form method="post" action="${pageContext.request.contextPath}/Login">
    username:<input type="text"  name="Username" placeholder="username"><br>
    password:<input type="password" name="password" placeholder="password"><br>
    <input type="submit" value="Login">
</form>
<%@include file="footer.jsp"%>

