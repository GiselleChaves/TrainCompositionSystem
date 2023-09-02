import java.util.ArrayList;
import java.util.List;

public class Train {

    private int id; 
    public List<Locomotive> locomotives;
    public List<Carriage> carriages;
    public CarriageGarage carriageGarage;
    public LocomotiveGarage locomotiveGarage;
    public int maxCapacityOfCarriagesInTrain;
    public double maxWeightCapacityOfTrain;
    
    private static final int MAX_LOCOMOTIVES = 5; // Número máximo de locomotivas
    private static final int MAX_LOCOMOTIVES_WITHOUT_REDUCTION = 2; // Número máximo de locomotivas
    private static final int MAX_CARRIAGES_PER_LOCOMOTIVE = 50; // Número máximo de vagões por locomotiva
    private static final double LOCOMOTIVE_CAPACITY_REDUCTION = 0.10; // Redução de capacidade a cada nova locomotiva


    /**
     * @param id
     */
    public Train(int id){
        this.id = id;
        this.locomotives = new ArrayList<>(); 
        this.carriages = new ArrayList<>();
        this.carriageGarage = new CarriageGarage();
        this.locomotiveGarage = new LocomotiveGarage();
        this.maxCapacityOfCarriagesInTrain = 0;
        this.maxWeightCapacityOfTrain = 0;
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

    public boolean addLocomotive(Locomotive locomotive, Train train) {

        if (locomotives.size() >= MAX_LOCOMOTIVES) {
            System.out.println("The maximum number of locomotives for this train has been reached.");
            return false;
        }

        if(locomotive.getCurrentTrain() != null){
            System.out.println("Sorry, that locomotive is already added to a train.");
            return false;
        }

        else{

            if(carriages.size() != 0){
                System.out.println("Sorry, you cannot insert a locomotive after a carriage.");
                return false;
            }

            double generalMaxCapacityOfCarriages = 0;
            int numberOfLocomotives = 0;

            for(Locomotive loc : locomotives){
                numberOfLocomotives++;
                generalMaxCapacityOfCarriages += loc.getMaxNumCarriages();

                if(numberOfLocomotives >= MAX_LOCOMOTIVES_WITHOUT_REDUCTION){
                    generalMaxCapacityOfCarriages = (int) (generalMaxCapacityOfCarriages - (generalMaxCapacityOfCarriages * LOCOMOTIVE_CAPACITY_REDUCTION));
                    maxCapacityOfCarriagesInTrain = (int) (generalMaxCapacityOfCarriages);
                }
            }

            locomotive.setCurrentTrain(train);
            locomotives.add(locomotive);

            return true;
        }
    }

    public double maxWeightCapacityOfTrain(){

        double maxWeightCapacity = 0;

        for(Locomotive loc: locomotives){
            maxWeightCapacity += loc.getMaxWeight();
        }
        return maxWeightCapacity;
    }

    public double availableWeight(){

        double locomotivesInTrainWeight = 0;
        double carriagesInTrainWeight = 0;

        for(Locomotive loc: locomotives){
            locomotivesInTrainWeight += loc.getMaxWeight();
        }

        for(Carriage car: carriages){
            carriagesInTrainWeight += car.getMaxCapacity();
        }

        double unavailableWeight = locomotivesInTrainWeight + carriagesInTrainWeight;

        return maxWeightCapacityOfTrain() - unavailableWeight;
    }

    public boolean addCarriage(Carriage carriage, int trainId, TrainYard trainYard) {
        
        if (locomotives.isEmpty()) {
            System.out.println("Sorry, you cannot insert a carriage before a locomotive.");
            return false;
        }



        if(maxCapacityOfCarriagesInTrain == carriages.size()){
            System.out.println("The maximum number of carriages for this train has been reached.");
        }

        if(availableWeight() >= carriage.getMaxCapacity()){
            Train train = trainYard.findTrainById(trainId);
            carriage.setCurrentTrain(train);
            carriages.add(carriage);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean removeLastElement(){
        if (!carriages.isEmpty()){
            Carriage lastElement = carriages.get(carriages.size() - 1);
            lastElement.setCurrentTrain(null);
            carriages.remove(carriages.size() - 1);
            return true;
        }
        else{
            if(!locomotives.isEmpty()){
                Carriage lastElement = carriages.get(carriages.size() - 1);
                lastElement.setCurrentTrain(null);
                carriages.remove(carriages.size() - 1);
                return true;


            }
        }
        return false;
    }
}


