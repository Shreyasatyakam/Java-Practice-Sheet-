import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Flight class
class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private int totalSeats;
    private int bookedSeats;

    public Flight(String flightNumber, String origin, String destination, int totalSeats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public boolean bookSeat() {
        if (bookedSeats < totalSeats) {
            bookedSeats++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Flight: " + flightNumber +
               ", From: " + origin +
               ", To: " + destination +
               ", Seats: " + bookedSeats + "/" + totalSeats;
    }
}

// Main system
public class FlightReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Flight> flights = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Flight Reservation System ---");
            System.out.println("1. Add Flight");
            System.out.println("2. Book Seat");
            System.out.println("3. View Flights");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter flight number: ");
                    String number = sc.nextLine();
                    System.out.print("Enter origin: ");
                    String origin = sc.nextLine();
                    System.out.print("Enter destination: ");
                    String dest = sc.nextLine();
                    System.out.print("Enter total seats: ");
                    int seats = sc.nextInt();
                    sc.nextLine(); // consume newline

                    flights.add(new Flight(number, origin, dest, seats));
                    System.out.println("Flight added successfully!");
                }
                case 2 -> {
                    System.out.print("Enter flight number to book seat: ");
                    String number = sc.nextLine();
                    boolean found = false;
                    for (Flight f : flights) {
                        if (f.getFlightNumber().equalsIgnoreCase(number)) {
                            found = true;
                            if (f.bookSeat())
                                System.out.println("Seat booked successfully!");
                            else
                                System.out.println("No seats available!");
                            break;
                        }
                    }
                    if (!found) System.out.println("Flight not found!");
                }
                case 3 -> {
                    if (flights.isEmpty()) System.out.println("No flights available.");
                    else flights.forEach(System.out::println);
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
