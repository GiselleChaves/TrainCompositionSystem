import java.util.ArrayList;
import java.util.List;

class CarriageGarage {

    private List<Carriage> carriages;
    //O prof. recomendou fazer com array list 

    public CarriageGarage() {
        carriages = new ArrayList<>();
    }

    public void addCarriage(Carriage carriage) {
        carriages.add(carriage);
    }

    public void removeCarriage(Carriage carriage) {
        carriages.remove(carriage);
    }

    public List<Carriage> getCarriages() {
        return carriages;
    }
}
