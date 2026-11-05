package com.sonnet.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    // 执行过滤业务的方法
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter过滤器方法执行了...");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
