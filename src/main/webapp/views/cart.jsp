<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giỏ hàng - Thú Nhồi Bông</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="menu.jsp"></jsp:include>

    <div class="container mt-5">
        <h2 class="text-center text-pink mb-4">Giỏ hàng của bạn</h2>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead class="thead-light">
                    <tr>
                        <th>Sản phẩm</th>
                        <th>Đơn giá</th>
                        <th>Số lượng</th>
                        <th>Xóa</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="o">
                    <tr>
                        <td>
                            <div class="media">
                                <img src="${pageContext.request.contextPath}/images/toys/${o.image}" width="70" class="mr-3 rounded">
                                <div class="media-body">
                                    <h5>${o.name}</h5>
                                </div>
                            </div>
                        </td>
                        <td class="align-middle"><strong>${o.price}₫</strong></td>
                        <td class="align-middle">
                            <button class="btn btn-sm btn-outline-secondary">-</button>
                            <strong class="mx-2">${o.amount}</strong>
                            <button class="btn btn-sm btn-outline-secondary">+</button>
                        </td>
                        <td class="align-middle">
                            <a href="#" class="text-danger"><i class="fa fa-trash"></i></a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="row mt-4">
            <div class="col-lg-6">
                <div class="card">
                    <div class="card-body">
                        <h5>Voucher</h5>
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
                <div class="card">
                    <div class="card-body">
                        <h5>Thành tiền</h5>
                        <ul class="list-unstyled">
                            <li class="d-flex justify-content-between"><span>Tổng hàng:</span> <strong>750.000₫</strong></li>
                            <li class="d-flex justify-content-between"><span>Phí ship:</span> <strong>Miễn phí</strong></li>
                            <li class="d-flex justify-content-between border-top pt-2">
                                <strong>Tổng thanh toán:</strong>
                                <h5 class="text-pink">750.000₫</h5>
                            </li>
                        </ul>
                        <a href="#" class="btn btn-pink btn-lg btn-block">Thanh toán</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>