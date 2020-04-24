package dao.impl;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.ApplicantDao;
import pojo.Applicant;
import utils.C3P0Utils;
public class ApplicantDaoImpl implements ApplicantDao {
	private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
	@Override
	//增加应聘人员
	public void saveApplicant(Applicant applicant) {
		/**
		 * 设置日期的格式
		 */
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		applicant.setCreatetime(Timestamp.valueOf(simpleDate.format(applicant.getCreatetime())));
		
		String sql ="insert into applicant(name,sex,age,job,specialty,experience,studyeffort,school,tel,email,createtime,content,isstock) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[]{applicant.getName(),applicant.getSex(),applicant.getAge(),applicant.getJob(),applicant.getSpecialty(),
				applicant.getExperience(),applicant.getStudyeffort(),applicant.getSchool(),applicant.getTel(),applicant.getEmail(),applicant.getCreatetime(),applicant.getContent()
				,applicant.getIsstock()};
		try {
			queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	@Override
	public List findAllApplicants() {
		String sql ="select * from applicant";
		List<Applicant> list = null;
		try {
			 list = queryRunner.query(sql, new BeanListHandler<Applicant>(Applicant.class) );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Applicant findApplicantById(String id) {
		String sql ="select * from applicant where id = ?";
		Applicant applicant = null;
		try {
			applicant = queryRunner.query(sql,new BeanHandler<>(Applicant.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applicant;
	}
	@Override
	public void deleteApplicant(String id) {
		String sql ="delete from applicant where id =? ";
		try {
			queryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateApplicant(String id) {
		String sql ="update applicant set isstock = 1 where id =? ";
		try {
			queryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List findApplicantByIsstock(String isstock) {
		String sql ="select * from applicant where isstock = ?";
		List applicantList  = null;
		try {
			applicantList = queryRunner.query(sql,new BeanListHandler<>(Applicant.class),isstock);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applicantList;
	}
}
