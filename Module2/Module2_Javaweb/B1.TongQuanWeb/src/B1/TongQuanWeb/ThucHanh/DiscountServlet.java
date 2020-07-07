package B1.TongQuanWeb.ThucHanh;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet ",urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float discount_percent = Float.parseFloat(request.getParameter("discount_percent"));
        double money = price * discount_percent * 0.01;

        PrintWriter writer = response.getWriter();
        ((PrintWriter) writer).println("<html>");
        writer.println("<h1>description: " + description+ "</h1>");
        writer.println("<h1>price: " + price+ "</h1>");
        writer.println("<h1>discount_percent: " + discount_percent+ "</h1>");
        writer.println("<h1>Discount Amount: " + money+ "</h1>");
        writer.println("<h1>Discount Price: " + (price-money)+ "</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
