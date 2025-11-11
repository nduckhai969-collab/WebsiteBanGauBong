<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shop Thú Nhồi Bông</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="menu.jsp"/>
    
    <div class="container mt-4">
        <div class="jumbotron text-center mb-5">
            <h1>Shop Thú Nhồi Bông Dễ Thương</h1>
            <p class="lead">Ôm ấp yêu thương – Mỗi ngày một niềm vui!</p>
        </div>

        <div class="row">
            <c:forEach items="${listP}" var="p">
                <div class="col-md-6 col-lg-4 mb-4">
                    <div class="card hover-card">
                        <img src="${pageContext.request.contextPath}/images/toys/${p.image}" 
                             class="card-img-top" alt="${p.name}">
                        <div class="card-body">
                            <h5 class="card-title"><a href="#">${p.name}</a></h5>
                            <p class="text-muted">${p.title}</p>
                            <p class="text-danger">${p.price}₫</p>
                            <a href="#" class="btn btn-pink">Thêm vào giỏ</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>
</body>
</html>