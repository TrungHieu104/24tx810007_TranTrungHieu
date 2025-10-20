package vn.iotstar.controller;

import vn.iotstar.model.User;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet("/login")  
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            resp.sendRedirect(req.getContextPath() + "/routing");
            return;
        }

        // Check cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = req.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/routing");
                    return;
                }
            }
        }

        // forward tới trang login.jsp
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        boolean isRememberMe = "on".equals(remember);

        String alertMsg = "";
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }

        UserService service = new UserServiceImpl();
        User user = service.login(username, password);

        if (user == null) {
            alertMsg = "Tài khoản hoặc mật khẩu không đúng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }

        HttpSession session = req.getSession(true);
        session.setAttribute("account", user);
        
        if (isRememberMe) {
        	saveRememberMe(resp, username);
        }
        resp.sendRedirect(req.getContextPath() + "/routing");
    }

    private void saveRememberMe(HttpServletResponse response, String username) {
        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(30 * 60);
        response.addCookie(cookie);
    }
}
