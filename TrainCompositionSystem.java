import java.util.*;

public class TrainCompositionSystem {
    public static void main(String[] args) {
        TrainYard trainYard = new TrainYard();
        LocomotiveGarage locomotiveGarage = new LocomotiveGarage();
        CarriageGarage carraigeGarage = new CarriageGarage();


        RunCode.printTrainFigure();

        RunCode.trainCompositionSystem();




    }  
}

    /*public static void printSeparatorLine() {
        System.out.println("--------------------------------------------------");
    }
    
    public static void printTrainFigure(){
        System.out.println("\n     e@@@@@@@@@@@@@@@");
        System.out.println("    @@@\"\"\"\"\"\"\"\"\"\"\"\"\"\"");
        System.out.println("   @ ___ ___________");
        System.out.println("  II__[w] | [i] [z] |");
        System.out.println(" {======|_|~~~~~~~~~|");
        System.out.println("/oO--000'\"`-OO---OO-'");
    }
    public static void main(String[] args) {

        //** Criar algumas locomotivas e vagões e colocalos nas garagens

        Scanner in = new Scanner (System.in);
        int option;

        do {
            printSeparatorLine();
            System.out.println("Welcome to Train Composition System!");
            printTrainFigure();

            System.out.println("\nOptions:");
            System.out.println("1- Create a train");
            System.out.println("2- Edit a train");
            System.out.println("3- List all trains");
            System.out.println("4- Disassemble a train");
            System.out.println("5- End");
            System.out.print("Choose an option: ");
            option = in.nextInt();

            switch (option) {
                case 1:
                    //createTrain();
                    break;
                case 2:
                    //editTrain();
                    break;
                case 3:
                    //listTrains();
                    break;
                case 4:
                    //disassembleTrain();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (option != 5);

        in.close();
    }

    //Itens do menuzinho
    //1) Função para criar um trem:

    public static Locomotive findLocomotiveById(int locomotiveId) {
        for (Locomotive locomotive : LocomotiveGarage.getLocomotives()) {
            if (locomotive.getId() == locomotiveId) {
                return locomotive;
            }
        }
        return null;
    } OK NA CLASSE

    public static Train findTrainById(int trainId) {
        for (Train train : trainYard.getTrains()) {
                if (train.getId() == trainId) {
                    return train;
                }
        }
        return null; // Não encontrou o trem
    } AJUSTANDO NA CLASSE
    
    
    

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
    
        // Criar trem e a locomotiva dele
        // colocar o trem no patio*/
    
