<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="vn.iotstar.model.User" %>
<%
    User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
</head>
<body>
    <h2>Xin chào, <%= (user != null ? user.getFullName() : "Khách") %>!</h2>
    <p>Chào mừng bạn đến với hệ thống.</p>
    <p><a href="<%= request.getContextPath() %>/logout">Đăng xuất</a></p>
</body>
</html>
