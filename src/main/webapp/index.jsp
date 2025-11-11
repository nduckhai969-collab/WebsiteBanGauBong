<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Tự động chuyển về trang home
    response.sendRedirect(request.getContextPath() + "/home");
%>