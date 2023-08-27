import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        Train newTrain = new Train(trainId);
        newTrain.locomotives.add(firstLocomotive);

        TrainYard.addTrain(newTrain);

        System.out.println("Train " + trainId + " created with locomotive " + firstLocomotiveId + ".");
    }

    /**
     * 
     */
    public static void editTrain() {
        /*Implementação */
    }

    /**
     * 
     */
    public static void disassembleTrain(){
        /*Implementação */
    }
}

