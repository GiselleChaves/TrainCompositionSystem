public class Carriage {

    private int id;
    private int maxCapacity;
    private Train currentTrain;

    /**
     * @param id
     * @param maxCapacity
     * @param carriageWeight
     */
    public Carriage(int id, int maxCapacity, CarriageGarage carriageGarage){
        if (isCarriageIdTaken(carriageGarage, id)) {
            throw new IllegalArgumentException("Carriage with ID " + id + " already exists.");
        }
        else{
            this.id = id;
        }
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

    /**
     * @param idToCheck
     */
    private boolean isCarriageIdTaken(CarriageGarage carriageGarage, int idToCheck) {

        for(Carriage carriage : carriageGarage.getCarriages()){
            if(idToCheck == carriage.getId()){
                return true;
            }
        }
        return false;
    }
}
