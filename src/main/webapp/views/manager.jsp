<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý - Thú Nhồi Bông</title>
    <link href="${pageContext.request.contextPath}/css/manager.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2 class="my-4 text-pink">Quản lý thú nhồi bông</h2>
    <a href="#addModal" class="btn btn-success mb-3" data-toggle="modal">
        <i class="material-icons">&#xE147;</i> Thêm thú mới
    </a>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên</th>
                <th>Ảnh</th>
                <th>Giá</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listP}" var="o">
            <tr>
                <td>${o.id}</td>
                <td>${o.name}</td>
                <td><img src="${pageContext.request.contextPath}/images/toys/${o.image}" width="80"></td>
                <td>${o.price}₫</td>
                <td>
                    <a href="#" class="text-warning"><i class="material-icons">&#xE254;</i></a>
                    <a href="#" class="text-danger"><i class="material-icons">&#xE872;</i></a>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>