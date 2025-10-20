package vn.iotstar.controller;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@WebFilter("/*") 
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("✅ LogFilter init!");
    }

    @Override
    public void destroy() {
        System.out.println("🧹 LogFilter destroy!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String servletPath = req.getServletPath();

        System.out.println("#INFO " + new Date() + " - ServletPath: " + servletPath
                + ", URL = " + req.getRequestURL());

        chain.doFilter(request, response);
    }
}
