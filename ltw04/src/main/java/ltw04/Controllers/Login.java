package ltw04.Controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import ltw04.Models.User;
import ltw04.service.UserService;
import ltw04.service.lmpl.UserServicelmpl;

@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    private static final long serialVersionUID = -7893959780831864182L;
    private UserService userService = new UserServicelmpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/Login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 String username = req.getParameter("username");
         String password = req.getParameter("password");

         User user = userService.login(username, password);

         if (user != null) {
             HttpSession session = req.getSession();
             session.setAttribute("user", user);
             resp.sendRedirect(req.getContextPath() + "/view/HomePage.jsp"); // Redirect to home page after login
         } else {
             req.setAttribute("error", "Invalid username or password.");
             req.getRequestDispatcher("/view/Login.jsp").forward(req, resp);
         }
    }
}