public class Locomotive {

    private int id;
    private int maxWeight;
    private int maxNumCarriages;
    private boolean free;
    private Train currentTrain; // Referência para o trem que faz parte no momento ou null se está livre

    /**
     * @param id
     * @param maxWeight
     * @param maxNumCarriages
     */
    public Locomotive(int id, int maxWeight, int maxNumCarriages) {
        this.id = id;
        this.maxWeight = maxWeight;
        this.maxNumCarriages = maxNumCarriages;
        this.currentTrain = null; // Começa sem associação a um trem
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
    public int getMaxWeight() {
        return maxWeight;
    }

    /**
     * @return
     */
    public int getMaxNumCarriages() {
        return maxNumCarriages;
    }

    /**
     * @return
     */
    public Train getCurrentTrain() {
        return currentTrain;
    }

    /**
     * @return
     */
    public boolean isFree() {
        return free;
    }

    /**
     * @param free
     */
    public void setFree(boolean free) {
        this.free = free;
    }

    /**
     * @param currentTrain
     */
    public void setCurrentTrain(Train currentTrain) {
        this.currentTrain = currentTrain;
    }

    public static Locomotive findLocomotiveById(int locomotiveId) {
        for (Locomotive locomotive : LocomotiveGarage.getLocomotives()) {
            if (locomotive.getId() == locomotiveId) {
                return locomotive;
            }
        }
        return null;
    }

}