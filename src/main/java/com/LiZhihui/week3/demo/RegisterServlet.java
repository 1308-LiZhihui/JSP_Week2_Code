package com.LiZhihui.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name="RegisterServlet",urlPatterns = {"/register"})

public class RegisterServlet extends HttpServlet {
    Connection con;

    {
        con = null;
    }
    @Override

    public void init() throws ServletException {
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost:1433;database=userDB;encrypt=false";
        //String username="sa";
        //String password="123456";


        //ServletConfig config = getServletConfig();
        //String driver=config.getInitParameter("driver");
        //String url=config.getInitParameter("url");
        //String username=config.getInitParameter("username");
        //String password=config.getInitParameter("password");
        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

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
        String sql ="select max(id) min from usertable";
        int id = 0;
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt("min");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql1="insert into usertable(id,username,password,email,gender,birthdate)" +
                "values(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement= con.prepareStatement(sql1);
            preparedStatement.setInt(1,id+1);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,password);
            preparedStatement.setString(4,Email);
            preparedStatement.setString(5, gender);
            preparedStatement.setDate(6, Date.valueOf(Birthdate));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter writer = response.getWriter();
        writer.println("<HTML>");
        writer.println("<HEAD>");
        writer.println("</HEAD>");
        writer.println("<BODY>");
        String sql2 ="select * from usertable";
        writer.println("<table border='1'>");
        writer.println("<tr>");
        writer.println("<th>"+"ID"+"</th>");
        writer.println("<th>"+"Username"+"</th>");
        writer.println("<th>"+"Password"+"</th>");
        writer.println("<th>"+"Email"+"</th>");
        writer.println("<th>"+"Gender"+"</th>");
        writer.println("<th>"+"Birthday"+"</th>");
        writer.println("</tr>");
        try {
            PreparedStatement preparedStatement=con.prepareStatement(sql2);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                writer.println("<tr>");
                writer.println("<td>"+resultSet.getInt("id")+"</td>");
                writer.println("<td>"+resultSet.getString("username")+"</td>");
                writer.println("<td>"+resultSet.getString("password")+"</td>");
                writer.println("<td>"+resultSet.getString("email")+"</td>");
                writer.println("<td>"+resultSet.getString("gender")+"</td>");
                writer.println("<td>"+resultSet.getDate("birthdate")+"</td>");
                writer.println("</tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.println("</table>");
        writer.println("</BODY>");
        writer.println("</HTML>");
        writer.close();
    }
}
