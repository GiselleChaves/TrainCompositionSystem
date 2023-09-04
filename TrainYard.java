import java.util.ArrayList;

/**
 * Classe que representa um pátio de trens onde trens podem ser armazenados e gerenciados.
 */
public class TrainYard {

    private ArrayList<Train> trains; //RETIREI STATIC
    
    /**
     * Construtor padrão da classe TrainYard, inicializa a lista de trens.
     */
    public TrainYard() {
        trains = new ArrayList<>();
    }
    
    /**
     * Adiciona um trem ao pátio.
     *
     * @param train O trem a ser adicionado ao pátio.
     */
    public void addTrain(Train train) {
        if (train.getLocomotives().isEmpty()) {
            System.out.println("Sorry, a train must have at least one locomotive!\n. Try again.");
            return;
        }
        else{
            trains.add(train);
        }
        
    }

    /**
     * Remove um trem do pátio.
     *
     * @param train O trem a ser removido do pátio.
     */
    public void removeTrain(Train train) { 
        trains.remove(train);
    }

    /**
     * Obtém uma lista de trens no pátio. Retorna uma cópia da lista para evitar modificação direta.
     *
     * @return Uma lista de trens no pátio.
     */
    public ArrayList<Train> getTrainsList() {
        //Clonando a lista para passar o clone 
        ArrayList<Train> trainsClone = (ArrayList<Train>)trains.clone();
        return trainsClone;
    }

    /**
     * Encontra um trem no pátio pelo seu ID.
     *
     * @param trainId O ID do trem a ser encontrado.
     * @return O trem com o ID correspondente ou null se não encontrado.
     */
    public Train findTrainById(int trainId) {
        for(Train train : this.getTrainsList()) {
            if(train.getId() == trainId) {
                return train;
            }
        }
        return null;
    }

    /**
     * Lista todos os trens no pátio, mostrando seus IDs, locomotivas e vagões associados.
     */
    public void listTrains() {
        System.out.println("\nList of Trains:");

        if (this.getTrainsList().isEmpty()) {
            System.out.println("There's no trains in our yard.");
        } else {
            for (Train train : this.getTrainsList()) {

                System.out.println("Train ID: " + train.getId());
        
                if (!train.getLocomotives().isEmpty()) {  
                    System.out.println("Locomotives:");
                    for (Locomotive locomotive : train.getLocomotives()) {
                        System.out.println("  Locomotive ID: " + locomotive.getId());
                    }
                } else {
                    System.out.println("  No locomotives associated with this train.");
                }
        
                if (!train.getWagons().isEmpty()) {
                    System.out.println("Wagons:");
                    for (Wagon wagon : train.getWagons()) {
                        System.out.println("  Wagon ID: " + wagon.getId());
                    }
                } else {
                    System.out.println("  No wagons associated with this train.");
                }
                System.out.println(); 
            }
        }
    }
}