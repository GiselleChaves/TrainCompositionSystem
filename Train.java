import java.util.ArrayList;
import java.util.List;

public class Train {
    private int id; 
    private List<Locomotive> locomotives;
    private List<Carriage> carriages;

    public Train(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public List<Locomotive> getLocomotives() {
        return locomotives;
    }
    public List<Carriage> getCarriages() {
        return carriages;
    }

}
