<%--
  Created by IntelliJ IDEA.
  User: lizhihui0916
  Date: 2022/5/3
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo#1- Week 10</title>
</head>
<body>
<h2>Use of pageContext to set ,get , remove attribute from 4 scopes:page,request,session,application</h2>
<%
//set attribute in page ,request,session,application
    //pageContext.setAttribute("attName","in page");
    request.setAttribute("attName","in request");
    session.setAttribute("attName","in session");
    //application.setAttribute("attName","in application");//use implicit object
    //set using page context
    pageContext.setAttribute("attName","in application",PageContext.APPLICATION_SCOPE);
%>
<h2>Get attribute using implicit objects- way1</h2>
Att value : <%=pageContext.getAttribute("attName")%><br>
Att value : <%=request.getAttribute("attName")%><br>
Att value : <%=session.getAttribute("attName")%><br>
Att value : <%=application.getAttribute("attName")%><br>
<h2>Get attribute using pageContext- way2</h2>
Att Value <%=pageContext.getAttribute("attName",PageContext.PAGE_SCOPE)%><br>
Att Value <%=pageContext.getAttribute("attName",PageContext.REQUEST_SCOPE)%><br>
Att Value <%=pageContext.getAttribute("attName",PageContext.SESSION_SCOPE)%><br>
Att Value <%=pageContext.getAttribute("attName",PageContext.APPLICATION_SCOPE)%><br>
<h2>Use findAttribute of pageContext-search -page-request-session-application-Null</h2>
Att Value :<%=pageContext.findAttribute("attName")%>(which one ?)
</body>
</html>
