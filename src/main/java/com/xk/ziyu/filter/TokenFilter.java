package com.xk.ziyu.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName="testFilter1",urlPatterns= {"/*"})
@Order(FilterRegistrationBean.LOWEST_PRECEDENCE)
public class TokenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化这里");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        String token = req.getHeader("X-Token");
        System.out.println("token:"+token);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
