abstract class Employee {
    private int employeeId;
    private String employeeName;

    public Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    abstract double calculateSalary();

    public void displayEmployeeInfo() {
        System.out.println("ID : " + employeeId);
        System.out.println("Name : " + employeeName);
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(int id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name,
                            int hoursWorked, double hourlyRate) {
        super(id, name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

public class PayrollSystem {
    public static void main(String[] args) {

        FullTimeEmployee ft =
                new FullTimeEmployee(101, "Rahul", 50000);

        PartTimeEmployee pt =
                new PartTimeEmployee(102, "Priya", 80, 300);

        ft.displayEmployeeInfo();
        System.out.println("Salary = " + ft.calculateSalary());

        System.out.println();

        pt.displayEmployeeInfo();
        System.out.println("Salary = " + pt.calculateSalary());
    }
}