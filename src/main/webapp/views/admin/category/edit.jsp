<%@ page import="vn.iotstar.model.Category"%>
<%
Category category = (Category) request.getAttribute("category");
%>
<h2>Edit Category</h2>
<form action="<%=request.getContextPath()%>/admin/category/edit" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="<%=category.getId()%>">

	<div class="mb-3">
		<label class="form-label">Category Name</label> <input type="text"
			name="name" class="form-control" value="<%=category.getName()%>"
			required>
	</div>

	<div class="mb-3">
		<label class="form-label">Icon URL</label> <input type="file"
			name="icon" class="form-control" value="<%=category.getIcon()%>">
	</div>

	<div class="mb-3">
		<label class="form-label">Active</label> <select name="isActive"
			class="form-select">
			<option value="true" <%=category.getIsActive() ? "selected" : ""%>>Active</option>
			<option value="false" <%=!category.getIsActive() ? "selected" : ""%>>Inactive</option>
		</select>
	</div>

	<button type="submit" class="btn btn-success">Update</button>
	<a href="<%=request.getContextPath()%>/admin/category"
		class="btn btn-secondary">Cancel</a>
</form>