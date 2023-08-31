import java.util.ArrayList;
import java.util.List;

public class CarriageGarage {

    private List<Carriage> carriages = new ArrayList<>();

    /**
     * @param carriage
     */
    public void addCarriage(Carriage carriage, int id) { //RETIREI STATIC
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
}
