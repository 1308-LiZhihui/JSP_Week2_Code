<%--
  Created by IntelliJ IDEA.
  User: lizhihui0916
  Date: 2022/3/5
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script language="JavaScript">
    function on_submit()
    {
        let username=document.getElementById("1").value;
        if (username==null||username===''){
            alert("username can not be null!")
            return false;
        }
        let password=document.getElementById("2").value;
        if (password==null||password===''){
            alert("password can not be null!")
            return false;
        }
        if (password.length<8){
            alert("lengh must be at least 8 characters!");
            return false;
        }
        let Email=document.getElementById("3").value;
        const reg=/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        if (!reg.test(Email)){
            alert("invalid Email")
            return false;
        }
    }
</script>
<head>
    <title>New User Registration</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/register" align="center" name="form1" method="post" onsubmit="return on_submit()">
    <h2>New User Registration!</h2><br>
    <input type="text"  name="Username"id="1" placeholder="Username" style="background-color: antiquewhite;width: 200px"><br>
    <input type="password" name="password" id="2" placeholder="password" style="background-color: antiquewhite;width: 200px"><br>
    <input type="text" name="Email" id="3" placeholder=Email style="background-color: antiquewhite;width: 200px"><br>
    <strong>Gender</strong> <input type="radio" name="gender" value="male">Male
           <input type="radio" name="gender" value="female">Female<br>
    <input type="date" name="Birthdate" placeholder="Date of birth(yyyy-mm-dd)" style="background-color: antiquewhite;width: 200px"><br>
    <input type="submit" value="Register" style="background-color: chartreuse">
</form>
</body>
</html>
