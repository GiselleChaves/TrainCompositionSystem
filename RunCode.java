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

          switch (editOption) {
              case 1:
                  if (carriageGarage.getCarriages().isEmpty()) {
                      System.out.println("There are no carriages available.");
                  } else {
                      System.out.print("Enter the carriage ID: ");
                      int editCarriageId = in.nextInt();

                      Carriage carriage = carriageGarage.findCarriageById(editCarriageId);

                      if (carriage == null) {
                          System.out.println("Carriage with ID " + editCarriageId + " not found.");
                          return;
                      }

                      if (editTrain.addCarriage(carriage, editTrainId, trainYard)) {
                          System.out.println("The carriage was added");
                      } else {
                          System.out.println("Failed to add the carriage to the train. Check if the locomotive can support the weight of the carriage.");
                      }
                  }
                  break;

              case 2:
                  if (locomotiveGarage.getLocomotives().isEmpty()) {
                      System.out.println("There are no locomotives available.");
                  } else {
                      System.out.print("Enter the locomotive ID: ");
                      int editLocomotiveId = in.nextInt();
                      Locomotive locomotive = locomotiveGarage.findLocomotiveById(editLocomotiveId);

                      if (locomotive == null) {
                          System.out.println("Locomotive with ID " + editLocomotiveId + " not found.");
                          return;
                      }

                      if (editTrain.addLocomotive(locomotive, editTrain)) {
                          System.out.println("The locomotive was added");
                      } else {
                          System.out.println("Failed to add the locomotive to the train. Check if the locomotive can be added to the train.");
                      }
                  }
                  break;
              case 3:
                  if(editTrain.removeLastElement()){
                    System.out.println("The last element was removed from the train.");
                  }
                  else{
                    System.out.println("There are no elements for remove.");
                  }
                  
                  break;
              default:
                  System.out.println("Invalid option.");
                  break;
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

