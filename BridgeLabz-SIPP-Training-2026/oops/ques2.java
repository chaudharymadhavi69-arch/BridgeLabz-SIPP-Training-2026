class Package {
    private String trackingId;
    private double weight;
    public Package(String trackingId, double weight) {
        this.trackingId = trackingId;
        this.weight = weight;
    }
    public String getTrackingId() {
        return trackingId;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            System.out.println("Invalid Weight!");
        }
    }
}

class ExpressPackage extends Package {
    private String priorityLevel;
    public ExpressPackage(String trackingId, double weight, String priorityLevel) {
        super(trackingId, weight);
        this.priorityLevel = priorityLevel;
    }
    public String getPriorityLevel() {
        return priorityLevel;
    }
    public void printShippingLabel() {
        System.out.println("Tracking ID : " + getTrackingId());
        System.out.println("Weight      : " + getWeight());
        System.out.println("Priority    : " + priorityLevel);
    }
}
public class ques2 {
    public static void main(String[] args) {
        ExpressPackage p1 =
                new ExpressPackage("EXP101", 2.5, "Critical");
        p1.printShippingLabel();
        p1.setWeight(-1.5); // Invalid
        p1.setWeight(0.0);  // Invalid
    }
}