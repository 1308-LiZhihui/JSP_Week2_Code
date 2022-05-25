package com.LiZhihui.Lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
//todo 1: map this filter for -1./lab2/validation.jsp and /lab2/welcome.jsp
@WebFilter(filterName = "LoginFilter",urlPatterns = {"/Lab2/validation.jsp","/Lab2/welcome.jsp"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        //todo 2: System out print i am in LoginFilter--init()
        System.out.println("i am in LoginFilter--init()");
    }

    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        //todo 4: System out print i am in LoginFilter--doFilter()-- request before chain
        System.out.println("i am in LoginFilter--doFilter()-- request before chain");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //todo 6: if(session not new){
        if(req.getSession().getAttribute("username")!=null){
            //todo 7: forword to Lab2/welcome.jsp
            String username = (String) req.getSession().getAttribute("username");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/Lab2/welcome.jsp").forward(req,resp);
            //todo 8: else{redirect to login.jsp}
        }else{
            req.getRequestDispatcher("/Lab2/login.jsp").forward(req,resp);
        }
        chain.doFilter(request, response);
        //todo 5: System out print i am in LoginFilter--destroy()-- response after chain
        System.out.println("i am in LoginFilter--doFilter()-- response after chain");
    }
}
