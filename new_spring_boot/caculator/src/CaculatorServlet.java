import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CaculatorServlet" ,urlPatterns = "/calculator")
public class CaculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float s1 = Float.parseFloat(request.getParameter("operator1"));
        float s2 = Float.parseFloat(request.getParameter("operator3"));
        char op = request.getParameter("operator2").charAt(0);
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<h1> Result : </h1>");
        float result = Caculate.caculate(s1, s2, op);
        try {
            printWriter.println(s1 + " " + op + " " + s2 + " = " + result);
        } catch (Exception e) {
            printWriter.println("" + e);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
