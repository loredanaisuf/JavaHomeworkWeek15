package ro.siit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/myAge"})
public class AgeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("display","none");
        req.getRequestDispatcher("/page/myAge.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String birthday = req.getParameter("birthday");
        long nrOfDays = Service.getNrOfDays(birthday);
        req.setAttribute("display","block");
        req.setAttribute("message", name + ", your age in days is: " + nrOfDays);
        req.getRequestDispatcher("/page/myAge.jsp").forward(req,resp);

    }
}
