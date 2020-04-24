package dao;
import java.util.List;

import pojo.Applicant;
public interface ApplicantDao {
	void saveApplicant(Applicant applicant);
	List findAllApplicants();//找到所有应聘人员
	Applicant findApplicantById(String id);//找到应聘人员
	void deleteApplicant(String id);//删掉应聘人员
	void updateApplicant(String id);//更新应聘人员信息
	List findApplicantByIsstock(String isstock);//查找入库人员
}
