package ltw04.DAO;


import ltw04.Models.User;

public interface UserDAO {
	User findByUserName(String username);
    User findByEmail(String email);
   
    void register(User user); // Add this method
    public void update(User user);
}
