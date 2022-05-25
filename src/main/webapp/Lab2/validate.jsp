<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<%--Todo 1: Use <jsp:useBean> to create a Login bean instance in request scope --%>
<jsp:useBean id="user" class="com.LiZhihui.Lab2.Login" scope="request" ></jsp:useBean>

    <%--Todo 2: Use <jsp:setProperty> to set  beans' property username and password--%>
<jsp:setProperty name="user" property="username" value='<%=request.getParameter("username")%>'/>
<jsp:setProperty name="user" property="password" value='<%=request.getParameter("password")%>'/>

<%
    if(user.getUsername().equals("admin") && user.getPassword().equals("admin")){
        request.getSession().setAttribute("username",user.getUsername());
   //todo 3: use if check username is admin and password is admin
%>
    <%--todo 4: use jsp:forward to welcome.jsp page--%>
    <jsp:forward page="welcome.jsp"/>
    <%--todo 5: else part{ --%>
<%}else{%>

<%
// todo 6: print username or password error message
    out.print("Username Password Error");

%>
    <%--todo 7: use jsp:include login.jsp page --%>
<jsp:include page="login.jsp"/>

    <%--todo 8: close else --%>
<%}%>

</body>
</html>