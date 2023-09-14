import java.util.List;

public class App {
  
  public static void main(String args[]) {
    RailwayCarGarage garage = new RailwayCarGarage();


    garage.addRailwayCar(new Wagon(0, 0, null));

    List<RailwayCar> wagons = garage.getRailwayCarsFromType(Locomotive.class);
  }


}
