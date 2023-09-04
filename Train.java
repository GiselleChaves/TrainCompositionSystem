import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um trem, consistindo em um conjunto de listas de locomotivas e vagões
 */
public class Train {
    private int id;
    private List<Locomotive> locomotives;
    private List<Wagon> wagons;

    private int maxWagons; // Número máximo de vagões que um trem consegue puxar
    private int maxWeight; // Número máximo de peso que consegue puxar

    private static final int MAX_LOCOMOTIVES = 5; // Número máximo de locomotivas
    private static final int MAX_LOCOMOTIVES_WITHOUT_REDUCTION = 2; // Número máximo de locomotivas sem haver redução
    private static final double LOCOMOTIVE_CAPACITY_REDUCTION = 0.10; // Percentual de redução

    /**
     * Construtor da classe Train.
     *
     * @param id : O identificador único do trem.
     */
    public Train(int id) {
        this.id = id;
        this.locomotives = new ArrayList<>();
        this.wagons = new ArrayList<>();
        this.maxWagons = 0;
        this.maxWeight = 0;
    }

    /**
     * Obtém o ID do trem.
     *
     * @return O ID do trem.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém a lista de locomotivas do trem.
     *
     * @return A lista de locomotivas do trem.
     */
    public List<Locomotive> getLocomotives() {
        return locomotives;
    }

    /**
     * Obtém a lista de vagões do trem.
     *
     * @return A lista de vagões do trem.
     */
    public List<Wagon> getWagons() {
        return wagons;
    }

    /**
     * Obtém o número máximo de vagões que o trem pode puxar.
     *
     * @return O número máximo de vagões que o trem pode puxar.
     */
    public int getMaxWagons() {
        return maxWagons;
    }

    /**
     * Define o número máximo de vagões que o trem pode puxar.
     *
     * @param maxWagons O número máximo de vagões que o trem pode puxar.
     */
    public void setMaxWagons(int maxWagons) {
        this.maxWagons = maxWagons;
    }

    /**
     * Obtém o peso máximo que o trem pode puxar.
     *
     * @return O peso máximo que o trem pode puxar.
     */
    public int getMaxWeight() {
        return maxWeight;
    }

    /**
     * Define o peso máximo que o trem pode puxar.
     *
     * @param maxWeight O peso máximo que o trem pode puxar.
     */
    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    // Métodos de recálculo de capacidade de puxar

    /**
     * Recalcula a capacidade de puxar vagões com base na presença de locomotivas e suas capacidades.
     */
    public void recalculateWagonPullingCapacity() {
        int maxNumWagons = 0;
        int numberOfLocomotives = 0;
    
        for (Locomotive loc : locomotives) {
            numberOfLocomotives++;
            maxNumWagons += loc.getMaxNumWagons();
    
            if (numberOfLocomotives >= MAX_LOCOMOTIVES_WITHOUT_REDUCTION) {
                maxNumWagons = (int) (maxNumWagons - (maxNumWagons * LOCOMOTIVE_CAPACITY_REDUCTION));
            }
        }
    
        setMaxWagons(maxNumWagons);
    }

    /**
     * Recalcula a capacidade máxima de peso que o trem pode puxar com base nas locomotivas adicionadas.
     */
    public void recalculateMaxWeightCapacity() {
        int maxWeightCapacity = 0;
    
        for (Locomotive loc : locomotives) {
            maxWeightCapacity += loc.getMaxWeight();
        }
    
        setMaxWeight(maxWeightCapacity);
    }

    /**
     * Calcula a quantidade de peso disponível para puxar adicionando vagões.
     *
     * @return A quantidade de peso disponível para puxar após levar em consideração os vagões já conectados.
     */
    public int availableWeightForPulling() {
        recalculateMaxWeightCapacity();

        int wagonsWeight = 0;

        // Calcula a capacidade máxima de peso dos vagões já conectados.
        for (Wagon wagon : wagons) {
            wagonsWeight += wagon.getMaxCapacity();
        }

        // Calcula a quantidade de peso disponível para puxar.
        int availableWeightForPulling = getMaxWeight() - wagonsWeight;

        return availableWeightForPulling;
    }

    /**
     * Calcula a quantidade disponível de vagões que podem ser conectados ao trem.
     *
     * @return A quantidade de vagões que podem ser adicionados à composição do trem.
     */
    public int availableWagonQuantity() {
        recalculateWagonPullingCapacity();

        int numberOfWagons = wagons.size();

        // Calcula a quantidade disponível de vagões com base na capacidade de puxar do trem e na quantidade atual de vagões.
        int availableWagonQuantity = getMaxWagons() - numberOfWagons;

        return availableWagonQuantity;
    }

    /**
     * Adiciona uma locomotiva ao trem.
     *
     * @param locomotive : A locomotiva a ser adicionada.
     * @param locomotiveGarage : A garagem em que ela está localizada
     * @return true se a locomotiva foi adicionada com sucesso, false caso contrário.
     */
    public boolean addLocomotive(Locomotive locomotive, LocomotiveGarage locomotiveGarage) {

        // Verifica se o número máximo de locomotivas foi atingido.
        if (locomotives.size() >= MAX_LOCOMOTIVES) {
            System.out.println("The maximum number of locomotives for this train has been reached.");
            return false;
        }

        // Verifica se a locomotiva já está conectada a outro trem.
        if (locomotive.getCurrentTrain() != null) {
            System.out.println("Sorry, that locomotive is already added to a train.");
            return false;
        }

        // Verifica se já existem vagões, impedindo a inserção de locomotivas após vagões.
        if (wagons.size() != 0) {
            System.out.println("Sorry, you cannot insert a locomotive after a wagon.");
            return false;
        } else {
            locomotive.setCurrentTrain(this);
            locomotives.add(locomotive);

            //Remover da garagem de locomotivas.
            locomotiveGarage.removeLocomotive(locomotive);
            return true;
        }
    }

    /**
     * Adiciona um vagão ao trem.
     *
     * @param wagon : O vagão a ser adicionado.
     * @param wagonGarage : A garagem em que ele está localizado.
     * @return true se o vagão foi adicionado com sucesso, false caso contrário.
     */
    public boolean addWagon(Wagon wagon, WagonGarage wagonGarage){

        // Verifica se há locomotivas inseridas antes.
        if (locomotives.size() == 0) {
            System.out.println("Sorry, you need to add locomotives first.");
            return false;
        }

        // Verifica se o vagão está conectado a algum trem.
        if (wagon.getCurrentTrain() != null) {
            System.out.println("Sorry, this wagon is already added to a train.");
            return false;
        }
        
        // Verifica se o número máximo de vagões foi atingido.
        if (availableWagonQuantity() == 0) {
            System.out.println("The maximum number of wagons for this train has been reached.");
            return false;
        }

        // Verifica se o peso ultrapassa o disponível.
        if (availableWeightForPulling() < wagon.getMaxCapacity()) {
            System.out.println("Sorry, this train cannot support the weight of this wagon.");
            return false;
        } else{

            wagon.setCurrentTrain(this);
            wagons.add(wagon);

            //Remover da garagem de vagões
            wagonGarage.removeWagon(wagon);
            return true;
        }
    }

    /**
     * Remove o último vagão do trem e o coloca na garagem de vagões.
     *
     * @param wagonGarage : A garagem de vagões onde o vagão será colocado.
     * @return true se o vagão foi removido com sucesso, false caso contrário.
     */
    public boolean removeLastWagon(WagonGarage wagonGarage) {

        if (!wagons.isEmpty()) {
            Wagon lastWagon = wagons.get(wagons.size() - 1); // Obtém o último vagão.

            lastWagon.setCurrentTrain(null);
            wagonGarage.addWagon(lastWagon);

            wagons.remove(lastWagon);

            return true;
        }
        System.out.println("No wagons to remove from this train.");
        return false;
    }
    
    /**
     * Remove a última locomotiva do trem e a coloca na garagem de locomotivas.
     *
     * @param locomotiveGarage : A garagem de locomotivas onde a locomotiva será colocada.
     * @return true se a locomotiva foi removida com sucesso, false caso contrário.
     */
    public boolean removeLastLocomotive(LocomotiveGarage locomotiveGarage) {
        if (!locomotives.isEmpty()) {
            Locomotive lastLocomotive = locomotives.get(locomotives.size() - 1); // Obtém a última locomotiva.
    
            lastLocomotive.setCurrentTrain(null);
            locomotiveGarage.addLocomotive(lastLocomotive);
    
            locomotives.remove(lastLocomotive);
    
            return true;
        }
    
        System.out.println("No locomotives to remove from this train.");
        return false;
    }
    
}
