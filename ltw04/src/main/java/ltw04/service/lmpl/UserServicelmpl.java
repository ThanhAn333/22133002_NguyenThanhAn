package ltw04.service.lmpl;

import ltw04.Models.User;
import ltw04.service.UserService;


import ltw04.DAO.UserDAO;
import ltw04.DAO.lmpl.UserDAOlmpl;

public class UserServicelmpl implements UserService {
	private UserDAO userDAO = new UserDAOlmpl();

    @Override
    public User login(String username, String password) {
        User user = userDAO.findByUserName(username);
        if (user != null && user.getPassWord().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public void register(User user) {
        userDAO.register(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

}
