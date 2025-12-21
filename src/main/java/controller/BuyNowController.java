package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import beans.*;
import dao.*;

@WebServlet("/buy-now")
public class BuyNowController extends HttpServlet {
	private CartDAO cartDAO = new CartDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Account acc = (Account) session.getAttribute("acc");

		if (acc == null) {
			req.setAttribute("error", "Bạn cần đăng nhập để mua ngay!");
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}

		int pid = Integer.parseInt(req.getParameter("pid"));
		int quantity = 1;

		Cart cart = cartDAO.getActiveCart(acc.getUid());
		if (cart == null) {
			cartDAO.createCart(acc.getUid());
			cart = cartDAO.getActiveCart(acc.getUid());
		}

		cartDAO.addToCart(acc.getUid(), pid, quantity);

		int cartSize = cartDAO.getCartItems(cart.getCartID()).size();
		session.setAttribute("cartSize", cartSize);

		session.setAttribute("toastSuccess", "Đã thêm vào đơn hàng, chuyển đến thanh toán!");

		resp.sendRedirect("checkout");
	}
}