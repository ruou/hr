package service.impl;
import java.util.List;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;
public class UserServiceImpl implements UserService {
	private	UserDao userDao = new UserDaoImpl();
	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		User user = userDao.findUserByUsernameAndPassword(username,  password);
		return user;
	}
	@Override
	public void saveUser(User user) {
		UserDao userDao = new UserDaoImpl();
		userDao.saveUser(user);
	}
	@Override
	public List findAllUsers() {
		UserDao userDao = new UserDaoImpl();
		return userDao.findAllUsers();
	}
	@Override
	public User findUserById(String id) {
		UserDao userDao = new UserDaoImpl();
		User user=userDao.findUserById(id);
		return user;
	}
	@Override
	public void updateUser(User user) {
		UserDao userDao = new UserDaoImpl();
		userDao.updateUser(user);
	}
	@Override
	public void delete(String id) {
		UserDao userDao = new UserDaoImpl();
		userDao.delete(id);
	}
}
