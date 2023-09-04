/**
 * Classe que representa uma locomotiva utilizada em composições de trens.
 */
 public class Locomotive {

    private int id;
    private int maxWeight;
    private int maxNumWagons;
    private Train currentTrain; // Referência para o trem que faz parte no momento ou null se está livre

    /**
     * Construtor da classe Locomotive.
     *
     * @param id : O identificador único da locomotiva.
     * @param maxWeight : O peso máximo que a locomotiva pode puxar.
     * @param maxNumWagons : O número máximo de vagões que a locomotiva pode puxar.
     */
    public Locomotive(int id, int maxWeight, int maxNumWagons) {
        this.id = id;
        this.maxWeight = maxWeight;
        this.maxNumWagons = maxNumWagons;
        this.currentTrain = null; // Começa sem associação a um trem
    }

    /**
     * Obtém o ID da locomotiva.
     *
     * @return O ID da locomotiva.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém o peso máximo que a locomotiva pode puxar.
     *
     * @return O peso máximo que a locomotiva pode puxar.
     */
    public int getMaxWeight() {
        return maxWeight;
    }

    /**
     * Obtém o número máximo de vagões que a locomotiva pode puxar.
     *
     * @return O número máximo de vagões que a locomotiva pode puxar.
     */
    public int getMaxNumWagons() {
        return maxNumWagons;
    }

    /**
     * Obtém a referência para o trem atual ao qual a locomotiva está associada.
     *
     * @return O trem atual ao qual a locomotiva está associada ou null se está livre.
     */
    public Train getCurrentTrain() {
        return currentTrain;
    }

    /**
     * Define o trem atual ao qual a locomotiva está associada.
     *
     * @param currentTrain O trem atual ao qual a locomotiva está associada.
     */
    public void setCurrentTrain(Train currentTrain) {
        this.currentTrain = currentTrain;
    }

    /**
     * Substitui o método padrão de representação em string para a locomotiva.
     *
     * @return Uma representação em string da locomotiva, incluindo seus atributos.
     */
    @Override
    public String toString() {
        return "Locomotive [id=" + id + ", maxWeight=" + maxWeight + ", maxNumWagons=" + maxNumWagons
                + ", currentTrain=" + currentTrain + "]";
    }
    
}