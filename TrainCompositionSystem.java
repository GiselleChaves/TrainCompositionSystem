public class TrainCompositionSystem {
    public static void main(String[] args) {

        TrainYard trainYard = new TrainYard();
        LocomotiveGarage locomotiveGarage = new LocomotiveGarage();
        CarriageGarage carraigeGarage = new CarriageGarage();


        Locomotive loc1 = new Locomotive(1, 100, 2);
        Locomotive loc2 = new Locomotive(2, 50, 1);
        Locomotive loc3 = new Locomotive(3, 300, 5);
        Locomotive loc4 = new Locomotive(4, 170, 4);
        Locomotive loc5 = new Locomotive(5, 200, 3);
      
        LocomotiveGarage.addLocomotive(loc1);
        LocomotiveGarage.addLocomotive(loc2);
        LocomotiveGarage.addLocomotive(loc3);
        LocomotiveGarage.addLocomotive(loc4);
        LocomotiveGarage.addLocomotive(loc5);
    

        RunCode.trainCompositionSystem();
    }  
}