package com.LiZhihui.Lab1;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LifeCycleServlet extends HttpServlet {
    private int number;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
        System.out.println("I am from default constructor");
        number = 0;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("service");
        PrintWriter writer = response.getWriter();
        number++;
        writer.println("Since loading,this servlet has been accessed " + number + " times");
        //System.out.println(getServletConfig().getInitParameter("email"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
