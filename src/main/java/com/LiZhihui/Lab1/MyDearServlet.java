package com.LiZhihui.Lab1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyDearServlet", value = "/MyDearServlet")
public class MyDearServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head><title>UsingServlet</title></head>");
        writer.println("<body>");
        writer.println("<table>");
        writer.println("<tr>"+"<td>"+"name:LiZhihui"+"</td>"+"</tr>");
        writer.println("<tr>"+"<td>"+"sumbit:Send data to server"+"</td>"+"</tr>");
        writer.println("<tr>"+"<td>"+"class:13"+"</td>"+"</tr>");
        writer.println("<tr>"+"<td>"+"id:2020211001001308"+"</td>"+"</tr>");
        writer.println("</table>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
