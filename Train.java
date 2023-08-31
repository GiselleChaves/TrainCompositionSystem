import java.util.ArrayList;
import java.util.List;

public class Train {
    private int id; 
    public List<Locomotive> locomotives;
    public List<Carriage> carriages;
    public CarriageGarage carriageGarage;
    public LocomotiveGarage locomotiveGarage;

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
}

