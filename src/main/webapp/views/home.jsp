<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>  <!-- THÊM DÒNG NÀY ĐỂ ĐỊNH DẠNG SỐ -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shop Thú Nhồi Bông Dễ Thương</title>
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

        <c:if test="${empty listP}">
            <div class="alert alert-info text-center">
                <h4>Chưa có sản phẩm nào!</h4>
            </div>
        </c:if>

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
                        <p class="text-danger fs-4 fw-bold mb-3">
                            <fmt:formatNumber value="${p.price}" pattern="#,##0"/>₫
                        </p>
                        <div class="d-grid gap-2">
                            <a href="${pageContext.request.contextPath}/buy-now?pid=${p.pid}&quantity=1" 
                               class="btn btn-success btn-lg">
                                <i class="fas fa-bolt me-2"></i> Mua ngay
                            </a>
                            <a href="${pageContext.request.contextPath}/add-to-cart?pid=${p.pid}&quantity=1" 
                               class="btn btn-pink btn-lg">
                                <i class="fas fa-cart-plus me-2"></i> Thêm vào giỏ hàng
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

    <jsp:include page="footer.jsp"/>

    <!-- THÊM DÒNG NÀY ĐỂ BOOTSTRAP 5 HOẠT ĐỘNG (dropdown, toggler) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>