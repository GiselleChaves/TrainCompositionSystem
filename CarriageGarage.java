import java.util.ArrayList;
import java.util.List;

class CarriageGarage {
    private List<Carriage> carriages;

    /**
     * 
     */
    public CarriageGarage() {
        carriages = new ArrayList<>();
    }

    /**
     * @param carriage
     */
    public void addCarriage(Carriage carriage) {
        carriages.add(carriage);
    }

    /**
     * @param carriage
     */
    public void removeCarriage(Carriage carriage) {
        carriages.remove(carriage);
    }

    /**
     * @return
     */
    public List<Carriage> getCarriages() {
        return carriages;
    }
}
