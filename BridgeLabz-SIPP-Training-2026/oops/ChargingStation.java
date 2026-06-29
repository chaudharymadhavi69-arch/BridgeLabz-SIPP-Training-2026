class ChargingStation {
    // Static Variables
    static int totalStations = 0;
    static double electricityRate = 8.5; // Rate per unit
    // Instance Variables
    int stationId;
    double unitsConsumed;
    // Constructor
    private ChargingStation(int stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }
    // Calculate Bill
    public double calculateBill() {
        return unitsConsumed * electricityRate;
    }
    // Display Details
    public void displayStationDetails() {
        System.out.println("Station ID      : " + stationId);
        System.out.println("Units Consumed  : " + unitsConsumed);
        System.out.println("Electricity Rate: ₹" + electricityRate);
        System.out.println("Bill Amount     : ₹" + calculateBill());
        System.out.println("----------------------------");
    }
    public static void main(String[] args) {
        // Create 5 stations
        ChargingStation s1 = new ChargingStation(101, 120);
        ChargingStation s2 = new ChargingStation(102, 150);
        ChargingStation s3 = new ChargingStation(103, 180);
        ChargingStation s4 = new ChargingStation(104, 200);
        ChargingStation s5 = new ChargingStation(105, 250);
        // Display bills
        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();
        System.out.println("Total Stations: " + ChargingStation.totalStations);
        // Change electricity rate
        ChargingStation.electricityRate = 10.0;
        System.out.println("\nAfter Electricity Rate Change\n");
        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
    }
}