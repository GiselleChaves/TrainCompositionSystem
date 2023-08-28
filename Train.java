import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    private int id; 
    private List<Locomotive> locomotives;
    private List<Carriage> carriages;

    /**
     * @param id
     */
    public Train(int id){
        this.id = id;
    }

    /**
     * ESTÁ SENDO CRIADA PELA ASHILEY
     */
    public static void createTrain() {
        Scanner in = new Scanner(System.in);
    
        System.out.print("Enter the train ID: ");
        int trainId = in.nextInt();
    
        if (findTrainById(trainId) != null) { 
            System.out.println("Train with ID " + trainId + " already exists.");
            return;
        }
    
        System.out.print("Enter the ID of the first locomotive: ");
        int firstLocomotiveId =in.nextInt();
    
        Locomotive firstLocomotive = findLocomotiveById(firstLocomotiveId);
    
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

    /**
     * @return
     */
    public int getId() {
        return id;
    }
    
    /**
     * @return
     */
    public List<Locomotive> getLocomotives() {
        return locomotives;
    }
    
    /**
     * @return
     */
    public List<Carriage> getCarriages() {    
        return carriages;
    }
}
}
