public class Carriage {

    private int id;
    private int maxCapacity;
    //private int carriageWeight;
    private Train currentTrain;

    /**
     * @param id
     * @param maxCapacity
     * @param carriageWeight
     */
    public Carriage(int id, int maxCapacity){
        this.id = id;
        this.maxCapacity = maxCapacity;
        this.currentTrain = null;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @return
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * @return
     */
    public Train getCurrentTrain() {
        return currentTrain;
    }

    /**
     * @param currentTrain
     */
    public void setCurrentTrain(Train currentTrain) {
        this.currentTrain = currentTrain;
    }
}
