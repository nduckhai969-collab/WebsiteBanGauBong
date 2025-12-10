package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import dao.AccountDAO;
import beans.Account;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private AccountDAO accountDAO = new AccountDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        Account acc = accountDAO.login(user, pass);

        if (acc != null) {
            // TẠO SESSION
            HttpSession session = request.getSession();
            session.setAttribute("acc", acc);
            session.setMaxInactiveInterval(60*60*24); // 1 ngày

            // Nếu là admin → qua trang quản trị
            if (acc.isIsAdmin()) {
                response.sendRedirect("admin");
            } else {
                response.sendRedirect("home");
            }
        } else {
            request.setAttribute("error", "Sai tài khoản hoặc mật khẩu!");
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        }
    }
}