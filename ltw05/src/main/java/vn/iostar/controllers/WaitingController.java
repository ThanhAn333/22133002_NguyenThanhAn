package vn.iostar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.models.UserModel;

@WebServlet(urlPatterns = { "/waiting" })
public class WaitingController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6902621649083544855L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			UserModel u = (UserModel) session.getAttribute("account");
			req.setAttribute("username", u.getUsername());
			if (u.getRoleid() == 1) {
<<<<<<< HEAD
				req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
=======
				resp.sendRedirect(req.getContextPath() + "/user/home");
>>>>>>> 33b0958cd7eea6bca183618b81c6e2cc4d85b5be
			} else if (u.getRoleid() == 2) {
				resp.sendRedirect(req.getContextPath() + "/admin/home");
			} else {
				resp.sendRedirect(req.getContextPath() + "/home");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

}
