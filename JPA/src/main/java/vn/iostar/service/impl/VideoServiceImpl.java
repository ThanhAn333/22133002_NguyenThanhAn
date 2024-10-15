package vn.iostar.service.impl;

import java.util.List;

import vn.iostar.dao.IVideoDao;
import vn.iostar.dao.impl.VideoDaoImpl;
import vn.iostar.entity.Video;
import vn.iostar.service.IVideoService;

public class VideoServiceImpl implements IVideoService {
	
	IVideoDao videoDao = new VideoDaoImpl();
	@Override
	public List<Video> findAll() {
		return videoDao.findAll();
	}

	@Override
	public Video findById(int videoId) {
		return videoDao.findById(videoId);
	}

	@Override
	public void save(Video video) {
		videoDao.save(video);
	}

	@Override
	public void deleteById(int videoId) throws Exception {
		videoDao.deleteById(videoId);
	}

}
