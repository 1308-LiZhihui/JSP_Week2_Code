package com.LiZhihui.week3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LifeCycleServlet", value = "/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
    public LifeCycleServlet() {
        System.out.println("i am in constructor -->LifeCycleServlet()");
    }
    @Override
    public void init(){
        System.out.println("i am in init()");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in service() --> doGet()");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        System.out.println("i am in destroy()");
    }
}
