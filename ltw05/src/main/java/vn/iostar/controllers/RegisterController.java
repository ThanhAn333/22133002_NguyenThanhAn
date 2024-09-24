package vn.iostar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.services.IUserService;
import vn.iostar.services.impl.UserServiceImpl;
<<<<<<< HEAD
import vn.iostar.utils.Constant;
=======
>>>>>>> 33b0958cd7eea6bca183618b81c6e2cc4d85b5be

@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 6293469490480891265L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			// If the user is already logged in, redirect them
			resp.sendRedirect(req.getContextPath() + "/home");
			return;
		}

		// Forward to the register.jsp if no session is active
		req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");

		IUserService service = new UserServiceImpl();
		String alertMsg = "";

		// Check if the email or username already exists
		if (service.checkExistEmail(email)) {
			alertMsg = "Email đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
			return;
		}

		if (service.checkExistUsername(username)) {
			alertMsg = "Tài khoản đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
			return;
		}

		// Proceed with registration if checks pass
		boolean isSuccess = service.register(username, password, fullname, email, phone);
		if (isSuccess) {
			// Registration succeeded, redirect to login
			//resp.sendRedirect(req.getContextPath() + "/views/register_sucess");
			req.getRequestDispatcher("/views/register_sucess.jsp").forward(req, resp);
			

		} else {
			// Registration failed due to a system error
			alertMsg = "System error! Please try again later.";
			req.setAttribute("alert", alertMsg);
<<<<<<< HEAD
			req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
=======
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
>>>>>>> 33b0958cd7eea6bca183618b81c6e2cc4d85b5be
		}
	}
}
