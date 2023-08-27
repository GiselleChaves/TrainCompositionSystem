import java.util.ArrayList;
import java.util.List;

class LocomotiveGarage {
    private List<Locomotive> locomotives; 

    /**
     * 
     */
    public LocomotiveGarage() {
        locomotives = new ArrayList<>();
    }

    /**
     * @param locomotive
     */
    public void addLocomotive(Locomotive locomotive) {
        locomotives.add(locomotive);
    }

    /**
     * @param locomotive
     */
    public void removeLocomotive(Locomotive locomotive) {
        locomotives.remove(locomotive);
    }

    /**
     * @return
     */
    public static  List<Locomotive> getLocomotives() {
        return locomotives;
    }
}
