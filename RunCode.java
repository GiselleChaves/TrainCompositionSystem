import java.util.Scanner;

public class RunCode {
  static Scanner in;
  TrainYard trainYard;  //TRAINYARD É UM OBJETO QUE GUARDA LISTA DE TRENS
  static private int option;

  public RunCode() {
    trainYard = new TrainYard();
    in = new Scanner(System.in);
  }
  
  /**
  * 
  */
  public static void printTrainFigure() {
    System.out.println("--------------------------------------------------");
    System.out.println("\n     e@@@@@@@@@@@@@@@");
    System.out.println("    @@@\"\"\"\"\"\"\"\"\"\"\"\"\"\"");
    System.out.println("   @ ___ ___________");
    System.out.println("  II__[w] | [i] [z] |");
    System.out.println(" {======|_|~~~~~~~~~|");
    System.out.println("/oO--000'\"`-OO---OO-'");
  }

  /**
  * 
  */
  public void trainCompositionSystem() {

    do {
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
      option = in.nextInt();

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
          
          Locomotive firstLocomotive = Locomotive.findLocomotiveById(firstLocomotiveId);
      
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
          if (editTrain == null) { 
            System.out.println("Train with ID " + editTrainId + " doesn't exitists.");
            return;
          }else {
            System.out.println("Enter the carriage Id: ");
          }
          
          break;
        case 3:
          TrainYard.listTrains();
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
  }
}

