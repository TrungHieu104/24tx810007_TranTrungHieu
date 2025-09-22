<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, vn.iotstar.model.Category" %>

<div class="container mt-4">
    <h2>List Category</h2>

    <table class="table table-bordered table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Icon</th>
                <th>Is Active</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Category> cateList = (List<Category>) request.getAttribute("categories");
                if (cateList != null) {
                    for (Category cate : cateList) {
            %>
                        <tr>
                            <td><%= cate.getId() %></td>
                            <td><%= cate.getName() %></td>
                            <td>
                                <% if (cate.getIcon() != null && !cate.getIcon().isEmpty()) { %>
                                    <img src="<%= request.getContextPath() %><%= cate.getIcon() %>" 
                                         alt="<%= cate.getName() %>" width="80">
                                <% } %>
                            </td>
                            <td>
                                <%= (cate.getIsActive() != null && cate.getIsActive()) ? "✔ Active" : "✖ Inactive" %>
                            </td>
                            <td>
                                <a href="<%= request.getContextPath() %>/admin/category/edit?id=<%= cate.getId() %>" class="btn btn-sm btn-primary">Edit</a>
                                <a href="<%= request.getContextPath() %>/admin/category/delete?id=<%= cate.getId() %>" class="btn btn-sm btn-danger" onclick="return confirm('Are you want to delete?')">Delete</a>
                            </td>
                        </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>

    <a href="<%= request.getContextPath() %>/admin/category/add" class="btn btn-success">+ Thêm Category</a>
</div>
