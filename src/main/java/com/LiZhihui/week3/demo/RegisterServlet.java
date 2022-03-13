package com.LiZhihui.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("Username");
        String password = request.getParameter("password");
        String Email = request.getParameter("Email");
        String gender = request.getParameter("gender");
        String Birthdate = request.getParameter("Birthdate");
        PrintWriter writer = response.getWriter();
        writer.println("<HTML");
        writer.println("HEAD");
        writer.println("</HEAD>");
        writer.println("<BODY");
        writer.println("<p>username:"+username+"</p>");
        writer.println("<p>password:"+password+"</p>");
        writer.println("<p>email:"+Email+"</p>");
        writer.println("<p>gender:"+gender+"</p>");
        writer.println("<p>birth date:"+Birthdate+"</p>");
        writer.println("<BODY");
        writer.println("/HTML");
        writer.close();
    }
}
