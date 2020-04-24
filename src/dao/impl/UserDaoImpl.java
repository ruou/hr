package dao.impl;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.UserDao;
import pojo.User;
import utils.C3P0Utils;
public class UserDaoImpl implements UserDao {
	private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		String sql ="select * from user where username= ? and password = ?";
		Object[] params = new Object[]{username,password};
		User user = null;
		try {
			user = queryRunner.query(sql, new BeanHandler(User.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;	
	}

	@Override
	public void saveUser(User user) {
		/**
		 * 日期格式化
		 */
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		user.setCreatetime(Timestamp.valueOf(simpleDate.format(user.getCreatetime())));
		
		String sql ="insert into user(username,password,sex,birthday,createtime,content) values(?,?,?,?,?,?)";
		Object[] params = new Object[]{user.getUsername(),user.getPassword(),user.getSex(),user.getBirthday(),user.getCreatetime(),user.getContent()};
		try {
			queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List findAllUsers() {
		String sql ="select * from user";
		List<User> list = null;
		try {
			 list = queryRunner.query(sql, new BeanListHandler<User>(User.class) );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public User findUserById(String id) {
		String sql ="select * from user where id = ?";
		User user = null;
		try {
			user = queryRunner.query(sql,new BeanHandler<>(User.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public void updateUser(User user) {
		String sql ="update user set username=?,password=?,sex=?,birthday=?,createtime=?,content=? where id=? ";
		Object[] params={user.getUsername(),user.getPassword(),user.getSex(),user.getBirthday(),
				user.getCreatetime(),user.getContent(),user.getId()};
		try {
			queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void delete(String id) {
		String sql ="delete from user where id =? ";
		try {
			queryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
