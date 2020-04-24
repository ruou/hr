package dao.impl;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.SalaryDao;
import pojo.Salary;
import utils.C3P0Utils;

public class SalaryDaoImpl implements SalaryDao {
	private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
	@Override
	public List findAllSalaries() {
		String sql ="select * from salary";
		List<Salary> list = null;
		try {
			 list = queryRunner.query(sql, new BeanListHandler<Salary>(Salary.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public void saveSalary(Salary salary) {
		
		String sql ="insert into salary(name,basic,eat,house,duty,scot,punishment,other,granttime,totalize) values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[]{salary.getName(),salary.getBasic(),salary.getEat(),salary.getHouse(),salary.getDuty(),salary.getScot(),
				salary.getPunishment(),salary.getOther(),salary.getGranttime(),salary.getTotalize()};
		try {
			queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Salary findSalaryById(String id) {
		String sql ="select * from salary where id = ? ";
		Salary salary = null;
		try {
			salary = queryRunner.query(sql, new BeanHandler<>(Salary.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salary;
	}
	@Override
	public void updateSalary(Salary salary) {
		String sql ="update  salary set name = ?,basic= ?,eat= ?,house= ?,duty= ?,scot= ?,punishment= ?,other= ?,granttime= ?,totalize= ? where id = ?";
		Object[] params = new Object[]{salary.getName(),salary.getBasic(),salary.getEat(),salary.getHouse(),salary.getDuty(),salary.getScot(),
				salary.getPunishment(),salary.getOther(),salary.getGranttime(),salary.getTotalize(),salary.getId()};
		try {
			queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteSalary(String id) {
		String sql ="delete from salary where id = ? ";
		try {
			queryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}