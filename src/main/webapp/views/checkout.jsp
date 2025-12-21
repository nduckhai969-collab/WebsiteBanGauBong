<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thanh toán - Shop Thú Nhồi Bông</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="menu.jsp"/>

    <div class="container mt-5 mb-5">
        <h2 class="text-center text-pink mb-5">XÁC NHẬN THANH TOÁN</h2>

        <div class="row">
            <!-- Thông tin giao hàng -->
            <div class="col-lg-6">
                <div class="card shadow mb-4">
                    <div class="card-header bg-pink text-white">
                        <h5><i class="fas fa-user me-2"></i> Thông tin người nhận</h5>
                    </div>
                    <div class="card-body">
                        <p><strong>Họ tên:</strong> ${acc.fullName}</p>
                        <p><strong>Email:</strong> ${acc.email}</p>
                        <p><strong>Số điện thoại:</strong> ${acc.phone}</p>
                        <p><strong>Địa chỉ:</strong> Chưa cập nhật </p>
                    </div>
                </div>

                <div class="card shadow">
                    <div class="card-header bg-pink text-white">
                        <h5><i class="fas fa-truck me-2"></i> Phương thức giao hàng</h5>
                    </div>
                    <div class="card-body">
                        <p>Giao hàng tiêu chuẩn - Miễn phí toàn quốc</p>
                    </div>
                </div>
            </div>

            <!-- Danh sách sản phẩm + tổng tiền -->
            <div class="col-lg-6">
                <div class="card shadow">
                    <div class="card-header bg-pink text-white">
                        <h5><i class="fas fa-list me-2"></i> Đơn hàng của bạn (${cartItems.size()} sản phẩm)</h5>
                    </div>
                    <div class="card-body">
                        <table class="table">
                            <tbody>
                                <c:forEach items="${cartItems}" var="item">
                                    <tr>
                                        <td>
                                            <img src="${pageContext.request.contextPath}/images/toys/${item.product.image}" width="60" class="rounded me-3">
                                            ${item.product.name} x ${item.quantity}
                                        </td>
                                        <td class="text-end">
                                            <fmt:formatNumber value="${item.getTotal()}" pattern="#,##0"/>₫
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <hr>
                        <h4 class="text-end text-pink">
                            Tổng thanh toán: <strong><fmt:formatNumber value="${total}" pattern="#,##0"/>₫</strong>
                        </h4>

                        <form action="checkout" method="post">
                            <button type="submit" class="btn btn-success btn-lg w-100 mt-3">
                                <i class="fas fa-credit-card me-2"></i> THANH TOÁN NGAY
                            </button>
                        </form>

                        <p class="text-center mt-3 text-muted">
                            <small>Chúng tôi hỗ trợ thanh toán Momo, ZaloPay, chuyển khoản ngân hàng</small>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>