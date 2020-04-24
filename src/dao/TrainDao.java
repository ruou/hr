package dao;
import java.util.List;

import pojo.Train;
public interface TrainDao {
	void save(Train train);
	List findAllTrains();
	List<Train> findTrainByEducate(String educate);
	Train findTrainById(String id);
	void updateTrain(Train train);
	void delete(String id);
}
