package service.impl;
import java.util.List;

import dao.ApplicantDao;
import dao.impl.ApplicantDaoImpl;
import pojo.Applicant;
import service.ApplicantService;
public class ApplicantServiceImpl implements ApplicantService {
	private ApplicantDao applicantDao = new ApplicantDaoImpl();
	@Override
	public void saveApplicant(Applicant applicant) {
		applicantDao.saveApplicant(applicant);	
	}
	@Override
	public List findAllApplicants() {
		return applicantDao.findAllApplicants();
	}
	@Override
	public Applicant findApplicantById(String id) {
		return applicantDao.findApplicantById(id);
	}
	@Override
	public void deleteApplicant(String id) {
		applicantDao.deleteApplicant(id);
	}
	@Override
	public void updateApplicant(String id) {
		applicantDao.updateApplicant(id);	
	}
	@Override
	public List findApplicantByIsstock(String isstock) {
		return applicantDao.findApplicantByIsstock(isstock) ;
	}
}
