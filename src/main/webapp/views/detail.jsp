<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${p.name} - Thú Nhồi Bông</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="menu.jsp"></jsp:include>

    <div class="container mt-4">
        <div class="row">
            <div class="col-sm-3">
                <jsp:include page="menu.jsp"></jsp:include>
            </div>
            <div class="col-sm-9">
                <div class="card">
                    <div class="row no-gutters">
                        <div class="col-md-5">
                            <img src="${pageContext.request.contextPath}/images/toys/${p.image}" class="card-img" style="object-fit: cover; height: 100%;">
                        </div>
                        <div class="col-md-7">
                            <div class="card-body">
                                <h2 class="card-title text-pink">${p.name}</h2>
                                <h3 class="text-danger">${p.price}₫</h3>
                                <p class="lead">${p.description}</p>
                                <hr>
                                <div class="form-group">
                                    <label>Số lượng:</label>
                                    <select class="form-control w-25 d-inline">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                    </select>
                                </div>
                                <a href="#" class="btn btn-pink btn-lg">Mua ngay</a>
                                <a href="#" class="btn btn-outline-pink btn-lg">Thêm vào giỏ</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

<style>
    .btn-outline-pink { border: 2px solid #ff6b9d; color: #ff6b9d; }
    .btn-outline-pink:hover { background: #ff6b9d; color: white; }
</style>