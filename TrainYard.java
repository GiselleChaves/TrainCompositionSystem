import java.util.ArrayList;

public class TrainYard {

    private ArrayList<Train> trains; //RETIREI STATIC
    
    public TrainYard() {
        trains = new ArrayList<>();
    }
    
    /**
     * @param train
     */
    public void addTrain(Train train) { //RETIREI STATIC
        if (train.getLocomotives().isEmpty()) {
            System.out.println("Sorry, a train must have at least one locomotive!\n. Try again.");
            return;
        }
        else{
            trains.add(train);
        }
        
    }

    /**
     * @param train
     */
    public void removeTrain(Train train) { //RETIREI STATIC
        trains.remove(train);
    }

    /**
     * 
     */
    public ArrayList<Train> getTrainsList() {
        ArrayList<Train> trainsClone = new ArrayList<>(trains); // Cria uma cópia da lista original
        return trainsClone;
    }

    /**
     * @param trainId
     */
    public Train findTrainById(int trainId) {
        for (Train train : trains) {
            if (train.getId() == trainId) {
                return train;
            }
        }
        return null; // Retornar null se o trem não for encontrado.
    }
    

    /**
     * 
     */
    public void listTrains() {
        System.out.println("\nList of Trains:");
    
        if (getTrainsList().isEmpty()) {
            System.out.println("There's no trains in our yard.");
        } else {
            for (Train train : getTrainsList()) { 

                System.out.println("Train ID: " + train.getId());
        
                if (!train.getLocomotives().isEmpty()) {  
                    System.out.println("Locomotives:");
                    for (Locomotive locomotive : train.getLocomotives()) {
                        System.out.println("  Locomotive ID: " + locomotive.getId());
                    }
                } else {
                    System.out.println("  No locomotives associated with this train.");
                }
        
                if (!train.getCarriages().isEmpty()) {
                    System.out.println("Carriages:");
                    for (Carriage carriage : train.getCarriages()) {
                        System.out.println("  Carriage ID: " + carriage.getId());
                    }
                } else {
                    System.out.println("  No carriages associated with this train.");
                }
                System.out.println(); 
            }
        }
    }
}
