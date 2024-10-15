package vn.iostar.controller.admin;

import static vn.iostar.utils.Constant.DIR;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iostar.dao.IVideoDao;
import vn.iostar.dao.impl.VideoDaoImpl;
import vn.iostar.entity.Video;
import vn.iostar.service.IVideoService;
import vn.iostar.service.impl.VideoServiceImpl;

@WebServlet(urlPatterns = { "/admin/videos", "/admin/video/add", "/admin/video/insert", "/admin/video/update",
		"/admin/video/remove", "/admin/video/edit", "/admin/video/delete", "/admin/video/search" })
public class VideoController extends HttpServlet {

	private static final long serialVersionUID = 1343304311809071457L;

	IVideoService videoService = new VideoServiceImpl();
	IVideoDao videoDao = new VideoDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		if (url.contains("videos")) {
			List<Video> list = videoService.findAll();

			req.setAttribute("listvideo", list);
			req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
		} else if (url.contains("add")) {
			req.getRequestDispatcher("/views/admin/video-add.jsp").forward(req, resp);
		} else if (url.contains("edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Video video = videoService.findById(id);

			req.setAttribute("video", video);
			req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);
		} else if (url.contains("delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Video video = videoService.findById(id);

			req.setAttribute("video", video);
			req.getRequestDispatcher("/views/admin/video-delete.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getRequestURI();

		if (url.contains("insert")) {
		    String title = req.getParameter("title");
		    String description = req.getParameter("description");
		    String active = req.getParameter("active");
		    String views = req.getParameter("views");

		    int activee = 0;
		    int viewCount = 0;

		    if (active != null && !active.isEmpty()) {
		        activee = Integer.parseInt(active);
		    } else {
	
		        activee = 0; 
		    }

		    if (views != null && !views.isEmpty()) {
		        viewCount = Integer.parseInt(views);
		    } else {
		        viewCount = 0; 
		    }

		    Video video = new Video();

		    String fname = "";
		    String upLoad = DIR;
		    File upLoadDir = new File(upLoad);
		    if (!upLoadDir.exists()) {
		        upLoadDir.mkdir();
		    }

		    try {
		        Part part = req.getPart("poster");
		        if (part.getSize() > 0) {
		            String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		            int index = filename.lastIndexOf(".");
		            String ext = filename.substring(index + 1);
		            fname = System.currentTimeMillis() + "." + ext;

		            part.write(upLoad + "/" + fname);

		            video.setPoster(fname);
		        } else {
		            video.setPoster("avatar.png");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    video.setTitle(title);
		    video.setDescription(description);  
		    video.setActive(activee);
		    video.setViews(viewCount);  
		    video.setPoster(fname);

			videoDao.save(video);

		    resp.sendRedirect(req.getContextPath() + "/admin/videos");
		}	}
}
