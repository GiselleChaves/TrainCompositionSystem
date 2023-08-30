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

<<<<<<< HEAD
    /**
     * ESTÁ SENDO CRIADA PELA ASHILEY
     */
    public static void createTrain() {

        Scanner in = new Scanner(System.in);
    
        System.out.print("Enter the train ID: ");
        int trainId = in.nextInt();
    
        if (TrainYard.findTrainById(trainId) != null) { 
            System.out.println("Train with ID " + trainId + " already exists.");
            return;
        }
    
        System.out.print("Enter the ID of the first locomotive: ");
        int firstLocomotiveId = in.nextInt();
        
        Locomotive firstLocomotive = Locomotive.findLocomotiveById(firstLocomotiveId);
    
        if (firstLocomotive == null) {
            System.out.println("Locomotive with ID " + firstLocomotiveId + " not found.");
            return;
        }
    
    public static void editTrain() {
        System.out.print("Enter the train ID: ");
        int trainId = in.nextInt();

        if(findTrainById(trainId) != null) {
            System.out.println("Found train!");
        }

    }

        Train newTrain = new Train(trainId);
        newTrain.locomotives.add(firstLocomotive);

        TrainYard.addTrain(newTrain);

        System.out.println("Train " + trainId + " created with locomotive " + firstLocomotiveId + ".");
    }
=======
>>>>>>> main

    /**
     * 
     */
    public void editTrain(int trainId) {
        /*Implementação */
    }

    /**
     * 
     */

    public List<Carriage> getCarriages() {    
        return carriages;
    }

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

