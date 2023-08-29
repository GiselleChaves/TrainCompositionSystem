import java.util.ArrayList;
import java.util.List;

public class CarriageGarage {

    private static List<Carriage> carriages = new ArrayList<>();

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
    public static List<Carriage> getCarriages() {
        return carriages;
    }
}
