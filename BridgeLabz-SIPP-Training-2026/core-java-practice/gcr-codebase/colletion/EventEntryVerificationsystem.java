import java.util.HashSet;
import java.util.Scanner;

public class EventEntryVerificationsystem {

    public static void main(String[] args) {

        HashSet<String> participants = new HashSet<>();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Event Entry Verification System =====");
            System.out.println("1. Register Participant");
            System.out.println("2. Display Participants");
            System.out.println("3. Total Eligible Attendees");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Email ID: ");
                    String email = sc.nextLine();

                    if (participants.add(email)) {
                        System.out.println("Registration Successful.");
                    } else {
                        System.out.println("Duplicate Registration! Entry Rejected.");
                    }

                    break;

                case 2:

                    if (participants.isEmpty()) {
                        System.out.println("No participants registered.");
                    } else {
                        System.out.println("\nRegistered Participants:");

                        for (String p : participants) {
                            System.out.println(p);
                        }
                    }

                    break;

                case 3:

                    System.out.println("Total Eligible Attendees = "
                            + participants.size());

                    break;

                case 4:

                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");
            }

        }

    }

}