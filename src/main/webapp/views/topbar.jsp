<%@ page contentType="text/html; charset=UTF-8" %>
<%
    Object account = session.getAttribute("account");
    if (account == null) {
%>
    <a href="<%= request.getContextPath() %>/login">Đăng nhập</a> |
    <a href="<%= request.getContextPath() %>/register">Đăng ký</a>
<%
    } else {
%>
    Xin chào, <%= ((vn.iotstar.model.User) account).getFullName() %> |
    <a href="<%= request.getContextPath() %>/logout">Đăng xuất</a>
<%
    }
%>
