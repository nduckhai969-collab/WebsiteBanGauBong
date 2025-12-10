package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import dao.ProductDAO;
import beans.Product;

@WebServlet("/home")
public class HomeController extends HttpServlet {
    
    private ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // LẤY DANH SÁCH SẢN PHẨM TỪ DB
        List<Product> listP = productDAO.getAllProducts();
        request.setAttribute("listP", listP);
        // Forward đến home.jsp
        request.getRequestDispatcher("/views/home.jsp").forward(request, response);
    }
}