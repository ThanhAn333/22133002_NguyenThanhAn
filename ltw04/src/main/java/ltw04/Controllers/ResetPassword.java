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

@WebServlet(urlPatterns = {"/ResetPassword"})
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService = new UserServicelmpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String newPassword = req.getParameter("password");

        User user = userService.findByEmail(email);
        if (user != null) {
            user.setPassWord(newPassword);
            userService.update(user);
            req.setAttribute("message", "Password reset successfully.");
        } else {
            req.setAttribute("error", "Error resetting password.");
        }
        req.getRequestDispatcher("/view/ResetPassword.jsp").forward(req, resp);
    }
}
