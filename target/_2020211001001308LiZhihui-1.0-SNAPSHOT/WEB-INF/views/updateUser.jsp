<%--
  Created by IntelliJ IDEA.
  User: lizhihui0916
  Date: 2022/4/19
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<%
    User u=(User) session.getAttribute("user");
%>
<form action="updateUser" align="center" name="form1" method="post">
    <h2>User Update</h2><br>
    <input type="hidden" name="id" value="<%=u.getId()%>">
    <input type="text"  name="Username"id="1" placeholder="Username" value="<%=u.getUsername()%>"style="background-color: antiquewhite;width: 200px"><br>
    <input type="password" name="password" id="2" placeholder="password" value="<%=u.getPassword()%>" style="background-color: antiquewhite;width: 200px"><br>
    <input type="text" name="Email" id="3" placeholder=Email value="<%=u.getEmail()%>"style="background-color: antiquewhite;width: 200px"><br>
    <strong>Gender</strong> <input type="radio" name="gender" value="male" <%="male".equals(u.getGender())?"checked":""%>>Male
    <input type="radio" name="gender" value="female"<%="fe male".equals(u.getGender())?"checked":""%>>Female<br>
    <input type="date" name="Birthdate" placeholder="Date of birth(yyyy-mm-dd)"  value="<%=u.getBirthdate()%>" style="background-color: antiquewhite;width: 200px"><br>
    <input type="submit" value="Save Changes" style="background-color: chartreuse">
</form>
<%@include file="footer.jsp"%>