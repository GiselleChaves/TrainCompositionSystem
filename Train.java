import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um trem, consistindo em um conjunto de listas de locomotivas e vagões
 */
public class Train {
    private int id;
    private List<RailwayCar> railwayCars;

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
        this.railwayCars = new ArrayList<>();
        this.maxWagons = 0;
        this.maxWeight = 0;
    }

    /**
     * @return O ID do trem.
     */
    public int getId() {
        return id;
    }

    /**
    * @return Uma lista do tipo passado por parâmetro (Locomotive ou Wagon) que estão na garagem.
    */
    public List<RailwayCar> getRailwayCarsFromType(Class<?> type) {
        List<RailwayCar> list = new ArrayList<RailwayCar>();
        for(RailwayCar railwayCar : railwayCars) {
            if(type.isInstance(railwayCar)) {
            list.add(railwayCar);
            }
        }
        return list;
    }

    /**
    * @return O Carro Ferroviário com o ID correspondente ou null se não encontrado.
    */
    public RailwayCar getRailwayCarById(int id) {
        for(RailwayCar railwayCar : railwayCars) {
            if(railwayCar.getId() == id) {
                return railwayCar;
            }
        }
        return null;
    }

    /**
     * @return O número máximo de vagões que o trem pode puxar.
     */
    public int getMaxWagons() {
        return maxWagons;
    }

    /**
     * @param maxWagons O número máximo de vagões que o trem pode puxar.
     */
    public void setMaxWagons(int maxWagons) {
        this.maxWagons = maxWagons;
    }

    /**
     * @return O peso máximo que o trem pode puxar.
     */
    public int getMaxWeight() {
        return maxWeight;
    }

    /**
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
    
        for (RailwayCar loc : railwayCars) {
            if(loc instanceof Locomotive) {
                Locomotive locAux = (Locomotive) loc;
                numberOfLocomotives++;
                maxNumWagons += locAux.getMaxNumWagons();
            }
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
    
        for (RailwayCar loc : railwayCars) {
            if(loc instanceof Locomotive) {
                Locomotive locAux = (Locomotive) loc;
                maxWeightCapacity += locAux.getMaxWeight();
            }
        }
        setMaxWeight(maxWeightCapacity);
    }

    /**
     * @return A quantidade de peso disponível para puxar após levar em consideração os vagões já conectados.
     */
    public int availableWeightForPulling() {
        recalculateMaxWeightCapacity();

        int wagonsWeight = 0;

        // Calcula a capacidade máxima de peso dos vagões já conectados.
        for (RailwayCar wagon : railwayCars) {
            if(wagon instanceof Wagon) {
                Wagon wagAux = (Wagon) wagon;
                wagonsWeight += wagAux.getMaxCapacity();
            }
        }

        // Calcula a quantidade de peso disponível para puxar.
        int availableWeightForPulling = getMaxWeight() - wagonsWeight;

        return availableWeightForPulling;
    }

    /**
     * @return A quantidade de vagões que podem ser adicionados à composição do trem.
     */
    public int availableWagonQuantity() {
        recalculateWagonPullingCapacity();

        int numberOfWagons = getRailwayCarsFromType(Wagon.class).size();

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
    public boolean addLocomotive(Locomotive locomotive, RailwayCarGarage railwayCarGarage) {

        // Verifica se o número máximo de locomotivas foi atingido.
        if (getRailwayCarsFromType(Locomotive.class).size() >= MAX_LOCOMOTIVES) {
            System.out.println("The maximum number of locomotives for this train has been reached.");
            return false;
        }

        // Verifica se a locomotiva já está conectada a outro trem.
        if (locomotive.getCurrentTrain() != null) {
            System.out.println("Sorry, that locomotive is already added to a train.");
            return false;
        }

        // Verifica se já existem vagões, impedindo a inserção de locomotivas após vagões.
        if (getRailwayCarsFromType(Wagon.class).size() != 0) {
            System.out.println("Sorry, you cannot insert a locomotive after a wagon.");
            return false;
        } else {
            locomotive.setCurrentTrain(this);
            railwayCars.add(locomotive);

            //Remover da garagem.
            railwayCarGarage.removeRailwayCar(locomotive);
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
    public boolean addWagon(Wagon wagon, RailwayCarGarage railwayCarGarage){

        // Verifica se há locomotivas inseridas antes.
        if (getRailwayCarsFromType(Locomotive.class).size() == 0) {
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
            railwayCars.add(wagon);

            //Remover da garagem.
            railwayCarGarage.removeRailwayCar(wagon);
            return true;
        }
    }

    /**
     * Remove o último elemento do trem e o coloca na garagem de vagões.
     *
     * @param railwayCarGarage : A garagem de carros ferroviários onde o elemento será colocado.
     * @return true se o elemento foi removido com sucesso, false caso contrário.
     */
    public boolean removeLastElement(RailwayCarGarage railwayCarGarage) {

        if (!railwayCars.isEmpty()) {
            RailwayCar lastElement = railwayCars.get(railwayCars.size() - 1); // Obtém o último.

            lastElement.setCurrentTrain(null);
            railwayCarGarage.addRailwayCar(lastElement);

            railwayCars.remove(lastElement);

            return true;
        }
        System.out.println("No elements to remove from this train.");
        return false;
    }
}
