import java.util.*;
public class ParkingManager {

    static ArrayList<String> vehicles = new ArrayList<>();

    public static void enterVehicle(String number) {
        vehicles.add(number);
        System.out.println(number + " Entered.");
    }

    public static void exitVehicle(String number) {

        if (vehicles.remove(number))
            System.out.println(number + " Exited.");
        else
            System.out.println("Vehicle Not Found.");
    }

    public static void searchVehicle(String number) {

        if (vehicles.contains(number))
            System.out.println("Vehicle is Parked.");
        else
            System.out.println("Vehicle Not Parked.");
    }

    public static void displayVehicles() {

        System.out.println("Parked Vehicles:");

        for (String v : vehicles)
            System.out.println(v);

        System.out.println("Occupied Slots = " + vehicles.size());
    }
    public static void main(String[] args) {

        enterVehicle("HR26AB1234");
        enterVehicle("UP32XY5678");
        enterVehicle("DL01AA1111");

        searchVehicle("UP32XY5678");

        exitVehicle("HR26AB1234");

        displayVehicles();
    }
}