import java.util.Scanner;

public class RunCode {
    private Scanner in;
    private TrainYard trainYard;
    private CarriageGarage carriageGarage; // Declare instância global
    private LocomotiveGarage locomotiveGarage; // Declare instância global

    public RunCode() {
        trainYard = new TrainYard();
        in = new Scanner(System.in);
        carriageGarage = new CarriageGarage(); // Inicialize instância global
        locomotiveGarage = new LocomotiveGarage(); // Inicialize instância global

        Locomotive loc1 = new Locomotive(1, 100, 2, locomotiveGarage);
        Locomotive loc2 = new Locomotive(2, 50, 1, locomotiveGarage);
        Locomotive loc3 = new Locomotive(3, 300, 5, locomotiveGarage);
        Locomotive loc4 = new Locomotive(4, 170, 4, locomotiveGarage);
        Locomotive loc5 = new Locomotive(5, 200, 3, locomotiveGarage);
      
        Carriage car1 = new Carriage(1, 50, carriageGarage);
        Carriage car2 = new Carriage(2, 150, carriageGarage);
        Carriage car3 = new Carriage(3, 350, carriageGarage);
        Carriage car4 = new Carriage(3, 350, carriageGarage);
        Carriage car5 = new Carriage(3, 350, carriageGarage);


        locomotiveGarage.addLocomotive(loc1);
        locomotiveGarage.addLocomotive(loc2);
        locomotiveGarage.addLocomotive(loc3);
        locomotiveGarage.addLocomotive(loc4);
        locomotiveGarage.addLocomotive(loc5);

        carriageGarage.addCarriage(car1);
        carriageGarage.addCarriage(car2);
        carriageGarage.addCarriage(car3);
        carriageGarage.addCarriage(car4);
        carriageGarage.addCarriage(car5);
    }

    public void run() {
        int option;
        do {
            printMenu();
            option = in.nextInt();
            in.nextLine(); // Limpar a nova linha deixada pelo nextInt()
            processOption(option);
        } while (option != 5);
    }

    private void printMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println("Welcome to Train Composition System!");
        printTrainFigure();

        System.out.println("\nOptions:");
        System.out.println("1- Create a train");
        System.out.println("2- Edit a train");
        System.out.println("3- List all trains");
        System.out.println("4- Disassemble a train");
        System.out.println("5- End");
        System.out.print("Choose an option: ");
    }

    public static void printTrainFigure() {
      System.out.println("--------------------------------------------------");
      System.out.println("\n     e@@@@@@@@@@@@@@@");
      System.out.println("    @@@\"\"\"\"\"\"\"\"\"\"\"\"\"\"");
      System.out.println("   @ ___ ___________");
      System.out.println("  II__[w] | [i] [z] |");
      System.out.println(" {======|_|~~~~~~~~~|");
      System.out.println("/oO--000'\"`-OO---OO-'");
    }
  
    private void processOption(int option) {
        switch (option) {
            case 1:
                createTrain();
                break;
            case 2:
                editTrain();
                break;
            case 3:
                trainYard.listTrains();
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
    }

    private void createTrain() {
      System.out.print("Enter the train ID: ");
      int trainId = in.nextInt();
  
      if (trainYard.findTrainById(trainId) != null) {
          System.out.println("Train with ID " + trainId + " already exists.");
          return;
      }
  
      System.out.print("Enter the ID of the first locomotive: ");
      int firstLocomotiveId = in.nextInt();
  
      Locomotive firstLocomotive = locomotiveGarage.findLocomotiveById(firstLocomotiveId);
  
      if (firstLocomotive == null) {
          System.out.println("Locomotive with ID " + firstLocomotiveId + " not found.");
          return;
      }
  
      Train newTrain = new Train(trainId);
      newTrain.locomotives.add(firstLocomotive);
  
      trainYard.addTrain(newTrain);
  
      System.out.println("Train " + trainId + " created with locomotive " + firstLocomotiveId + ".");
  }
  
  private void editTrain() {

      System.out.print("Enter the train ID: ");
      int editTrainId = in.nextInt();

      Train editTrain = trainYard.findTrainById(editTrainId);

      if (editTrain != null) {
          System.out.println("Train with ID " + editTrainId + " was located.");
          System.out.println("Choose how you want to edit your train.");
          System.out.println("1 - Add a carriage");
          System.out.println("2 - Add a locomotive");
          System.out.println("3 - Remove last element");
          System.out.println("4 - Get free locomotives");
          System.out.println("5 - Finish editing the train");
          int editOption = in.nextInt();

      switch (option) {
        case 1:
          //Train.createTrain();
          System.out.print("Enter the train ID: ");
          int trainId = in.nextInt();
      
          if (trainYard.findTrainById(trainId) != null) { 
              System.out.println("Train with ID " + trainId + " already exists.");
              return;
          }
      
          System.out.print("Enter the ID of the first locomotive: ");
          int firstLocomotiveId = in.nextInt();
          
          Locomotive firstLocomotive = train.findLocomotive(firstLocomotiveId);
      
          if (firstLocomotive == null) {
              System.out.println("Locomotive with ID " + firstLocomotiveId + " not found.");
              return;
          }

          Train newTrain = new Train(trainId);
          newTrain.locomotives.add(firstLocomotive);

          trainYard.addTrain(newTrain);

          System.out.println("Train " + trainId + " created with locomotive " + firstLocomotiveId + ".");
          break;
        case 2:
          //editTrain();
          System.out.print("Enter the train ID: ");
          int editTrainId = in.nextInt();
      
          Train editTrain = trainYard.findTrainById(editTrainId);
          if (editTrain != null) { 
            System.out.println("Train with ID " + editTrainId + " was located.");
            System.out.println("Enter with the object that must be added in the train");
            System.out.println("1 - For Carriage");
            System.out.println("2 - For Locomotive");
            int editOption=in.nextInt();
            switch(editOption) {
              case 1:
                  if (carriageGarage.getCarriages().isEmpty()) {
                      System.out.println("There are no carriages available.");
                  } else {
                      System.out.print("Enter the carriage ID: ");
                      int editCarriageId = in.nextInt();

                //TESTE SE A LOCOMOTIVA SUPORTA O PESO DO VAGÃO                
                
                if(editTrain.addCarriage(editCarriageId)) {
                  System.out.println("The carriage was added");
                }
                break;
              case 2:
                System.out.println("Enter with the locomotive ID.");
                int editLocomotiveId = in.nextInt();               
                
                if(editTrain.addLocomotive(editLocomotiveId)) {
                  System.out.println("The locomotive was added");
                }
                break;
            }
          } else {
            System.out.println("Train with ID " + editTrainId + " doesn't exitists."); 
          }        
        case 3:
          trainYard.listTrains();
          break;
        case 4:
          //disassembleTrain();
          System.out.print("Enter the train ID: ");
          int disassembleTrainId = in.nextInt();
      
          Train disassembleTrain = trainYard.findTrainById(disassembleTrainId);
          if (disassembleTrain != null) { 
            System.out.println("Train with ID " + disassembleTrainId + " was located.");
            System.out.println("Enter the object that must be removed from the train");
            System.out.println("1 - For Carriage");
            System.out.println("2 - For Locomotive");
            int disassembleOption=in.nextInt();
            switch(disassembleOption) {
              case 1:
                System.out.println("Enter with the carriage ID.");
                int disassembleCarriageId = in.nextInt();

                //TESTE SE A LOCOMOTIVA SUPORTA O PESO DO VAGÃO                
                
                if(disassembleTrain.removeCarriage(disassembleCarriageId)) {
                  System.out.println("The carriage was removed");
                }
                break;
              case 2:
                System.out.println("Enter with the locomotive ID.");
                int disassembleLocomotiveId = in.nextInt();               
                
                if(disassembleTrain.removeLocomotive(disassembleLocomotiveId)) {
                  System.out.println("The locomotive was added");
                }
                break;
            }
          }
      } else {
          System.out.println("Train with ID " + editTrainId + " doesn't exist.");
      }
    }

    public static void main(String[] args) {
        RunCode program = new RunCode();
        program.run();
    }
}

