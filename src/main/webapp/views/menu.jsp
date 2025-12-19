<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet">

<nav class="navbar navbar-expand-lg navbar-dark">
	<div class="container">
		<a class="navbar-brand fw-bold"
			href="${pageContext.request.contextPath}/home"> <i
			class="fas fa-heart text-danger me-2"></i> Thú Nhồi Bông
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav me-auto">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/home">Trang chủ</a></li>

				<!-- MỤC SẢN PHẨM — DROPDOWN CHIA LOẠI + KÍCH CỠ -->
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown"> Sản phẩm </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item"
							href="${pageContext.request.contextPath}/size?size=small">Kích
								cỡ nhỏ</a></li>
						<li><a class="dropdown-item"
							href="${pageContext.request.contextPath}/size?size=medium">Kích
								cỡ vừa</a></li>
						<li><a class="dropdown-item"
							href="${pageContext.request.contextPath}/size?size=large">Kích
								cỡ to</a></li>
						<li><a class="dropdown-item"
							href="${pageContext.request.contextPath}/size?size=giant">Khổng
								lồ</a></li>
					</ul></li>

				<!-- MỤC KHUYẾN MÃI -->
				<li class="nav-item"><a class="nav-link text-warning fw-bold"
					href="${pageContext.request.contextPath}/promotion"> <i
						class="fas fa-tag me-1"></i> Khuyến mãi
				</a></li>

				<!-- MỤC LIÊN HỆ -->
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/contact">Liên hệ</a></li>
			</ul>

			<!-- TÌM KIẾM + GIỎ HÀNG -->
			<form class="d-flex me-3"
				action="${pageContext.request.contextPath}/search" method="get">
				<input class="form-control me-2" type="search" name="txt"
					placeholder="Tìm thú bông...">
				<button class="btn btn-light" type="submit">
					<i class="fas fa-search"></i>
				</button>
			</form>

			<a href="${pageContext.request.contextPath}/cart"
				class="btn btn-warning position-relative"> <i
				class="fas fa-shopping-cart"></i> <span
				class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
					${sessionScope.cartItems != null ? sessionScope.cartItems.size() : 0}
			</span>
			</a>
		</div>
	</div>
</nav>

<!-- BẮT BUỘC THÊM JS BOOTSTRAP 5 -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>