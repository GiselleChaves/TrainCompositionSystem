import java.util.ArrayList;
import java.util.List;

public class RailwayCarGarage {
  private ArrayList<RailwayCar> railwayCars;

  public RailwayCarGarage() {
    railwayCars = new ArrayList<>();
  }

  /**
   * @param Adiciona o Carro Ferroviário à garagem.
   */
  public void addRailwayCar(RailwayCar car) {
    railwayCars.add(car);
  }

  /**
  * @param O Carro Ferroviário será removido da garagem.
  */
  public void removeRailwayCar(RailwayCar car) {
    railwayCars.remove(car);
  }

  /**
     * @return Uma lista de vagões na garagem.
     */
    public List<RailwayCar> getWagons() {
      List<RailwayCar> wagons = new ArrayList<RailwayCar>();
      for(RailwayCar rc : railwayCars) {
        if(rc instanceof Wagon) {
          wagons = (List<RailwayCar>) rc;
        }
      }
      return wagons;
    }

  /**
   * @param int id 
   * @return O Carro Ferroviário com o ID correspondente ou null se não encontrado.
   */
  public RailwayCar findById(int id) {
    for (RailwayCar rc : railwayCars) {
        if (rc.getId() == id) {
            return rc;
        }
    }
    return null;
  }
}
