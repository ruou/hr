package service;
import java.util.List;

import pojo.Applicant;
public interface ApplicantService {
	void saveApplicant(Applicant applicant);
	List findAllApplicants();
	Applicant findApplicantById(String id);
	void deleteApplicant(String id);
	void updateApplicant(String id);
	List findApplicantByIsstock(String isstock);
}
