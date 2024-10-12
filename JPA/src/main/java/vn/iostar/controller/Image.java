package vn.iostar.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.utils.Constant;
@WebServlet("/image")
public class Image extends HttpServlet {
	    /**
		 * 
		 */
		private static final long serialVersionUID = -2400132680730582103L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String fname = request.getParameter("fname");
	        String filePath = getServletContext().getRealPath("/") + Constant.DIR + File.separator + fname;

	        File file = new File(filePath);
	        if (file.exists()) {
	            FileInputStream fis = new FileInputStream(file);
	            response.setContentType("image/jpeg");
	            byte[] buffer = new byte[1024];
	            int bytesRead;
	            while ((bytesRead = fis.read(buffer)) != -1) {
	                response.getOutputStream().write(buffer, 0, bytesRead);
	            }
	            fis.close();
	        }
	    }
}
