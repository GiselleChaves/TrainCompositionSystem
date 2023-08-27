import java.util.ArrayList;
import java.util.List;

class TrainYard {
    private List<Train> trains;

    
    /**
     * 
     */
    public TrainYard() {
        trains = new ArrayList<>();
    }

    /**
     * @param trainId
     * @return
     */
    public static Train findTrainById(Train trainYard, int trainId) {
        for (Train train : trainYard.getTrains()) {
                if (train.getId() == trainId) {
                    return train;
                }
        }
        return null; // Não encontrou o trem
    }

    /**
     * @param train
     */
    public void addTrain(Train train) {
        trains.add(train);
    }

    /**
     * @param train
     */
    public void removeTrain(Train train) {
        trains.remove(train);
    }

    /**
     * @return
     */
    public List<Train> getTrains() {
        return trains;
    }
}