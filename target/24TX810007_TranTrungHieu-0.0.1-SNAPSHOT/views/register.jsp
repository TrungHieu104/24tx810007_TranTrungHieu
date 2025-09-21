<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Đăng ký</title></head>
<body>
<h2>Tạo tài khoản mới</h2>

<%
    String alert = (String) request.getAttribute("alert");
    if (alert != null) {
%>
  <h3 style="color:red"><%= alert %></h3>
<%
    }
%>

<form action="register" method="post">
  <label>Họ tên: <input type="text" name="fullname"></label><br>
  <label>Email: <input type="email" name="email"></label><br>
  <label>Tài khoản: <input type="text" name="username"></label><br>
  <label>Mật khẩu: <input type="password" name="password"></label><br>
  <label>Số điện thoại: <input type="text" name="phone"></label><br>
  <button type="submit">Đăng ký</button>
</form>

<p><a href="login">Đăng nhập</a></p>
</body>
</html>
