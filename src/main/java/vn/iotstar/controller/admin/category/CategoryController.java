package vn.iotstar.controller.admin.category;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.model.Category;
import vn.iotstar.model.User;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;

import java.util.List;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/admin/category")
public class CategoryController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

//        if (session != null && session.getAttribute("account") != null) {
            User user = (User) session.getAttribute("account");
            req.setAttribute("user", user);
            
            List<Category> categories = cateService.getAll();
            req.setAttribute("categories", categories);

            req.setAttribute("body", "/views/admin/category/index.jsp");
            req.getRequestDispatcher("/views/layouts/admin-layout.jsp").forward(req, resp);
//        } else {
//            resp.sendRedirect(req.getContextPath() + "/login");
//        }
    }
}
