package vn.iostar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.services.IUserService;
import vn.iostar.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/reset_password"})
public class ResetPasswordController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2412868094575767230L;
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     
	        req.getRequestDispatcher("/views/reset_password.jsp").forward(req, resp);
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String password = req.getParameter("password");
	        String confirmPassword = req.getParameter("confirmPassword");
	        String alertMsg = "";

	      
	        if (!password.equals(confirmPassword)) {
	            alertMsg = "Mật khẩu và xác nhận mật khẩu không khớp!";
	            req.setAttribute("alert", alertMsg);
	            req.getRequestDispatcher("/views/reset_password.jsp").forward(req, resp);
	            return;
	        }

	       
	        IUserService service = new UserServiceImpl();

	        
	        String email = (String) req.getSession().getAttribute("email");
	        boolean isSuccess = service.updatePassword(email, password);
			if (isSuccess) {
				req.getRequestDispatcher("/views/reset_sucess.jsp").forward(req, resp);
				

			} else {
				 alertMsg = "Đã xảy ra lỗi khi cập nhật mật khẩu!";
		            req.setAttribute("alert", alertMsg);
		            req.getRequestDispatcher("/views/reset_password.jsp").forward(req, resp);
			}
	    }

}
