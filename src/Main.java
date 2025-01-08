import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

abstract class Flight {
    private String number;
    private String destination;
    private int seats;
    private double price;

    // Constructor
    public Flight(String number, String destination, int seats, double price) {
        this.number = number;
        this.destination = destination;
        this.seats = seats;
        this.price = price;
    }

    // Getters and Setters
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method to book a seat
    public boolean bookSeat(int numberOfSeats) {
        if (seats >= numberOfSeats) {
            seats -= numberOfSeats;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "number='" + number + '\'' +
                ", destination='" + destination + '\'' +
                ", seats=" + seats +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Flight flight = (Flight) obj;
        return number.equals(flight.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}

class DomesticFlight extends Flight {
    public DomesticFlight(String number, String destination, int seats, double price) {
        super(number, destination, seats, price);
    }
}

class InternationalFlight extends Flight {
    public InternationalFlight(String number, String destination, int seats, double price) {
        super(number, destination, seats, price);
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

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Passenger passenger = (Passenger) obj;
        return passport.equals(passenger.passport);
    }

    @Override
    public int hashCode() {
        return passport.hashCode();
    }
}

class Booking {
    private Flight flight;
    private List<Passenger> passengers;
    private double totalPrice;

    // Constructor
    public Booking(Flight flight, List<Passenger> passengers) {
        this.flight = flight;
        this.passengers = passengers;
        this.totalPrice = passengers.size() * flight.getPrice();
    }

    // Confirm Booking
    public boolean confirm() {
        return flight.bookSeat(passengers.size());
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Booking Details:\n" +
                "Passengers: " + passengers + "\n" +
                "Flight: " + flight + "\n" +
                "Total Price: $" + totalPrice;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create flight pool
        List<Flight> flights = new ArrayList<>();
        flights.add(new DomesticFlight("A123", "New York", 5, 200.0));
        flights.add(new InternationalFlight("B456", "London", 3, 500.0));
        flights.add(new DomesticFlight("D341", "Almaty", 8, 150.0));
        flights.add(new DomesticFlight("S920", "Shymkent", 7, 100.0));

        // Display available flights
        System.out.println("Available Flights:");
        for (int i = 0; i < flights.size(); i++) {
            System.out.println((i + 1) + ". " + flights.get(i));
        }

        // Select a flight
        System.out.print("Select a flight (1 to " + flights.size() + "): ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > flights.size()) {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        Flight selectedFlight = flights.get(choice - 1);

        // Enter number of passengers
        System.out.print("Enter the number of passengers: ");
        int numberOfPassengers = scanner.nextInt();
        if (numberOfPassengers <= 0) {
            System.out.println("Invalid number of passengers.");
            scanner.close();
            return;
        }

        scanner.nextLine(); // Consume newline
        List<Passenger> passengers = new ArrayList<>();

        for (int i = 0; i < numberOfPassengers; i++) {
            System.out.print("Enter name for passenger " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter passport number for passenger " + (i + 1) + ": ");
            String passport = scanner.nextLine();
            passengers.add(new Passenger(name, passport));
        }

        Booking booking = new Booking(selectedFlight, passengers);

        // Confirm booking
        if (booking.confirm()) {
            System.out.println("\nBooking Successful!");
            System.out.println(booking);

            // Payment
            System.out.print("\nEnter card number for payment: ");
            String cardNumber = scanner.nextLine();
            System.out.println("Payment of $" + booking.getTotalPrice() + " received. Thank you!");
        } else {
            System.out.println("\nNot enough seats available on this flight.");
        }

        scanner.close();
    }
}
