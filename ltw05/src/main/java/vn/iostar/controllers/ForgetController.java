package vn.iostar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.services.IUserService;
import vn.iostar.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/forget_password"})
public class ForgetController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/views/forget_password.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String alertMsg = "";

    
        IUserService service = new UserServiceImpl();

       
        if (service.checkExistEmail(email) || service.checkExistPhone(email)) {
			/*
			 * alertMsg = "Yêu cầu khôi phục mật khẩu đã được gửi!";
			 * req.setAttribute("alert", alertMsg);
			 */
        	
        	//resp.sendRedirect(req.getContextPath() + "/reset_password");
        	
        	req.getSession().setAttribute("email", email);  // Lưu email vào session
        	req.getRequestDispatcher("/views/reset_password.jsp").forward(req, resp);
        
        } else {
            alertMsg = "Email hoặc Số Điện Thoại không tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/forget_password.jsp").forward(req, resp);
            return;
        }
  
    }
}

