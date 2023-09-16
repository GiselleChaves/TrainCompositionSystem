/**
 * Classe que representa uma locomotiva utilizada em composições de trens.
 */
 public class Locomotive extends RailwayCar {

    private int maxWeight;
    private int maxNumWagons;

    /**
     * Construtor da classe Locomotive.
     *
     * @param id : O identificador único da locomotiva.
     * @param maxWeight : O peso máximo que a locomotiva pode puxar.
     * @param maxNumWagons : O número máximo de vagões que a locomotiva pode puxar.
     */
    public Locomotive(int id, int maxWeight, int maxNumWagons, Train currentTrain) {
        super(id, currentTrain);
        this.maxWeight = maxWeight;
        this.maxNumWagons = maxNumWagons;
    }

    /**
     * @return O peso máximo que a locomotiva pode puxar.
     */
    public int getMaxWeight() {
        return maxWeight;
    }

    /*
     * @return O número máximo de vagões que a locomotiva pode tracionar.
     */
    public int getMaxNumWagons() {
        return maxNumWagons;
    }


    /**
     * @return Uma representação em string da locomotiva e de atributos herdados do CarroFerroviário.
     */
    @Override
    public String toString() {
        return "Locomotive: " + super.toString() + ", Maximum Weight:" + maxWeight + ", Maximum Wagons Capacity:" + maxNumWagons;
    }
    
}