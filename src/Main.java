import java.util.Scanner;

class Flight {
    private String number;
    private String destination;
    private int seats;

    // Constructor
    public Flight(String number, String destination, int seats) {
        this.number = number;
        this.destination = destination;
        this.seats = seats;
    }

    // Getters
    public String getNumber() {
        return number;
    }

    public String getDestination() {
        return destination;
    }

    public int getSeats() {
        return seats;
    }

    // Setters
    public void setNumber(String number) {
        this.number = number;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    // Method to book a seat
    public boolean bookSeat() {
        if (seats > 0) {
            seats--;
            return true;
        }
        return false;
    }
}

class Passenger {
    private String name;
    private String passport;

    // Constructor
    public Passenger(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}

class Booking {
    private Flight flight;
    private Passenger passenger;

    // Constructor
    public Booking(Flight flight, Passenger passenger) {
        this.flight = flight;
        this.passenger = passenger;
    }

    // Method to confirm booking
    public boolean confirm() {
        return flight.bookSeat();
    }

    @Override
    public String toString() {
        return "Booking Details:\n" +
                "Passenger: " + passenger.getName() + " (Passport: " + passenger.getPassport() + ")\n" +
                "Flight: " + flight.getNumber() + " to " + flight.getDestination();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create flights
        Flight flight1 = new Flight("A123", "New York", 5);
        Flight flight2 = new Flight("B456", "London", 3);
        Flight flight3 = new Flight("D341", "Almaty", 8);
        Flight flight4 = new Flight("S920", "Shymkent", 7);

        Flight[] flights = {flight1, flight2, flight3, flight4};

        // Display available flights
        System.out.println("Available Flights:");
        for (int i = 0; i < flights.length; i++) {
            System.out.println((i + 1) + ". " + flights[i].getNumber() + " to " + flights[i].getDestination() + " (Seats: " + flights[i].getSeats() + ")");
        }

        // Select a flight
        System.out.print("Select a flight (1 to 4): ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > flights.length) {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        Flight selectedFlight = flights[choice - 1];

        // Get passenger details
        scanner.nextLine(); // Consume newline
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();

        System.out.print("Enter passport number: ");
        String passport = scanner.nextLine();

        Passenger passenger = new Passenger(name, passport);
        Booking booking = new Booking(selectedFlight, passenger);

        // Confirm booking
        if (booking.confirm()) {
            System.out.println("\nBooking Successful!");
            System.out.println(booking);
        } else {
            System.out.println("\nNo seats available on this flight.");
        }

        scanner.close();
    }
}
