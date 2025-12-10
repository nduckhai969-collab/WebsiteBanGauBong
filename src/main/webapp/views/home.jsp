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
                             class="card-img-top" alt="${p.name}" style="height: 240px; object-fit: cover;">
                        <div class="card-body d-flex flex-column">
                            <h5 class="card-title">
                                <a href="${pageContext.request.contextPath}/detail?pid=${p.pid}" class="text-dark">
                                    ${p.name}
                                </a>
                            </h5>
                            <p class="text-muted flex-grow-1">${p.title}</p>
                            <div class="mt-auto">
                                <p class="text-danger fs-4 fw-bold mb-3">${p.price}₫</p>
                                <a href="${pageContext.request.contextPath}/add-to-cart?pid=${p.pid}"
                                   class="btn btn-pink w-100">
                                    <i class="fas fa-cart-plus me-2"></i>Thêm vào giỏ
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>
</body>
</html>