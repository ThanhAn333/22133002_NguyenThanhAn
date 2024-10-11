package vn.iostar.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static vn.iostar.utils.Constant.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iostar.dao.ICategoryDao;
import vn.iostar.dao.impl.CategoryDaoImpl;
import vn.iostar.models.CategoryModel;
import vn.iostar.services.ICategoryService;
import vn.iostar.services.impl.CategoryServiceImpl;
@MultipartConfig(fileSizeThreshold = 1024*1024, maxFileSize = 1024*1024,maxRequestSize = 1024*1024*5*5)
@WebServlet(urlPatterns = {"/admin/categories", "/admin/category/add", "/admin/category/insert", "/admin/category/update","/admin/category/edit", "/admin/category/delete", "/admin/category/search"})
public class CategoryController extends HttpServlet {

	
	private static final long serialVersionUID = 72558528774651441L;
	
	public ICategoryService cateService = new CategoryServiceImpl();
	
	public ICategoryDao cateDao = new CategoryDaoImpl();
	//public ICategoryService cateService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		if(url.contains("categories")) {
			List<CategoryModel> list = cateDao.findAll();
			
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		}else if(url.contains("add")) {
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		}else if(url.contains("edit")) {
			int id =Integer.parseInt(req.getParameter("id"));
			CategoryModel catgory = cateService.findById(id);
			
			req.setAttribute("cate",catgory);
			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		
		if(url.contains("insert")) {
			String categoryname = req.getParameter("categoryname");
			String status = req.getParameter("status");
			int statuss = Integer.parseInt(status);
			
CategoryModel category = new CategoryModel();
			
			String fname = "";
			String upLoad = DIR;
			File upLoadDir = new File(upLoad);
			if(!upLoadDir.exists()) {
				upLoadDir.mkdir();
			}
			try {
				Part part = req.getPart("images");
				if(part.getSize()>0) {
					String filename  = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index+1);
					fname = System.currentTimeMillis() + "." +ext;
					
					part.write(upLoad + "/" + filename);
					
					category.setImages(fname);
					
				}else {	
					category.setImages("avatar.png");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			
			category.setCategoryname(categoryname);
			category.setStatus(statuss);
			category.setImages(fname);
			
			cateService.insert(category);
			
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
			
		}else if(url.contains("update")) {
			int categoryid = Integer.parseInt(req.getParameter("categoryid"));
			String categoryname = req.getParameter("categoryname");
			String status = req.getParameter("status");
			int statuss = Integer.parseInt(status);
			
			CategoryModel category = new CategoryModel();
			
			String fname = "";
			String upLoad = DIR;
			File upLoadDir = new File(upLoad);
			if(!upLoadDir.exists()) {
				upLoadDir.mkdir();
			}
			try {
				Part part = req.getPart("images");
				if(part.getSize()>0) {
					String filename  = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index+1);
					fname = System.currentTimeMillis() + "." +ext;
					
					part.write(upLoad + "/" + filename);
					
					category.setImages(fname);
					
				}else {
					category.setImages("avatar.png");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
				
		
			
			category.setCategoryid(categoryid);
			category.setCategoryname(categoryname);
			category.setStatus(statuss);
			category.setImages(fname);
			
			cateService.update(category);
			
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
	}
}
