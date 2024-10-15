package vn.iostar.dao;

import java.util.List;

import vn.iostar.entity.Video;

public interface IVideoDao {
	
	 	List<Video> findAll();       
	 	
	    Video findById(int videoId);  
	    
	    void save(Video video);       
	    
	    void deleteById(int videoId) throws Exception;     
}
