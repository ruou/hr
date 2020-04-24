package web;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Salary;
import service.SalaryService;
import service.impl.SalaryServiceImpl;
import utils.DateUtil;
public class SalaryServlet extends BaseServlet {
	private SalaryService salaryService=new SalaryServiceImpl();
	public List salaryList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List salaryList=salaryService.findAllSalaries();
		request.setAttribute("salaryList", salaryList);
		request.getRequestDispatcher("/listsalary.jsp").forward(request, response);
		return null;
	}
	public String toAddPage(HttpServletRequest request, HttpServletResponse response) throws Exception	{
		request.getRequestDispatcher("/addsalary.jsp").forward(request, response);
		return null;
	}
	public List salaryAdd(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Salary salary = new Salary();
		salary.setName(request.getParameter("name"));
		salary.setBasic(Double.parseDouble(request.getParameter("basic")));
		salary.setEat(Double.parseDouble(request.getParameter("eat")));
		salary.setHouse(Double.parseDouble(request.getParameter("house")));
		salary.setGranttime(DateUtil.parseToDate(request.getParameter("granttime"), DateUtil.yyyyMMdd));
		salary.setDuty(Double.parseDouble(request.getParameter("duty")));
		salary.setOther(Double.parseDouble(request.getParameter("other")));
		salary.setPunishment(Double.parseDouble(request.getParameter("punishment")));
		salary.setScot(Double.parseDouble(request.getParameter("scot")));
		salary.setTotalize(salary.getBasic()+salary.getDuty()+salary.getEat()+salary.getHouse()+salary.getOther()-salary.getPunishment()-salary.getScot());
		salaryService.saveSalary(salary);
		List salaryList=salaryService.findAllSalaries();
		request.setAttribute("salaryList", salaryList);
		request.getRequestDispatcher("/listsalary.jsp").forward(request, response);
		return null;
	}
	public String toUpdatePage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		Salary salary = salaryService.findSalaryById(id);
		request.setAttribute("salary", salary);
		request.getRequestDispatcher("/updatesalary.jsp").forward(request, response);
		return null;
	}
	public String salaryUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Salary salary = new Salary();
		salary.setId(Long.valueOf(request.getParameter("id")));
		salary.setName(request.getParameter("name"));
		salary.setBasic(Double.parseDouble(request.getParameter("basic")));
		salary.setEat(Double.parseDouble(request.getParameter("eat")));
		salary.setHouse(Double.parseDouble(request.getParameter("house")));
		salary.setGranttime(DateUtil.parseToDate(request.getParameter("granttime"), DateUtil.yyyyMMdd));
		salary.setDuty(Double.parseDouble(request.getParameter("duty")));
		salary.setOther(Double.parseDouble(request.getParameter("other")));
		salary.setPunishment(Double.parseDouble(request.getParameter("punishment")));
		salary.setScot(Double.parseDouble(request.getParameter("scot")));
		salary.setTotalize(salary.getBasic()+salary.getDuty()+salary.getEat()+salary.getHouse()+salary.getOther()-salary.getPunishment()-salary.getScot());
		salaryService.updateSalary(salary);
		List salaryList=salaryService.findAllSalaries();
		request.setAttribute("salaryList", salaryList);
		request.getRequestDispatcher("/listsalary.jsp").forward(request, response);
		return null;
	}
	public String salaryDelete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		salaryService.delete(id);
		List salaryList=salaryService.findAllSalaries();
		request.setAttribute("salaryList", salaryList);
		request.getRequestDispatcher("/listsalary.jsp").forward(request, response);
		return null;
	}
}
