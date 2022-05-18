<%--
  Created by IntelliJ IDEA.
  User: lizhihui0916
  Date: 2022/5/18
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Using Jsp</title>
</head>
<body>
    <h2>I am MyJsp.jsp</h2>
    <form method="post" action="MyDearJsp.jsp">
        name:<input type="text" name="name" value="LiZhihui"><br>
        class:<input type="text" name="lclass" value="13"><br>
        ID:<input type="text" name="MyID" value="2020211001001308" ><br>
        <input type="submit" value="Send data to server">
    </form>
</body>
</html>
