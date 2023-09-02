import java.util.ArrayList;
import java.util.List;

public class Train {
    private int id; 
    private List<Locomotive> locomotives;
    private List<Carriage> carriages;
    private CarriageGarage carriageGarage;
    private LocomotiveGarage locomotiveGarage;

    /**
     * @param id
     */
    public Train(int id){
        this.id = id;
        this.locomotives = new ArrayList<>(); 
        this.carriages = new ArrayList<>();
        this.carriageGarage = new CarriageGarage();
        this.locomotiveGarage = new LocomotiveGarage();
    }

    /**
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * 
     */
    public List<Locomotive> getLocomotives() {
        return locomotives;
    }

    /**
     * 
     */
    public List<Carriage> getCarriages() {
        return carriages;
    }

    /**
     * @param carriageId
     * @return
     */
    public boolean addCarriage(int carriageId) {
        if(carriageGarage.isCarriageIdTaken(carriageId)) {
            carriages.add(null);
            return true;
        }
        return false;
    }

    /**
     * @param locomotiveId
     * @return
     */
    public boolean addLocomotive(int locomotiveId) {
        if(locomotiveGarage.isLocomotiveIdTaken(locomotiveId)) {
            carriages.add(null);
            return true;
        }
        return false;
    }

    /**
     * @param carriageId
     * @return
     */
    public boolean removeCarriage(int carriageId) {
        if(carriageGarage.isCarriageIdTaken(carriageId)) {
            carriages.remove(carriageId);
            return true;
        }
        return false;
    }

    /**
     * @param carriageId
     * @return
     */
    public boolean removeLocomotive(int locomotiveId) {
        if(carriageGarage.isCarriageIdTaken(locomotiveId)) {
            locomotives.remove(locomotiveId);
            return true;
        }
        return false;
    }
}
