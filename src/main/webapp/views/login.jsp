<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập - Thú Nhồi Bông</title>
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-5">
            <div class="card shadow">
                <div class="card-body p-5">
                    <h3 class="text-center text-pink mb-4">Đăng nhập</h3>
                    <form action="${pageContext.request.contextPath}/login" method="post">
                        <input name="user" type="text" class="form-control mb-3" placeholder="Tên đăng nhập" required>
                        <input name="pass" type="password" class="form-control mb-3" placeholder="Mật khẩu" required>
                        <div class="form-check mb-3">
                            <input name="remember" value="1" type="checkbox" class="form-check-input">
                            <label class="form-check-label">Ghi nhớ</label>
                        </div>
                        <button type="submit" class="btn btn-pink btn-block">Đăng nhập</button>
                    </form>
                    <hr>
                    <button class="btn btn-outline-pink btn-block" id="btn-signup">Đăng ký tài khoản mới</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>