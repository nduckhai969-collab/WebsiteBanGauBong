<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-md-4">
				<div class="card shadow">
					<div class="card-body p-5">

						<c:if test="${not empty error}">
							<div
								class="alert alert-danger alert-dismissible fade show text-center"
								role="alert">
								<i class="fas fa-exclamation-triangle me-2"></i> <strong>${error}</strong>
								<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
							</div>
						</c:if>

						<h3 class="text-center mb-4">Đăng nhập</h3>
						<form action="login" method="post">
							<div class="mb-3">
								<input name="user" type="text" class="form-control"
									placeholder="Tên đăng nhập" required>
							</div>
							<div class="mb-3">
								<input name="pass" type="password" class="form-control"
									placeholder="Mật khẩu" required>
							</div>
							<button type="submit" class="btn btn-pink w-100">Đăng
								nhập</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>