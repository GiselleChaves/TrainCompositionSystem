import java.util.ArrayList;
import java.util.List;

public class LocomotiveGarage {

    private static List<Locomotive> locomotives = new ArrayList<>(); 

    /**
     * @param locomotive
     */
    public static void addLocomotive(Locomotive locomotive) {
        locomotives.add(locomotive);
    }


    /**
     * @param locomotive
     */
    public static void removeLocomotive(Locomotive locomotive) {
        locomotives.remove(locomotive);
    }

    /**
     * 
     */
    public static List<Locomotive> getLocomotives() {
        return locomotives;
    }
}
