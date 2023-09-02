/**
 * Classe que representa um vagão utilizado em composições de trens.
 */
public class Wagon {

    private int id;
    private int maxCapacity;
    private Train currentTrain; // Referência para o trem que faz parte no momento ou null se está livre

    /**
     * Construtor da classe Wagon para criar um novo vagão com um ID e capacidade máxima especificados.
     *
     * @param id           O ID do vagão.
     * @param maxCapacity  A capacidade máxima do vagão.
     */
    public Wagon(int id, int maxCapacity){
        this.id = id;
        this.maxCapacity = maxCapacity;
        this.currentTrain = null; // Começa sem associação a um trem
    }

    /**
     * Obtém o ID do vagão.
     *
     * @return O ID do vagão.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém a capacidade máxima do vagão.
     *
     * @return A capacidade máxima do vagão.
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Obtém o trem atual associado a este vagão.
     *
     * @return O trem atual associado a este vagão.
     */
    public Train getCurrentTrain() {
        return currentTrain;
    }

    /**
     * Define o trem atual associado a este vagão.
     *
     * @param currentTrain O trem atual associado a este vagão.
     */
    public void setCurrentTrain(Train currentTrain) {
        this.currentTrain = currentTrain;
    }

    /**
     * Retorna uma representação em formato de string deste vagão, incluindo seu ID, capacidade máxima e trem atual.
     *
     * @return Uma representação em formato de string deste vagão.
     */
    @Override
    public String toString() {
        return "Wagon [id=" + id + ", maxCapacity=" + maxCapacity + ", currentTrain=" + currentTrain + "]";
    }
    
}