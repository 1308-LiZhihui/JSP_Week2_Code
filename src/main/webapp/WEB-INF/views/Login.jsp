<%--
  Created by IntelliJ IDEA.
  User: lizhihui0916
  Date: 2022/3/27
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%if(!(request.getAttribute("message")==null)){
    out.println("<h3>"+request.getAttribute("message")+"</h3>");
}%>
<form method="post" action="${pageContext.request.contextPath}/login">
    username:<input type="text"  name="username" placeholder="username"><br>
    password:<input type="password" name="password" placeholder="password"><br>
    <input type="submit" value="Login">
</form>
<%@include file="footer.jsp"%>

