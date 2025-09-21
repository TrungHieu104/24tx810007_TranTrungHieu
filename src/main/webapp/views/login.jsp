<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
</head>
<body>
    <h2>Đăng nhập</h2>


    <%
        String alert = (String) request.getAttribute("alert");
        if (alert != null) {
    %>
        <p style="color:red"><%= alert %></p>
    <%
        }
    %>

    <form action="<%= request.getContextPath() %>/login" method="post">
        <label>Tên đăng nhập:</label>
        <input type="text" name="username" required /><br/>

        <label>Mật khẩu:</label>
        <input type="password" name="password" required /><br/>

        <label><input type="checkbox" name="remember"/> Ghi nhớ đăng nhập</label><br/>

        <button type="submit">Đăng nhập</button>
    </form>

    <p>Chưa có tài khoản?
        <a href="<%= request.getContextPath() %>/register">Đăng ký</a>
    </p>
</body>
</html>
