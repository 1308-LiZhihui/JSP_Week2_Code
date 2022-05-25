package com.LiZhihui.Lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "LiZhihuiFilter")
public class LiZhihuiFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("LiZhihuiFilter-->before chain");
        chain.doFilter(request, response);
        System.out.println("LiZhihuiFilter-->after chain");
    }
}
