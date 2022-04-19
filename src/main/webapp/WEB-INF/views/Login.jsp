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
<%
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMevale="";
    if(allCookies!=null){
        for(Cookie c:allCookies){
            if(c.getName().equals("cUsername")){
                username=c.getValue();

            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();

            }
            if(c.getName().equals("cRememberMe")){
                rememberMevale=c.getValue();

            }
        }
    }

%>
<form method="post" action="${pageContext.request.contextPath}/login">
    username:<input type="text"  name="username" placeholder="username" value="<%=username%>"><br>
    password:<input type="password" name="password" placeholder="password" value="<%=password%>"><br>
    <input type="checkbox" name="rememberMe" value="1"<%=rememberMevale.equals("1")?"checked":""%>>RememberMe<br/>
    <input type="submit" value="Login">
</form>
<%@include file="footer.jsp"%>

