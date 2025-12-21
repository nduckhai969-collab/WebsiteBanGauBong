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
		    HttpSession session = request.getSession();
		    session.setAttribute("acc", acc);
		    session.setAttribute("toastSuccess", "Đăng nhập thành công! Chào mừng bạn quay lại ❤️");

		    String backUrl = (String) session.getAttribute("backUrl");
		    if (backUrl != null && !backUrl.contains("login")) {
		        session.removeAttribute("backUrl");
		        response.sendRedirect(backUrl);
		    } else {
		        response.sendRedirect("home");
		    }
		} else {
			request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}
}