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
			req.setAttribute("error", "Vui lòng đăng nhập để mua hàng!");
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}

		int pid = Integer.parseInt(req.getParameter("pid"));
		int quantity = 1;

		cartDAO.addToCart(acc.getUid(), pid, quantity);

		resp.sendRedirect("cart");
	}
}