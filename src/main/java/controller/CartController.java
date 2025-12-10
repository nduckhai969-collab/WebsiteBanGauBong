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
            resp.sendRedirect("login.jsp");
            return;
        }

        Cart cart = cartDAO.getActiveCart(acc.getUid());
        if (cart == null) {
            req.setAttribute("cartItems", new ArrayList<>());
            req.setAttribute("total", 0);
        } else {
            List<CartItem> list = cartDAO.getCartItems(cart.getCartID());
            double total = list.stream().mapToDouble(CartItem::getTotal).sum();
            req.setAttribute("cartItems", list);
            req.setAttribute("total", total);
        }

        req.getRequestDispatcher("/views/cart.jsp").forward(req, resp);
    }
}