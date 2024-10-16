package vn.iostar.service.impl;

import java.util.List;

import vn.iostar.dao.IUserDao;
import vn.iostar.dao.impl.UserDaoImpl;
import vn.iostar.entity.User;
import vn.iostar.service.IUserService;

public class UserServiceImpl implements IUserService {

	IUserDao userDao = new UserDaoImpl();
	
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findById(int id) {
		
		return userDao.findById(id);
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);
		
	}

	@Override
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistEmail(String email) {
		User user = userDao.checkExistEmail(email);
	    return user != null;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public boolean updatePassword(String email, String password) {
		return userDao.updatePassword(email, password);
		
	}

	@Override
	public User Login(String username, String password) {
		  User user = userDao.findByUserName(username);
		    if (user != null && user.getPassword().equals(password)) {
		        return user;
		    }
		    return null;
	}

	

	@Override
	public int editProfile(User user) {
		User existingUser = userDao.findById(user.getId());
	    if (existingUser != null) {
	        existingUser.setFullname(user.getFullname());
	        existingUser.setEmail(user.getEmail());
	        existingUser.setPhone(user.getPhone());
	        userDao.insert(existingUser);
	        return 1;
	    }
	    return 0;
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		 User newUser = new User();
		    newUser.setEmail(email);
		    newUser.setPassword(password);
		    newUser.setUsername(username);
		    newUser.setFullname(fullname);
		    newUser.setPhone(phone);
		    newUser.setCreatedDate(date.toString());
		    userDao.insert(newUser);
		    
		    return true; 
	}

	

}
