abstract class Vehicle {
    private String vehicleNumber;
    private String vehicleType;

    public Vehicle(String vehicleNumber, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    abstract double calculateRentalCost(int days);

    public void displayVehicleInfo() {
        System.out.println("Vehicle No : " + vehicleNumber);
        System.out.println("Vehicle Type : " + vehicleType);
    }
}

class Car extends Vehicle {
    private double dailyRate;

    public Car(String number, double dailyRate) {
        super(number, "Car");
        this.dailyRate = dailyRate;
    }

    @Override
    double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Bike extends Vehicle {
    private double dailyRate;

    public Bike(String number, double dailyRate) {
        super(number, "Bike");
        this.dailyRate = dailyRate;
    }

    @Override
    double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Truck extends Vehicle {
    private double dailyRate;
    private double loadingCharge;

    public Truck(String number, double dailyRate,
                 double loadingCharge) {
        super(number, "Truck");
        this.dailyRate = dailyRate;
        this.loadingCharge = loadingCharge;
    }

    @Override
    double calculateRentalCost(int days) {
        return (days * dailyRate) + loadingCharge;
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {

        Car car = new Car("CAR101", 1500);
        Bike bike = new Bike("BIKE201", 500);
        Truck truck = new Truck("TRK301", 3000, 2000);

        int days = 5;

        car.displayVehicleInfo();
        System.out.println("Rental Cost = " +
                car.calculateRentalCost(days));

        System.out.println();

        bike.displayVehicleInfo();
        System.out.println("Rental Cost = " +
                bike.calculateRentalCost(days));

        System.out.println();

        truck.displayVehicleInfo();
        System.out.println("Rental Cost = " +
                truck.calculateRentalCost(days));
    }
}