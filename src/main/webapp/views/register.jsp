<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4" style="max-width: 450px; width: 100%;">
        <h3 class="text-center mb-4">Tạo tài khoản mới</h3>

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

        <form action="register" method="post">
            <div class="mb-3">
                <label class="form-label">Họ tên</label>
                <input type="text" name="fullname" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" name="email" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Tài khoản</label>
                <input type="text" name="username" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Mật khẩu</label>
                <input type="password" name="password" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Số điện thoại</label>
                <input type="text" name="phone" class="form-control">
            </div>

            <button type="submit" class="btn btn-success w-100">Đăng ký</button>
        </form>

        <p class="text-center mt-3 mb-0">
            Đã có tài khoản?
            <a href="login">Đăng nhập</a>
        </p>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
