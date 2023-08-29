import java.util.ArrayList;
import java.util.List;

public class Train {
    private int id; 
    public List<Locomotive> locomotives;
    public List<Carriage> carriages;
    
    /**
     * @param id
     */
    public Train(int id){
        this.id = id;
        this.locomotives = new ArrayList<>(); 
        this.carriages = new ArrayList<>();
    }

    /**
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * 
     */
    public List<Locomotive> getLocomotives() {
        return locomotives;
    }

    /**
     * 
     */
    public List<Carriage> getCarriages() {
        return carriages;
    }


    /**
     * 
     */
    public void editTrain(int trainId) {
        /*Implementação */
    }

    /**
     * 
     */
    public static void disassembleTrain(){
        
        /*Scanner in = new Scanner(System.in);
    
        System.out.print("Enter the train ID: ");
        int trainId = in.nextInt();
    
        if (TrainYard.findTrainById(trainId) != null) { 
            System.out.println("The train with id: " + trainId + " was found.");
            for (Train train : TrainYard.getTrains()) {
                if (train.getId() == trainId) {
                    trains.removeTrain();
                }
        } else {
            System.out.println("The train with Id: " + trainId + " was not found.");
        }*/
        
        /*Implementação */
    }
}

