import java.util.Scanner;

class Flight {
    String number;
    String destination;
    int seats;
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Flight flight1 = new Flight();
        flight1.number = "A123";
        flight1.destination = "New York";
        flight1.seats = 5;

        Flight flight2 = new Flight();
        flight2.number = "B456";
        flight2.destination = "London";
        flight2.seats = 3;

        Flight flight3 = new Flight();
        flight3.number = "D341";
        flight3.destination = "Almaty";
        flight3.seats = 8;

        Flight flight4 = new Flight();
        flight4.number = "S920";
        flight4.destination = "Shymkent";
        flight4.seats = 7;


        System.out.println("Available Flights:");
        System.out.println("1. " + flight1.number + " to " + flight1.destination + " (Seats: " + flight1.seats + ")");
        System.out.println("2. " + flight2.number + " to " + flight2.destination + " (Seats: " + flight2.seats + ")");
        System.out.println("3. " + flight3.number + " to " + flight3.destination + " (Seats: " + flight3.seats + ")");
        System.out.println("4. " + flight4.number + " to " + flight4.destination + " (Seats: " + flight4.seats + ")");


        System.out.print("Select a flight (1 to 4): ");
        int choice = scanner.nextInt();

        Flight selectedFlight = null;


        if (choice == 1) {
            selectedFlight = flight1;
        } else if (choice == 2) {
            selectedFlight = flight2;
        } else if (choice == 3) {
            selectedFlight = flight3;
        } else if (choice == 4) {
            selectedFlight = flight4;
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }


        scanner.nextLine();
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();

        System.out.print("Enter passport number: ");
        String passport = scanner.nextLine();


        if (selectedFlight.seats > 0) {
            selectedFlight.seats--;
            System.out.println("\nBooking Successful!");
            System.out.println(name + " (Passport: " + passport + ") booked " +
                    selectedFlight.number + " to " + selectedFlight.destination);
        } else {
            System.out.println("\nNo seats available on this flight.");
        }

        scanner.close();
    }
}