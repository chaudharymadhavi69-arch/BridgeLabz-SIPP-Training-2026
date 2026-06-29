abstract class Vehicle {
    abstract double fuelCost(int km);
}
// Car
class Car extends Vehicle {
    @Override
    double fuelCost(int km) {
        return km * 8;     // ₹8 per km
    }
}
// Bus
class Bus extends Vehicle {
    @Override
    double fuelCost(int km) {
        return km * 15;    // ₹15 per km
    }
}
// Bike
class Bike extends Vehicle {
    @Override
    double fuelCost(int km) {
        return km * 3;     // ₹3 per km
    }
}
// New vehicle
class ElectricCar extends Vehicle {
    @Override
    double fuelCost(int km) {
        return km * 4;     // ₹4 per km
    }
}
public class TransportCompany {
    public static void main(String[] args) {
        Vehicle[] fleet = {
                new Car(),
                new Bus(),
                new Bike(),
                new ElectricCar()
        };
        int km = 200;
        for (Vehicle v : fleet) {
            System.out.println("Fuel Cost = ₹" + v.fuelCost(km));
            // instanceof before casting
            if (v instanceof Car) {
                Car c = (Car) v;
                System.out.println("This is a Car");
            }
            else if (v instanceof Bus) {
                Bus b = (Bus) v;
                System.out.println("This is a Bus");
            }
            else if (v instanceof Bike) {
                Bike b = (Bike) v;
                System.out.println("This is a Bike");
            }
            else if (v instanceof ElectricCar) {
                ElectricCar e = (ElectricCar) v;
                System.out.println("This is an Electric Car");
            }
            System.out.println("----------------------");
        }
    }
}