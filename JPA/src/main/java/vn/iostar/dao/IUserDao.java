package vn.iostar.dao;

import java.util.List;

import vn.iostar.entity.User;

public interface IUserDao {
	List<User> findAll();

	User findById(int id);

	void insert(User user);

	User findByUserName(String username);
	
	User findByEmail(String email);

	boolean checkExistUsername(String username);

	User checkExistEmail(String email);

	boolean checkExistPhone(String phone);

	boolean updatePassword(String email, String password);

	int editProfile(User user);
}
