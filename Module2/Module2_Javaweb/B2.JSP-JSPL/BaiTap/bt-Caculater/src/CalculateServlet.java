import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CaculateServlet", urlPatterns = "/calculate")
public class CalculateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float s1 = Float.parseFloat(request.getParameter("first-operand"));
        float s2 = Float.parseFloat(request.getParameter("second-operand"));
        char op = request.getParameter("operator").charAt(0);
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result:</h1>");
        try {
            float result = Caculate.caculate(s1, s2, op);
            writer.println(s1 + " " + op + " " + s2 + " = " + result);
        } catch (Exception ex) {
            writer.println("Error: " + ex.getMessage());
        }
        writer.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
