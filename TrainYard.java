import java.util.ArrayList;
import java.util.List;

class TrainYard {

    private List<Train> trains;
    //O prof. recomendou fazer com array list 

    public TrainYard() {
        trains = new ArrayList<>();
    }

    public void addTrain(Train train) {
        trains.add(train);
    }

    public void removeTrain(Train train) {
        trains.remove(train);
    }

    public List<Train> getTrains() {
        return trains;
    }
}