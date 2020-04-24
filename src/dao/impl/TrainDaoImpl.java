package dao.impl;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.TrainDao;
import pojo.Train;
import utils.C3P0Utils;
public class TrainDaoImpl implements TrainDao {
	private QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
	@Override
	public void save(Train train) {
		String sql ="insert into train(name,purpose,begintime,endtime,datum,teacher,student,educate) values(?,?,?,?,?,?,?,?)";
		Object[] params = new Object[]{train.getName(),train.getPurpose(),train.getBegintime(),train.getEndtime(),
				train.getDatum(),train.getTeacher(),train.getStudent(),train.getEducate()};
		try {
			queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List findAllTrains() {
		String sql ="select * from train";
		List<Train> list = null;
		try {
			 list = queryRunner.query(sql, new BeanListHandler<Train>(Train.class) );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Train> findTrainByEducate(String educate) {
		String sql ="select * from train where educate = ?";
		List<Train> list = null;
		try {
			 list = queryRunner.query(sql, new BeanListHandler<Train>(Train.class),educate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Train findTrainById(String id) {
		String sql ="select * from train where id = ?";
		Train train = null;
		try {
			train = queryRunner.query(sql,new BeanHandler<>(Train.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return train;
	}

	@Override
	public void updateTrain(Train train) {
		String sql ="update train set educate = ?, effect = ? ,summarize = ?  where id =?";
		Object[] params ={1,train.getEffect(),train.getSummarize(),train.getId()};
		try {
			queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		String sql ="delete from train where id =? ";
		try {
			queryRunner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
