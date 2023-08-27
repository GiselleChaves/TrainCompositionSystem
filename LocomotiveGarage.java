import java.util.ArrayList;
import java.util.List;

class LocomotiveGarage {

    private List<Locomotive> locomotives; 
    //O prof. recomendou fazer com array list 

    public LocomotiveGarage() {
        locomotives = new ArrayList<>();
    }

    public void addLocomotive(Locomotive locomotive) {
        locomotives.add(locomotive);
    }

    public void removeLocomotive(Locomotive locomotive) {
        locomotives.remove(locomotive);
    }

    public static  List<Locomotive> getLocomotives() {
        return locomotives;
    }
}
