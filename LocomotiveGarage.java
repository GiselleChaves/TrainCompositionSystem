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

    public Locomotive findLocomotive(int id) {
        for(Locomotive locomotive : this.locomotives) {
            if(locomotive.getId() == id) {
                return locomotive;
            }
        }
        return null;
    }

    /**
     * @param idToCheck
     */
    public boolean isLocomotiveIdTaken(int idToCheck) {

        for(Locomotive locomotive : getLocomotives()){
            if(idToCheck == locomotive.getId()){
                return true;
            }
        }
        return false;
    }
}
