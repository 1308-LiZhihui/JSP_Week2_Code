package com.LiZhihui.week5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/Login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
//        ServletContext context=getServletContext();
//        String driver=context.getInitParameter("driver");
//        String url=context.getInitParameter("url");
//        String username=context.getInitParameter("username");
//        String password=context.getInitParameter("password");
//        try {
//            Class.forName(driver);
//            con= DriverManager.getConnection(url,username,password);
//            System.out.println("Connection-->"+con);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sql="select * from usertable where username='"+username+"'and password='"+password+"'";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet= preparedStatement.executeQuery();
            PrintWriter writer=response.getWriter();
            writer.println("<HTML>");
            writer.println("<HEAD>");
            writer.println("</HEAD>");
            writer.println("<BODY>");
            if (resultSet.next()){
                request.setAttribute("id",resultSet.getInt("id"));
                request.setAttribute("username",resultSet.getString("username"));
                request.setAttribute("password",resultSet.getString("password"));
                request.setAttribute("email",resultSet.getString("email"));
                request.setAttribute("gender",resultSet.getString("gender"));
                request.setAttribute("birthdate",resultSet.getString("birthdate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
//                writer.println("<h2>Login success!!!</h2>"+"<br>");
//                writer.println("<h2>Welcome,"+username+"</h2>");
            }
            else{
//                writer.println("<h2>LOGIN ERROR!!!</h2>");
                request.setAttribute("message","Username or password is ERROR!!!");
                request.getRequestDispatcher("Login.jsp").forward(request,response);
            }
            writer.println("</BODY>");
            writer.println("</HTML>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
