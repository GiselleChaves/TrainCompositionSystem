import java.util.Scanner;
import java.util.List;

/*
 * Authors: Giselle Chaves e Ashiley Bianca 
 * Version: Semptember/2023
 * Discilpine: POO
 * Professor: Bernardo Copstein
 */
public class RunCode {
    private Scanner in;
    private TrainYard trainYard;
    private RailwayCarGarage railwayCarGarage;    

    public RunCode() {
        trainYard = new TrainYard();
        in = new Scanner(System.in);
        RailwayCarGarage railwayCarGarage = new RailwayCarGarage();

        /*Locomotive loc1 = new Locomotive(1, 100000, 2);
        Locomotive loc2 = new Locomotive(2, 500000, 2);
        Locomotive loc3 = new Locomotive(3, 3000000, 5);
        Locomotive loc4 = new Locomotive(4, 1700000, 4);
        Locomotive loc5 = new Locomotive(5, 2000000, 3);

        Wagon wag1 = new Wagon(1, 50);
        Wagon wag2 = new Wagon(2, 150);
        Wagon wag3 = new Wagon(3, 650);
        Wagon wag4 = new Wagon(4, 850);
        Wagon wag5 = new Wagon(5, 750);


        locomotiveGarage.addLocomotive(loc1);
        locomotiveGarage.addLocomotive(loc2);
        locomotiveGarage.addLocomotive(loc3);
        locomotiveGarage.addLocomotive(loc4);
        locomotiveGarage.addLocomotive(loc5);

        wagonGarage.addWagon(wag1);
        wagonGarage.addWagon(wag2);
        wagonGarage.addWagon(wag3);
        wagonGarage.addWagon(wag4);
        wagonGarage.addWagon(wag5);*/

        RailwayCar wg1 = new Wagon(1, 700, null);
        RailwayCar wg2 = new Wagon(2, 1000, null);
        RailwayCar wg3 = new Wagon(3, 200, null);

        RailwayCar loc1 = new Locomotive(7, 9000, 5, null);
        RailwayCar loc2 = new Locomotive(8, 8000, 4, null);
        RailwayCar loc3 = new Locomotive(9, 2000, 2, null);

    }

  /**
   * Inicia o sistema de composição de trens e permite que o usuário realize ações.
   */
  public void trainCompositionSystem() {

    int option;

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
          createTrain();
          System.out.println();
          break;

        case 2:
          editTrain(); 
          System.out.println();
          break;

        case 3:
          trainYard.listTrains();
          System.out.println();
          break;

        case 4:
          dismantleTrain();
          System.out.println();
          break;

        case 5:
          System.out.println("Exiting the program.");
          break;

        default:
          System.out.println("Invalid option.");
        }
    } while (option != 5);
  }

  /**
   * Função privada para criar um novo trem com base nas entradas do usuário.
   */
  private void createTrain() {
    System.out.print("Enter the train ID: ");
    int trainId = in.nextInt();

    if (trainYard.findTrainById(trainId) != null) {
        System.out.println("Train with ID " + trainId + " already exists.");
        return;
    }

    System.out.print("Enter the ID of the first locomotive: ");
    int firstLocomotiveId = in.nextInt();

    RailwayCar firstLocomotive = railwayCarGarage.findById(firstLocomotiveId);

    if (firstLocomotive == null) {
    System.out.println("Locomotive with ID " + firstLocomotiveId + " not found.");
    return;
    }

    Train newTrain = new Train(trainId);

    if(newTrain.addLocomotive(firstLocomotive, locomotiveGarage)){
        trainYard.addTrain(newTrain);
        System.out.println("Train " + trainId + " created with locomotive " + firstLocomotiveId + ".");
    }
  }

  /**
   * Função privada para editar um trem existente com base nas entradas do usuário.
   */
  private void editTrain() {
    System.out.print("Enter the train ID: ");
    int editTrainId = in.nextInt();

    Train editTrain = trainYard.findTrainById(editTrainId);

    if (editTrain != null) {
        System.out.println("Train with ID " + editTrainId + " was located.");
        System.out.println();
        int editOption;

        do {
            printEditMenu();
            editOption = in.nextInt();
            
            switch (editOption) {
                case 1:
                    addWagonToTrain(editTrain);
                    System.out.println();
                    break;

                case 2:
                    addLocomotiveToTrain(editTrain);
                    System.out.println();
                    break;

                case 3:
                    removeLastElementFromTrain(editTrain);
                    System.out.println();
                    break;

                case 4:
                    listFreeLocomotives();
                    System.out.println();
                    break;

                case 5:
                    listFreeWagons();
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Exiting 'Edit a train'.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (editOption != 6);
    } else {
        System.out.println("Train with ID " + editTrainId + " doesn't exist."); 
    }  
  }

  /**
   * Função privada para desmontar um trem, liberando locomotivas e vagões e removendo-o do pátio.
   */
  private void dismantleTrain(){

    System.out.print("Enter the train ID: ");
    int dismantleTrainId = in.nextInt();

    Train dismantleTrain = trainYard.findTrainById(dismantleTrainId);

    if (dismantleTrain != null) {
        System.out.println("\nTrain with ID " + dismantleTrainId + " was located.");

        // Liberando as locomotivas do trem e colocando na garagem de locomotivas
        for (Locomotive locomotive : dismantleTrain.getLocomotives()) {
            locomotive.setCurrentTrain(null);
            locomotiveGarage.addLocomotive(locomotive);
        }
        dismantleTrain.getLocomotives().clear();

        // Liberando os vagões do trem e colocando na garagem de vagões
        for (Wagon wagon : dismantleTrain.getWagons()) {
            wagon.setCurrentTrain(null);
            wagonGarage.addWagon(wagon);
        }
        dismantleTrain.getWagons().clear(); 

        // Removendo do pátio.
        trainYard.removeTrain(dismantleTrain);

        System.out.println("Train dismantled.");
    } else {
        System.out.println("Train not found.");
    }
  }

  // Funções utilizadas pelo "editTrain()":

  /**
   * Função privada para imprimir o menu de edição de trens.
   */
  private void printEditMenu() {
      System.out.println("Choose how you want to edit your train.");
      System.out.println("1 - Add a wagon");
      System.out.println("2 - Add a locomotive");
      System.out.println("3 - Remove last element");
      System.out.println("4 - List free locomotives");
      System.out.println("5 - List free wagons");
      System.out.println("6 - Finish editing the train");
      System.out.println();
  }

  /**
   * Função privada para adicionar um vagão a um trem.
   *
   * @param train : O trem ao qual adicionar o vagão.
   */
  private void addWagonToTrain(Train train) {
      System.out.println("Enter with the wagon ID.");
      int idWagonToAdd = in.nextInt();    

      Wagon wagonToAdd = wagonGarage.findWagonById(idWagonToAdd);

      if (wagonToAdd == null) {
          System.out.println("Wagon with ID " + idWagonToAdd + " not available.");
          return;
      }

      if (train.addWagon(wagonToAdd, wagonGarage)) {
          System.out.println("The wagon was added");
      }
  }

  /**
   * Função privada para adicionar uma locomotiva a um trem.
   *
   * @param train : O trem ao qual adicionar a locomotiva.
   */
  private void addLocomotiveToTrain(Train train) {
      System.out.println("Enter with the locomotive ID.");
      int idLocomotiveToAdd = in.nextInt();        

      Locomotive locomotiveToAdd = locomotiveGarage.findLocomotiveById(idLocomotiveToAdd);

      if (locomotiveToAdd == null) {
          System.out.println("Locomotive with ID " + idLocomotiveToAdd+ " not available.");
          return;
      }

      if (train.addLocomotive(locomotiveToAdd, locomotiveGarage)) {
          System.out.println("The locomotive was added");
      }
  }

  /**
   * Função privada para remover o último elemento (vagão ou locomotiva) de um trem.
   *
   * @param train : O trem do qual remover o último elemento.
   */
  private void removeLastElementFromTrain(Train train) {
      if (train.getWagons().isEmpty() && train.getLocomotives().isEmpty()) {
          System.out.println("Sorry, there are no locomotives or wagons to remove from this train.");
      } else {
          if (!train.getWagons().isEmpty()) {
              train.removeLastWagon(wagonGarage);
              System.out.println("Last element removed.");
          } else {
              train.removeLastLocomotive(locomotiveGarage);
              System.out.println("Last element removed.");
          }
      }
  }

  /**
   * Função privada para listar locomotivas disponíveis.
   */
  private void listFreeLocomotives() {
      List<Locomotive> allLocomotives = locomotiveGarage.getLocomotives();

      System.out.println("Free locomotives:");
      System.out.println();

      if (allLocomotives.isEmpty()) {
          System.out.println("Sorry, there are no available locomotives.");
      } else {
          for (Locomotive locomotive : allLocomotives) {
              System.out.println(locomotive.toString());
          }
      }
  }

  /**
   * Função privada para listar vagões disponíveis.
   */
  private void listFreeWagons() {
      List<Wagon> allWagons = wagonGarage.getWagons();

      System.out.println("Free wagons:");
      System.out.println();

      if (allWagons.isEmpty()) {
          System.out.println("Sorry, there are no available wagons.");
      } else {
          for (Wagon wagon : allWagons) {
              System.out.println(wagon.toString());
          }
      }
  }

  //Funções de uso "gráfico"

  /**
   * Imprime uma representação gráfica de um trem.
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

}

