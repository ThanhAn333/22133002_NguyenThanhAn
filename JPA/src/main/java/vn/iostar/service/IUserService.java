package vn.iostar.service;

import java.util.List;

import vn.iostar.entity.User;

public interface IUserService {
	
	User Login(String username, String password);
	
	boolean register(String email, String password, String username, String fullname, String phone);
	
	List<User> findAll();

	User findById(int id);

	void insert(User user);

	User findByUserName(String username);

	boolean checkExistUsername(String username);

	boolean checkExistEmail(String email);

	boolean checkExistPhone(String phone);

	boolean updatePassword(String email, String password);

	int editProfile(User user);
}
