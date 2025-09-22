package vn.iotstar.controller.admin.category;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.model.Category;
import vn.iotstar.model.User;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/admin/category/add")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class CategoryAddController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String id = req.getParameter("id");

		if (session != null && session.getAttribute("account") != null) {
			User user = (User) session.getAttribute("account");
			req.setAttribute("user", user);
			req.setAttribute("body", "/views/admin/category/add.jsp");
			req.getRequestDispatcher("/views/layouts/admin-layout.jsp").forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String isActiveStr = req.getParameter("isActive");
        boolean isActive = Boolean.parseBoolean(isActiveStr);

        Part filePart = req.getPart("icon");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        String uploadPath = req.getServletContext().getRealPath("/uploads/categories");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String filePath = null;
        if (fileName != null && !fileName.isEmpty()) {
            filePath = uploadPath + File.separator + fileName;
            filePart.write(filePath);
        }

        Category category = new Category();
        category.setName(name);
        category.setIsActive(isActive);
        category.setIcon("/uploads/categories/" + fileName);

        cateService.insert(category);

        resp.sendRedirect(req.getContextPath() + "/admin/category");
    }
}
