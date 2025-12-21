package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import beans.Account;
import dao.CartDAO;

@WebServlet("/add-to-cart")
public class AddToCartController extends HttpServlet {
	private CartDAO cartDAO = new CartDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Account acc = (Account) session.getAttribute("acc");

		if (acc == null) {
			session.setAttribute("backUrl", req.getHeader("Referer"));
			req.setAttribute("error", "Bạn cần đăng nhập để thêm vào giỏ hàng!");
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}

		int pid = Integer.parseInt(req.getParameter("pid"));
		int quantity = req.getParameter("quantity") != null ? Integer.parseInt(req.getParameter("quantity")) : 1;

		cartDAO.addToCart(acc.getUid(), pid, quantity);
		int cartID = cartDAO.getActiveCart(acc.getUid()).getCartID();
		int cartSize = cartDAO.getCartItems(cartID).size();
		session.setAttribute("cartSize", cartSize);

		session.setAttribute("toastSuccess", "Đã thêm sản phẩm vào giỏ hàng!");


		String referer = req.getHeader("Referer");
		resp.sendRedirect(referer != null ? referer : "home");
	}
}