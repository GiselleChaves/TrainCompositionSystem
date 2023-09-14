/**
 * Classe que representa um vagão utilizado em composições de trens.
 */
public class Wagon extends RailwayCar{

    private int id;
    private int maxCapacity;
    private Train currentTrain; // Referência para o trem que faz parte no momento ou null se está livre

    /**
     * Construtor da classe Wagon para criar um novo vagão com um ID e capacidade máxima especificados.
     *
     * @param id           O ID do vagão.
     * @param maxCapacity  A capacidade máxima do vagão.
     */
    public Wagon(int id, int maxCapacity, Train currentTrain){
        super(id, currentTrain);
        this.maxCapacity = maxCapacity; 
    }

    /**
     * @return A capacidade máxima do vagão.
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * @return Uma representação em string do vagão e de atributos herdados do CarroFerroviário
     */
    @Override
    public String toString() {
        return "Wagon: " + super.toString() + ", Maximum Capacity:" + maxCapacity;
    }
    
}