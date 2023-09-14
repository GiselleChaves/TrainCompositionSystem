import java.util.ArrayList;

abstract public class RailwayCar {
  private int id;
  private Train currentTrain;

  public RailwayCar(int id, Train curreTrain) {
    this.id = id;
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
