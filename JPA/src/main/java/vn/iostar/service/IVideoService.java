package vn.iostar.service;

import java.util.List;

import vn.iostar.entity.Video;

public interface IVideoService {
	List<Video> findAll();       
 	
    Video findById(int videoId);  
    
    void save(Video video);       
    
    void deleteById(int videoId) throws Exception;
}
