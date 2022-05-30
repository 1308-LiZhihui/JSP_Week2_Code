//package com.LiZhihui.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter("/*")//all request
//public class FrontEndAuthenticationFilter implements Filter {
//    private HttpServletRequest httpRequest=null;
//    public static final String[] loginRequiredURLs={"/updateUser","/logout","/cart",
//    	"/accountDetails","/order"};//url which need login
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain Chain) throws IOException, ServletException {
//
//        httpRequest = (HttpServletRequest)request;//change ServletRequest to HttpServletRequest
//        //get path
//        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
//        if (path.startsWith("/admin/")){
//            Chain.doFilter(request,response);//go to next filter -AdminAuthenticationFilter
//            return;
//        }
//
//        //get session
//        HttpSession session = httpRequest.getSession(false);
//        boolean isLoggedIn = (session!=null && session.getAttribute("user")!=null);
//        String loginURI = httpRequest.getContextPath()+"/login";//for public user  - not admin
//        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
//        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login");
//
//        if (isLoggedIn && (isLoginRequest || isLoginPage)){
//            //the admin is already login ande he is trying login again
//            //then forward to the public user homepage
//            //update 2 ServletRequest and ServletResponse
//            httpRequest.getRequestDispatcher("/").forward(request,response);//go to home -public user
//            //update 3 i miss !-not
//        }else if (!isLoggedIn && isLoginRequired()){//check in loginRequiredURLs array
//            //if your is not login in and the requested page requires login
//            //then forward to the login page
//            //update- 4- use
//            request.getRequestDispatcher("/login").forward(request,response);
//        }else {
//            //for other page which not requires login
//            Chain.doFilter(request,response);//go to page
//        }
//
//    }
///*
//method for check requested url need login
// */
//    private boolean isLoginRequired() {
//        //update 1 url not uri
//        String requestURI = httpRequest.getRequestURI().toString();//get url
//
//        for (String loginRequiredURL : loginRequiredURLs){//get one by one from array
//            //check
//            if (requestURI.contains(loginRequiredURL)){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
