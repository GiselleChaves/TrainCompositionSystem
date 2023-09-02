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

    public Carriage findCarriageById(int carriageId) { 
        for (Carriage carriage : carriages) {
            if (carriage.getId() == carriageId) {
                return carriage;
            }
        }
        return null;
    }
}
