package vn.iostar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home", "/user/home", "/admin/home"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = -1739539370302650017L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

        switch (path) {
            case "/user/home":
                req.getRequestDispatcher("/common/user/home.jsp").forward(req, resp);
                break;
            case "/admin/home":
                req.getRequestDispatcher("/common/admin/home.jsp").forward(req, resp);
                break;
            default:
                req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
                break;
        }
	}
}
