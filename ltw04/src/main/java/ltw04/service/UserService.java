package ltw04.service;



import ltw04.Models.User;

public interface UserService {
	User login(String username, String password);
    User findByEmail(String email);
    void register(User user);
    void update(User user);
}
