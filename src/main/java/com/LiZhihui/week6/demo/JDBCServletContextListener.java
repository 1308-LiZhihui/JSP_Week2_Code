package com.LiZhihui.week6.demo;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("I am in contextInitialized()");
        ServletContext context=sce.getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            context.setAttribute("con",con);
            System.out.println("Connection-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("I am in contextDestroyed()");
        sce.getServletContext().removeAttribute("con");
    }
}
