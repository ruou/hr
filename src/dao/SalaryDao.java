package dao;
import java.util.List;

import pojo.Salary;
public interface SalaryDao {
	List findAllSalaries();
	void saveSalary(Salary salary);
	void updateSalary(Salary salary);
	Salary findSalaryById(String id);
	void deleteSalary(String id);
}
