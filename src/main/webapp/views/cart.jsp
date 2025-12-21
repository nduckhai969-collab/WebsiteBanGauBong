<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giỏ hàng - Thú Nhồi Bông</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="menu.jsp"/>

    <div class="container mt-5">
        <h2 class="text-center text-pink mb-4">Giỏ hàng của bạn</h2>

        <c:if test="${empty cartItems}">
            <div class="alert alert-info text-center p-5">
                <h4>Giỏ hàng trống!</h4>
                <a href="${pageContext.request.contextPath}/home" class="btn btn-pink">Tiếp tục mua sắm</a>
            </div>
        </c:if>

        <c:if test="${not empty cartItems}">
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thead class="thead-light">
                        <tr>
                            <th width="40%">Sản phẩm</th>
                            <th width="20%">Đơn giá</th>
                            <th width="20%">Số lượng</th>
                            <th width="20%">Thành tiền / Xóa</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${cartItems}" var="o">
                            <tr>
                                <td>
                                    <div class="media align-items-center">
                                        <img src="${pageContext.request.contextPath}/images/toys/${o.product.image}" 
                                             width="80" class="mr-3 rounded" alt="${o.product.name}">
                                        <div class="media-body">
                                            <h5 class="mt-0">${o.product.name}</h5>
                                            <small class="text-muted">${o.product.title}</small>
                                        </div>
                                    </div>
                                </td>
                                <td class="align-middle text-center">
                                    <strong><fmt:formatNumber value="${o.price}" pattern="#,##0"/>₫</strong>
                                </td>
                                <td class="align-middle text-center">
                                    <div class="d-flex justify-content-center align-items-center">
                                        <a href="${pageContext.request.contextPath}/update-cart?id=${o.id}&action=dec" 
                                           class="btn btn-sm btn-outline-secondary">-</a>
                                        <strong class="mx-3">${o.quantity}</strong>
                                        <a href="${pageContext.request.contextPath}/update-cart?id=${o.id}&action=inc" 
                                           class="btn btn-sm btn-outline-secondary">+</a>
                                    </div>
                                </td>
                                <td class="align-middle text-center">
                                    <strong class="text-danger"><fmt:formatNumber value="${o.quantity * o.price}" pattern="#,##0"/>₫</strong>
                                    <br>
                                    <a href="${pageContext.request.contextPath}/remove-from-cart?id=${o.id}" 
                                       class="text-danger mt-2 d-block" onclick="return confirm('Xóa sản phẩm này khỏi giỏ?')">
                                        <i class="fa fa-trash fa-lg"></i> Xóa
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="row mt-4">
                <div class="col-lg-6">
                    <div class="card shadow">
                        <div class="card-body">
                            <h5><i class="fas fa-gift me-2"></i> Voucher</h5>
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Nhập mã giảm giá">
                                <div class="input-group-append">
                                    <button class="btn btn-pink">Áp dụng</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="card shadow">
                        <div class="card-body">
                            <h5><i class="fas fa-calculator me-2"></i> Thành tiền</h5>
                            <ul class="list-unstyled">
                                <li class="d-flex justify-content-between"><span>Tổng hàng:</span> 
                                    <strong><fmt:formatNumber value="${total}" pattern="#,##0"/>₫</strong></li>
                                <li class="d-flex justify-content-between"><span>Phí ship:</span> <strong>Miễn phí</strong></li>
                                <li class="d-flex justify-content-between border-top pt-3">
                                    <strong class="fs-4">Tổng thanh toán:</strong>
                                    <h4 class="text-pink"><fmt:formatNumber value="${total}" pattern="#,##0"/>₫</h4>
                                </li>
                            </ul>
                            <a href="${pageContext.request.contextPath}/checkout" class="btn btn-success btn-lg w-100 mt-3">
                                <i class="fas fa-credit-card me-2"></i> Thanh toán ngay
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </div>

    <jsp:include page="footer.jsp"/>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>