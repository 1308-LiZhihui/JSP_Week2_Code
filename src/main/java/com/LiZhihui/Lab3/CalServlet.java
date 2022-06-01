package com.LiZhihui.Lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "CalServlet", urlPatterns = "/CalServlet")
public class CalServlet extends HttpServlet {
    //todo 1.create a method to add two numbers
    public int add(int firstVal, int secondVal) {
        return firstVal + secondVal;
    }
    //todo 2.create a method to subtract two numbers
    public int sub(int firstVal, int secondVal) {
        return firstVal - secondVal;
    }
    //todo 3.create a method to multiply two numbers
    public int mul(int firstVal, int secondVal) {
        return firstVal * secondVal;
    }
    //todo 4.create a method to divide two numbers
    public double div(int firstVal, int secondVal) {
        double n = (double) firstVal / secondVal;
        //保留两位小数
        return (double) Math.round(n * 100) / 100;
    }
    //todo 5.create a method to computeLength of a string
    public int computeLength(String str) {
        return str.length();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //todo 6.get all request parameters firstVal, secondVal, name,action
        String firstVal = request.getParameter("firstVal");
        String secondVal = request.getParameter("secondVal");
        String cName = request.getParameter("cName");
        String action = request.getParameter("action");
        int result = 0;
        double result1 = 0.0;
        //todo 7:use if else to determine action is add or substrata or multiply or divide or computerLength
        //todo 8:call method add subtract ,multiply, divide or computeLength on action and get the calculated result
        if(action.equals("add")){
            result = add(Integer.parseInt(firstVal),Integer.parseInt(secondVal));
        }else if(action.equals("subtract")) {
            result = sub(Integer.parseInt(firstVal), Integer.parseInt(secondVal));
        }else if(action.equals("multiply")) {
            result = mul(Integer.parseInt(firstVal), Integer.parseInt(secondVal));
        }else if(action.equals("divide")) {
            result1 = div(Integer.parseInt(firstVal), Integer.parseInt(secondVal));
        }else if(action.equals("computerLength")) {
            result = computeLength(cName);
        }
        //todo 9:if action is add or subtract or multiply or divide
        if(action.equals("add") || action.equals("subtract") || action.equals("multiply") || action.equals("divide")){
            //todo 10:create 3 cookies to store the result, firstVal, secondVal, action
            HttpSession session = request.getSession();
            session.setAttribute("cFirstVal",firstVal);
            session.setAttribute("cSecondVal",secondVal);
            //session.setAttribute("cResult",result);
            if (action.equals("divide")) {
                session.setAttribute("cResult",result1);
            }else{
                session.setAttribute("cResult",result);
            }
            //todo 11:add 3 cookies to response
            response.addCookie(new Cookie("cFirstVal",firstVal));
            response.addCookie(new Cookie("cSecondVal",secondVal));
            response.addCookie(new Cookie("cResult",String.valueOf(result)));
        }
        //todo 12:if action is computerLength
        if(action.equals("computerLength")){
            //todo 13:create a cookie to store the result
            HttpSession session = request.getSession();
            session.setAttribute("cName",cName);
            session.setAttribute("cLength",computeLength(cName));
            //todo 14:add two cookies to response
            response.addCookie(new Cookie("cName",cName));
            response.addCookie(new Cookie("cLength",String.valueOf(computeLength(cName))));
        }
        //todo 15:send redirect to cal.jsp
        response.sendRedirect("Lab3/cal.jsp");
}
}
