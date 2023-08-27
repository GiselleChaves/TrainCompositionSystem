import java.util.Scanner;

public class RunCode {
  static Scanner in = new Scanner(System.in);
  static private int option;
  
  public static void printTrainFigure() {
    System.out.println("--------------------------------------------------");
    System.out.println("\n     e@@@@@@@@@@@@@@@");
    System.out.println("    @@@\"\"\"\"\"\"\"\"\"\"\"\"\"\"");
    System.out.println("   @ ___ ___________");
    System.out.println("  II__[w] | [i] [z] |");
    System.out.println(" {======|_|~~~~~~~~~|");
    System.out.println("/oO--000'\"`-OO---OO-'");

  }

  public static void trainCompositionSystem() {
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
  }
}

