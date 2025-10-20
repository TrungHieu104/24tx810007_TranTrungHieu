package vn.iotstar.controller;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.model.User;

import java.io.IOException;
import java.util.Date;

@WebFilter("/admin/*") 
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("✅ AdminFilter init!");
    }

    @Override
    public void destroy() {
        System.out.println("🧹 AdminFilter destroy!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    		 throws IOException, ServletException {
    	System.out.println("#INFO AdminFilter");
    	HttpServletRequest req=(HttpServletRequest) request;
    	HttpServletResponse resq= (HttpServletResponse) response;
    	HttpSession session = req.getSession();
    	Object obj=session.getAttribute("account");
    	User user= (User) obj;
    	if(user !=null && user.getRoleid()==2 ) {
    		chain.doFilter(request, response);
    		return;
    	}else {
    		System.out.println("#INFO AdminFilter logout");
    		resq.sendRedirect(req.getContextPath()+ "/logout");
    	}
    }
}
