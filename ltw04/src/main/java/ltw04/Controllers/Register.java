package ltw04.Controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ltw04.Models.User;
import ltw04.service.UserService;
import ltw04.service.lmpl.UserServicelmpl;

@WebServlet(urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserServicelmpl();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Chuyển hướng tới trang đăng ký
        req.getRequestDispatcher("/view/Register.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String fullname = req.getParameter("fullname");

        User user = new User();
        user.setUserName(username);
        user.setPassWord(password);
        user.setEmail(email);
        user.setFullName(fullname);

        // You need to add a method to save the user in UserService
        userService.register(user);

        resp.sendRedirect(req.getContextPath() + "/Login"); // Redirect to login page after registration
    }
}
