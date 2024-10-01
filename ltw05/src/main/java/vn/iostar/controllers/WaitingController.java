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
				//req.getRequestDispatcher("/common/user/home.jsp").forward(req, resp);
				resp.sendRedirect(req.getContextPath() + "/user/home");
			} else if (u.getRoleid() == 2) {
				//req.getRequestDispatcher("/common/admin/home.jsp").forward(req, resp);
				resp.sendRedirect(req.getContextPath() + "/admin/home");
			} else {
				resp.sendRedirect(req.getContextPath() + "/home");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

}
