import java.util.*;

class Reservation {
    private String customerName;
    private int roomNumber;

    public Reservation(String customerName, int roomNumber) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " reserved by " + customerName;
    }
}

class Hotel {
    private Map<Integer, Reservation> reservations = new HashMap<>();
    private int totalRooms;

    public Hotel(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public void reserveRoom(String customerName, int roomNumber) {
        if (roomNumber < 1 || roomNumber > totalRooms) {
            System.out.println("❌ Invalid room number.");
            return;
        }
        if (reservations.containsKey(roomNumber)) {
            System.out.println("❌ Room " + roomNumber + " is already reserved.");
            return;
        }
        Reservation res = new Reservation(customerName, roomNumber);
        reservations.put(roomNumber, res);
        System.out.println("✅ " + res);
    }

    public void cancelReservation(int roomNumber) {
        if (reservations.containsKey(roomNumber)) {
            reservations.remove(roomNumber);
            System.out.println("✅ Reservation for room " + roomNumber + " canceled.");
        } else {
            System.out.println("❌ No reservation found for room " + roomNumber);
        }
    }

    public void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations yet.");
            return;
        }
        System.out.println("--- Current Reservations ---");
        for (Reservation res : reservations.values()) {
            System.out.println(res);
        }
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of rooms in the hotel: ");
        int totalRooms = sc.nextInt();

        Hotel hotel = new Hotel(totalRooms);

        while (true) {
            System.out.println("\n--- Hotel Reservation Menu ---");
            System.out.println("1. Reserve a Room");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. View All Reservations");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter room number: ");
                    int room = sc.nextInt();
                    hotel.reserveRoom(name, room);
                }
                case 2 -> {
                    System.out.print("Enter room number to cancel: ");
                    int room = sc.nextInt();
                    hotel.cancelReservation(room);
                }
                case 3 -> hotel.viewReservations();
                case 4 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
