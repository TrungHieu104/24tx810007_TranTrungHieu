<h2>Add New Category</h2>
<form action="<%=request.getContextPath()%>/admin/category/add" method="post" enctype="multipart/form-data">
	<div class="mb-3">
		<label class="form-label">Name</label> <input type="text"
			name="name" class="form-control" required>
	</div>

	<div class="mb-3">
		<label class="form-label">Icon</label> <input type="file"
			name="icon" class="form-control">
	</div>

	<div class="mb-3">
		<label class="form-label">Active</label> <select name="isActive"
			class="form-select">
			<option value="true">Active</option>
			<option value="false">Inactive</option>
		</select>
	</div>

	<button type="submit" class="btn btn-primary">Save</button>
	<a href="<%=request.getContextPath()%>/admin/category"
		class="btn btn-secondary">Cancel</a>
</form>