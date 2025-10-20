<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4" style="max-width: 400px; width: 100%;">
        <h3 class="text-center mb-4">Đăng nhập</h3>

        <%
            String alert = (String) request.getAttribute("alert");
            if (alert != null) {
        %>
            <div class="alert alert-danger text-center">
                <%= alert %>
            </div>
        <%
            }
        %>

        <form action="<%= request.getContextPath() %>/login" method="post">
            <div class="mb-3">
                <label class="form-label">Tên đăng nhập</label>
                <input type="text" name="username" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Mật khẩu</label>
                <input type="password" name="password" class="form-control" required>
            </div>

            <div class="form-check mb-3">
                <input type="checkbox" name="remember" class="form-check-input" id="remember">
                <label class="form-check-label" for="remember">Ghi nhớ đăng nhập</label>
            </div>

            <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
        </form>

        <p class="text-center mt-3 mb-0">
            Chưa có tài khoản?
            <a href="<%= request.getContextPath() %>/register">Đăng ký</a>
        </p>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
