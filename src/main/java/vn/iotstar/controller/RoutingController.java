package vn.iotstar.controller;

import vn.iotstar.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/routing")
public class RoutingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session = req.getSession();
    	if (session == null || session.getAttribute("account") == null) {
    	    resp.sendRedirect(req.getContextPath() + "/login");
    	    return;
    	}

    	User u = (User) session.getAttribute("account");
    	switch (u.getRoleid()) {
    	    case 1:
    	        resp.sendRedirect(req.getContextPath() + "/admin/category");
    	        return;
    	    case 2:
    	        resp.sendRedirect(req.getContextPath() + "/manager/home");
    	        return;
    	    default:
    	        resp.sendRedirect(req.getContextPath() + "/home");
    	        return;
    	}

    }
}
