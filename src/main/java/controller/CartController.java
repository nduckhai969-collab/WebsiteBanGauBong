package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;
import beans.*;
import dao.*;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    private CartDAO cartDAO = new CartDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account acc = (Account) session.getAttribute("acc");

        if (acc == null) {
            // Lưu trang gốc để quay lại sau khi login
            session.setAttribute("backUrl", req.getRequestURI());

            req.setAttribute("error", "Bạn cần đăng nhập để xem giỏ hàng!");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }

        Cart cart = cartDAO.getActiveCart(acc.getUid());

        List<CartItem> list = new ArrayList<>();
        double total = 0;

        if (cart != null) {
            list = cartDAO.getCartItems(cart.getCartID());
            total = list.stream().mapToDouble(CartItem::getTotal).sum();
        }
        req.setAttribute("cartItems", list);
        req.setAttribute("total", total);

        req.getRequestDispatcher("/views/cart.jsp").forward(req, resp);
    }
}