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

@WebServlet(urlPatterns = {"/ForgetPassword"})
public class ForgetPassword extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    private UserService userService = new UserServicelmpl();

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        req.getRequestDispatcher("/view/ForgetPassword.jsp").forward(req, resp);
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String email = req.getParameter("email");
	        User user = userService.findByEmail(email);
	        if (user != null) {
	            req.setAttribute("user", user);
	            req.getRequestDispatcher("/view/ResetPassword.jsp").forward(req, resp);
	        } else {
	            req.setAttribute("error", "No account found with that email address.");
	            req.getRequestDispatcher("/view/ForgetPassword.jsp").forward(req, resp);
	        }
	    }
}
