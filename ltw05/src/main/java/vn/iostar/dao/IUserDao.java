package vn.iostar.dao;

import java.util.List;

import vn.iostar.models.UserModel;

public interface IUserDao {
	List<UserModel> findAll();
	
	UserModel findById(int id);
	void insert(UserModel user);
	
	UserModel findByUserName(String username);

	boolean checkExistUsername(String username);

	boolean checkExistEmail(String email);
	
	boolean checkExistPhone(String phone);
	
	boolean updatePassword(String email, String password);

<<<<<<< HEAD
	int editProfile(UserModel user);

=======
>>>>>>> 33b0958cd7eea6bca183618b81c6e2cc4d85b5be
	
}
