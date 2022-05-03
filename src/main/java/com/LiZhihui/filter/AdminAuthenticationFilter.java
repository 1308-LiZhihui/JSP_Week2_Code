package com.LiZhihui.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")//this filter for all admin url
public class AdminAuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain Chain) throws IOException, ServletException {
        //change ServletRequest to HttpServletRequest
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        //get session
        HttpSession session = httpRequest.getSession(false);
        boolean isLoggedIn = (session!=null && session.getAttribute("user")!=null);
        String loginURI = httpRequest.getContextPath()+"/admin/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login");
        if (isLoggedIn && (isLoginRequest || isLoginPage)){
            //the admin is already login ande he is trying login again
            //then forward to the admin homepage
            request.getRequestDispatcher("/admin/home").forward(httpRequest,httpResponse);//go to home

        }else if (isLoggedIn || isLoginRequest){

            Chain.doFilter(request,response);//go to next destination
        }else {
        	System.out.println(httpRequest.getContextPath());
            httpResponse.sendRedirect(httpRequest.getContextPath()+"/login");//go to login
        }
    }

    @Override
    public void destroy() {

    }
}
