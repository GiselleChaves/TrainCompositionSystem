public class Locomotive {

    private int id;
    private int maxWeight;
    private int maxNumCarriages;
    private Train currentTrain; // Referência para o trem que faz parte no momento ou null se está livre

    public Locomotive(int id, int maxWeight, int maxNumCarriages) {
        this.id = id;
        this.maxWeight = maxWeight;
        this.maxNumCarriages = maxNumCarriages;
        this.currentTrain = null; // Começa sem associação a um trem
    }

    public int getId() {
        return id;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getMaxNumCarriages() {
        return maxNumCarriages;
    }

    public Train getCurrentTrain() {
        return currentTrain;
    }

    public void setCurrentTrain(Train currentTrain) {
        this.currentTrain = currentTrain;
    }

}