import java.util.HashSet;
import java.util.Set;

abstract public class RailwayCar implements RailwayCarInterface {
  private int id;
  private Train currentTrain;
  private static Set<Integer> usedIds = new HashSet<>(); //Lista que armazena todos já usados.

  public RailwayCar(int id, Train curreTrain) {
    if (usedIds.contains(id)) {
      throw new IllegalArgumentException("Car ID must be unique.");
    }
    this.id = id;
    usedIds.add(id);
    this.currentTrain = null;
  }

  /*
   * @return O ID do CarroFerroviário.
   */
  public int getId() {
    return id;
  }

  /*
  * @return O trem atual associado ao carro.
  */
  public Train getCurrentTrain() {
    return currentTrain;
  }

  /*
  * @param currentTrain O trem atual associado ao carro.
  */
  public void setCurrentTrain(Train currentTrain) {
    this.currentTrain = currentTrain;
  }

  @Override
  public String toString() {
    return "Id:" + id + ", Current Train:" + currentTrain;
  }  
}
