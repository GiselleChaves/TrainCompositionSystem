public class Carriage {

    private int id;
    private int maxCapacity;
    private int carriageWeight;
    private Train currentTrain;

    /**
     * @param id
     * @param maxCapacity
     * @param carriageWeight
     */
    public Carriage(int id, int maxCapacity, int carriageWeight){
        if (isCarriageIdTaken(id)) {
            throw new IllegalArgumentException("Carriage with ID " + id + " already exists.");
        }
        else{
            this.id = id;
        }
        this.maxCapacity = maxCapacity;
        this.carriageWeight = carriageWeight;
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
    public int getCarriageWeight() {
        return carriageWeight;
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

    /**
     * @param idToCheck
     */
    private boolean isCarriageIdTaken(int idToCheck) {

        for(Carriage carriage : CarriageGarage.getCarriages()){
            if(idToCheck == carriage.getId()){
                return true;
            }
        }
        return false;
    }
}
