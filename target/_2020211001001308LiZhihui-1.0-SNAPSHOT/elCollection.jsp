<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: lizhihui0916
  Date: 2022/5/10
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo -3- week 11</title>
</head>
<body>
<%
//array
    String [] firstName={"Bill","Scott","Larry"};

    //list
    ArrayList<String> lastName=new ArrayList<>();
    lastName.add("Ellison");
    lastName.add("Gates");
    lastName.add("McNealy");

    //map
    HashMap<String,String> companyName=new HashMap<>();
    companyName.put("Ellison","Sun");
    companyName.put("Gates","Oracle");
    companyName.put("McNealy","Microsoft");

    //set attribute in any one scope
    request.setAttribute("fname",firstName);
    request.setAttribute("lname",lastName);
    request.setAttribute("company",companyName);

%>
<h2>get data from Array -->List -->Map -using EL Code</h2>
<ul>
    <!--use loop - in jstl - next class-->
    <li>${fname["0"]}-->${lname["0"]}-->${company.Ellison}</li>
    <li>${fname["1"]}-->${lname["1"]}-->${company[lname["1"]]}</li>
    <li>${fname["2"]}-->${lname["2"]}-->${company[lname["2"]]}</li>
</ul>

</body>
</html>
