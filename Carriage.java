public class Carriage {

    private int id;
    private int maxCapacity;
    private Train currentTrain;

    public Carriage(int id, int maxCapacity){
        this.id = id;
        this.maxCapacity = maxCapacity;
        this.currentTrain = null;
    }

    public int getId() {
        return id;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public Train getCurrentTrain() {
        return currentTrain;
    }

    public void setCurrentTrain(Train currentTrain) {
        this.currentTrain = currentTrain;
    }
    
}
