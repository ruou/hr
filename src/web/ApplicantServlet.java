package web;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Applicant;
import service.ApplicantService;
import service.impl.ApplicantServiceImpl;
public class ApplicantServlet extends BaseServlet {
	private ApplicantService applicantService=new ApplicantServiceImpl();
	public String toAddPage(HttpServletRequest request, HttpServletResponse response) throws Exception	{
		request.getRequestDispatcher("/addapplicant.jsp").forward(request, response);
		return null;
	}
	public String applicantAdd(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Applicant applicant = new Applicant();
		applicant.setName(request.getParameter("name"));
		applicant.setSex(new Byte(request.getParameter("sex")));
		applicant.setAge(Integer.valueOf(request.getParameter("age")));
		applicant.setJob(request.getParameter("job"));
		applicant.setSpecialty(request.getParameter("specialty"));
		applicant.setSchool(request.getParameter("school"));
		applicant.setExperience(request.getParameter("experience"));
		applicant.setStudyeffort(request.getParameter("studyeffort"));
		applicant.setTel(request.getParameter("tel"));
		applicant.setEmail(request.getParameter("email"));
		applicant.setCreatetime(new java.util.Date());
	    applicant.setContent(request.getParameter("content"));
	    applicant.setIsstock(new Byte("0"));
	    applicantService.saveApplicant(applicant);
		List applicantList=applicantService.findApplicantByIsstock("0");
		request.setAttribute("applicantList", applicantList);
		request.getRequestDispatcher("/listapplicant.jsp").forward(request, response);
		return null;
	}
	
	public List applicantList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List applicantList=applicantService.findApplicantByIsstock("0");
		request.setAttribute("applicantList", applicantList);
		request.getRequestDispatcher("/listapplicant.jsp").forward(request, response);
		return null;
	}
	public List applicantDetail(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String  id = request.getParameter("id");
		Applicant applicant = applicantService.findApplicantById(id);
		request.setAttribute("applicant", applicant);
		request.getRequestDispatcher("/detailapplicant.jsp").forward(request, response);
		return null;
	}
	public String applicantDelete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		Applicant applicant = applicantService.findApplicantById(id);
		applicantService.deleteApplicant(id);
		List applicantList=applicantService.findApplicantByIsstock(applicant.getIsstock().toString());
		request.setAttribute("applicantList", applicantList);
		request.getRequestDispatcher("/listapplicant.jsp").forward(request, response);
		return null;
	}
	public String applicantUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		applicantService.updateApplicant(id);
		List applicantList=applicantService.findApplicantByIsstock("1");
		request.setAttribute("applicantList", applicantList);
		request.getRequestDispatcher("/listapplicant.jsp").forward(request, response);
		return null;
	}
	
	//找到入库人员
	public String findApplicantByIsstock(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String isstock = request.getParameter("isstock");
		List<Applicant> applicantList=applicantService.findApplicantByIsstock(isstock);
		request.setAttribute("applicantList", applicantList);
		request.getRequestDispatcher("/listapplicant.jsp").forward(request, response);
		return null;
	}
}