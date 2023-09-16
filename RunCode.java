import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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

        RailwayCar wg1 = new Wagon(1, 700, null);
        RailwayCar wg2 = new Wagon(2, 1000, null);
        RailwayCar wg3 = new Wagon(3, 200, null);

        RailwayCar loc1 = new Locomotive(7, 9000, 5, null);
        RailwayCar loc2 = new Locomotive(8, 8000, 4, null);
        RailwayCar loc3 = new Locomotive(9, 2000, 2, null);

        railwayCarGarage.addRailwayCar(wg1);
        railwayCarGarage.addRailwayCar(wg2);
        railwayCarGarage.addRailwayCar(wg3);
        railwayCarGarage.addRailwayCar(loc1);
        railwayCarGarage.addRailwayCar(loc2);
        railwayCarGarage.addRailwayCar(loc3);

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

    RailwayCar firstCar = railwayCarGarage.findById(firstLocomotiveId);

    if (firstCar == null) {
        System.out.println("Car with ID " + firstLocomotiveId + " not found.");
        return;
    }

    if (firstCar instanceof Locomotive) {
        Locomotive firstLocomotive = (Locomotive) firstCar;

        Train newTrain = new Train(trainId);

        if (newTrain.addLocomotive(firstLocomotive, railwayCarGarage)) {
            trainYard.addTrain(newTrain);
            System.out.println("Train " + trainId + " created with locomotive " + firstLocomotiveId + ".");
        }
    } else {
        System.out.println("Car with ID " + firstLocomotiveId + " is not a locomotive.");
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
    private void dismantleTrain() {
        System.out.print("Enter the train ID: ");
        int dismantleTrainId = in.nextInt();

        Train dismantleTrain = trainYard.findTrainById(dismantleTrainId);

        if (dismantleTrain != null) {
            System.out.println("\nTrain with ID " + dismantleTrainId + " was located.");

            // Coletar todos os RailwayCars do trem
            List<RailwayCar> railwayCars = new ArrayList<>(dismantleTrain.getRailwayCarsFromType(RailwayCar.class));

            // Liberar os RailwayCars do trem
            for (RailwayCar railwayCar : railwayCars) {
                railwayCar.setCurrentTrain(null);
                railwayCarGarage.addRailwayCar(railwayCar);
            }

            // Limpar a lista de RailwayCars do trem
            railwayCars.clear();

            // Remover o trem do pátio.
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

        RailwayCar wagonToAdd = railwayCarGarage.findById(idWagonToAdd);

        if (wagonToAdd == null) {
            System.out.println("Wagon with ID " + idWagonToAdd + " not available.");
            return;
        }

        if(wagonToAdd instanceof Wagon){
            Wagon wagon = (Wagon) wagonToAdd;

            if (train.addWagon(wagon, railwayCarGarage)) {
                System.out.println("The wagon was added");
            }
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

        RailwayCar locomotiveToAdd = railwayCarGarage.findById(idLocomotiveToAdd);

        if (locomotiveToAdd == null) {
            System.out.println("Locomotive with ID " + idLocomotiveToAdd+ " not available.");
            return;
        }

        if(locomotiveToAdd instanceof Locomotive){
            Locomotive locomotive = (Locomotive) locomotiveToAdd;

            if (train.addLocomotive(locomotive, railwayCarGarage)) {
                System.out.println("The locomotive was added");
            }
        }
    }

  /**
   * Função privada para remover o último elemento (vagão ou locomotiva) de um trem.
   *
   * @param train : O trem do qual remover o último elemento.
   */
  private void removeLastElementFromTrain(Train train) {
      if (train.getRailwayCarsFromType(RailwayCar.class).isEmpty()) {
          System.out.println("Sorry, there are no locomotives or wagons to remove from this train.");
      } else {
              train.removeLastElement(railwayCarGarage);
              System.out.println("Last element removed.");
          }
    }

  /**
   * Função privada para listar locomotivas disponíveis.
   */
    private void listFreeLocomotives() {
        List<RailwayCar> allLocomotives = railwayCarGarage.getRailwayCarsFromType(Locomotive.class);

        System.out.println("Free locomotives:");
        System.out.println();

        if (allLocomotives.isEmpty()) {
            System.out.println("Sorry, there are no available locomotives.");
        } else {
            for (RailwayCar car : allLocomotives) {
                if (car instanceof Locomotive) {
                    Locomotive locomotive = (Locomotive) car;
                    System.out.println(locomotive.toString());
                }
            }
        }
    }


  /**
   * Função privada para listar vagões disponíveis.
   */
  private void listFreeWagons() {
    List<RailwayCar> allWagons = railwayCarGarage.getRailwayCarsFromType(Wagon.class);

      System.out.println("Free wagons:");
      System.out.println();

      if (allWagons.isEmpty()) {
          System.out.println("Sorry, there are no available wagons.");
      } else {
        for (RailwayCar car : allWagons) {
            if (car instanceof Wagon) {
                Wagon wagon = (Wagon) car;
                System.out.println(wagon.toString());
            }
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

