package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;
import beans.*;
import dao.*;

@WebServlet("/checkout")
public class CheckoutController extends HttpServlet {
    private CartDAO cartDAO = new CartDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account acc = (Account) session.getAttribute("acc");

        if (acc == null) {
            req.setAttribute("error", "Bạn cần đăng nhập để thanh toán!");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }

        Cart cart = cartDAO.getActiveCart(acc.getUid());
        if (cart == null || cartDAO.getCartItems(cart.getCartID()).isEmpty()) {
            resp.sendRedirect("cart");
            return;
        }

        List<CartItem> items = cartDAO.getCartItems(cart.getCartID());
        double total = items.stream().mapToDouble(CartItem::getTotal).sum();

        req.setAttribute("cartItems", items);
        req.setAttribute("total", total);
        req.setAttribute("acc", acc); // hiện thông tin người nhận

        req.getRequestDispatcher("/views/checkout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account acc = (Account) session.getAttribute("acc");

        if (acc != null) {
            Cart cart = cartDAO.getActiveCart(acc.getUid());
            if (cart != null) {
                cartDAO.completeOrder(cart.getCartID());
            }
            session.removeAttribute("cartSize");
        }

        session.setAttribute("toastSuccess", "Thanh toán thành công! Cảm ơn bạn đã mua hàng ❤️");
        resp.sendRedirect("home");
    }
}