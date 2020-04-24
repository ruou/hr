package service;
import java.util.List;

import pojo.User;
public interface UserService {
	User findUserByUsernameAndPassword(String username, String password);
	void saveUser(User user);
	List findAllUsers();
	User findUserById(String id);
	void updateUser(User user);
	void delete(String id);
}
