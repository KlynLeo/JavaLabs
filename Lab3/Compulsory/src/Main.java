//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Aircraft a1 = new Airliner("Boeing 747", 46573, 364, 14);
        Aircraft a2 = new Airliner("Boeing 747", 46574, 364, 14);
        Aircraft a3 = new Airliner("Airbus 234", 3467, 250, 12);

        Aircraft f1 = new Freighter("Boeing 50", 46513, 16, 8500);
        Aircraft f2 = new Freighter("Boeing 50", 56513, 16, 8500);
        Aircraft f3 = new Freighter("Boeing 50", 40513, 16, 8500);
        Aircraft f4 = new Freighter("Boeing 50", 16513, 16, 8500);

        Aircraft d1 = new Drone("FT-50", 54, "4 days", 6);

        Aircraft[] cargoPlanes = {f1,f2,f3,f4};
        for (Aircraft plane : cargoPlanes){
            System.out.println(plane.model);
        }

    }
}