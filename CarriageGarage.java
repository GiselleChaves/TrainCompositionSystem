import java.util.ArrayList;
import java.util.List;

public class CarriageGarage {

    private static List<Carriage> carriages = new ArrayList<>();

    /**
     * @param carriage
     */
    public static void addCarriage(Carriage carriage) {
        carriages.add(carriage);
    }

    /**
     * @param carriage
     */
    public static void removeCarriage(Carriage carriage) {
        carriages.remove(carriage);
    }

    /**
     * 
     */
    public static List<Carriage> getCarriages() {
        return carriages;
    }
}
