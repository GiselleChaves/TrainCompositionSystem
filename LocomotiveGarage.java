import java.util.ArrayList;
import java.util.List;

public class LocomotiveGarage {

    private List<Locomotive> locomotives = new ArrayList<>(); 

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
     * 
     */
    public List<Locomotive> getLocomotives() {//RETIREI STATIC
        return locomotives;
    }

    /**
     * @param locomotiveId
     */
    public Locomotive findLocomotiveById(int locomotiveId) {
        for (Locomotive locomotive : locomotives) {
            if (locomotive.getId() == locomotiveId) {
                return locomotive;
            }
        }
        return null;
    }
}
