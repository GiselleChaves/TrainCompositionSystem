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
  * @return Uma lista do tipo passado por parâmetro (Locomotive ou Wagon) que estão na garagem.
  */
  public List<RailwayCar> getRailwayCarsFromType(Class<?> type) {
    List<RailwayCar> list = new ArrayList<RailwayCar>();
    for(RailwayCar railwayCar : railwayCars) {
      if(type.isInstance(railwayCar)) {
        list.add(railwayCar);
      }
    }
    return list;
  }

  /**
   * @param int id 
   * @return O Carro Ferroviário com o ID correspondente ou null se não encontrado.
   */
  public RailwayCar findById(int id) {
    for (RailwayCar railwayCar : railwayCars) {
        if (railwayCar.getId() == id) {
            return railwayCar;
        }
    }
    return null;
  }
}
