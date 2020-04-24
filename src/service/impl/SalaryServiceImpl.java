package service.impl;
import java.util.List;

import dao.SalaryDao;
import dao.impl.SalaryDaoImpl;
import pojo.Salary;
import service.SalaryService;
public class SalaryServiceImpl implements SalaryService{
	private SalaryDao salaryDao = new SalaryDaoImpl();
	@Override
	public List findAllSalaries() {
		return salaryDao.findAllSalaries();
	}
	@Override
	public void saveSalary(Salary salary) {
		
		salaryDao.saveSalary(salary);
	}
	@Override
	public Salary findSalaryById(String id) {
		
		return salaryDao. findSalaryById(id);
	}
	@Override
	public void updateSalary(Salary salary) {
		
		salaryDao.updateSalary(salary);	
	}
	@Override
	public void delete(String id) {
	
		salaryDao.deleteSalary(id);	
	}
}
