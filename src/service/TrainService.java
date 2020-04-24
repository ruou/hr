package service;
import java.util.List;

import pojo.Train;
public interface TrainService {
	void saveTrain(Train train);
	List findAllTrains();
	List<Train> findTrainByEducate(String educate);
	Train findTrainById(String id);
	void updateTrain(Train train);
	void delete(String id);
}
