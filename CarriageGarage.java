import java.util.ArrayList;
import java.util.List;

public class CarriageGarage {

    private List<Carriage> carriages = new ArrayList<>();

    /**
     * @param carriage
     */
    public void addCarriage(Carriage carriage) { //RETIREI STATIC
        carriages.add(carriage);
    }

    /**
     * @param carriage
     */
    public void removeCarriage(Carriage carriage) { //RETIREI STATIC
        carriages.remove(carriage);
    }

    /**
     * 
     */
    public List<Carriage> getCarriages() {
        return carriages;
    }

    /**
     * @param idToCheck
     */
    public boolean isCarriageIdTaken(int idToCheck) {

        for(Carriage carriage : getCarriages()){
            if(idToCheck == carriage.getId()){
                return true;
            }
        }
        return false;
    }

    public Carriage findCarriage(int id) {
        for(Carriage carriage : this.carriages) {
            if(carriage.getId() == id) {
                return carriage;
            }
        }
        return null;
    }
}
