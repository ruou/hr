package service.impl;
import java.util.List;

import dao.TrainDao;
import dao.impl.TrainDaoImpl;
import pojo.Train;
import service.TrainService;
public class TrainServiceImpl implements TrainService {
	private TrainDao trainDao = new TrainDaoImpl();
	@Override
	public void saveTrain(Train train) {
		trainDao.save(train);
	}
	@Override
	public List findAllTrains() {
		return trainDao.findAllTrains();
	}
	@Override
	public List<Train> findTrainByEducate(String educate) {
		return trainDao.findTrainByEducate(educate);
	}
	@Override
	public Train findTrainById(String id) {
		return trainDao.findTrainById(id);
	}
	@Override
	public void updateTrain(Train train) {
		trainDao.updateTrain(train);
	}
	@Override
	public void delete(String id) {
		trainDao.delete(id);
	}
}
