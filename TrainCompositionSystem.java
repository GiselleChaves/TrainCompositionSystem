public class TrainCompositionSystem {
    public static void main(String[] args) {
        RunCode runCode = new RunCode();
        /*runCode.trainCompositionSystem();*/
        
        RailwayCar wg1 = new Wagon(1, 700, null);
        RailwayCar loc1 = new Locomotive(7, 9000, 5, null);
        System.out.println(wg1.toString());
        System.out.println(loc1);
    }
}
