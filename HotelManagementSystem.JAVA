import java.util.ArrayList;
import java.util.Scanner;

class Hotel {
    private int hotelId;
    private String hotelName;
    private String location;
    private int rooms;
    private double roomPrice;

    public Hotel(int hotelId, String hotelName, String location, int rooms, double roomPrice) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.location = location;
        this.rooms = rooms;
        this.roomPrice = roomPrice;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getLocation() {
        return location;
    }

    public int getRooms() {
        return rooms;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public void display() {
        System.out.println("--------------------------------");
        System.out.println("Hotel ID    : " + hotelId);
        System.out.println("Hotel Name  : " + hotelName);
        System.out.println("Location    : " + location);
        System.out.println("Rooms       : " + rooms);
        System.out.println("Room Price  : " + roomPrice);
        System.out.println("--------------------------------");
    }
}

public class HotelManagementSystem {

    static ArrayList<Hotel> hotels = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addHotel() {
        System.out.print("Enter Hotel ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Hotel Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Location: ");
        String location = sc.nextLine();

        System.out.print("Enter Number of Rooms: ");
        int rooms = sc.nextInt();

        System.out.print("Enter Room Price: ");
        double price = sc.nextDouble();

        hotels.add(new Hotel(id, name, location, rooms, price));
        System.out.println("Hotel Added Successfully!");
    }

    public static void displayHotels() {
        if (hotels.isEmpty()) {
            System.out.println("No Hotel Records Found!");
            return;
        }

        for (Hotel hotel : hotels) {
            hotel.display();
        }
    }

    public static void searchHotel() {
        System.out.print("Enter Hotel ID to Search: ");
        int id = sc.nextInt();

        for (Hotel hotel : hotels) {
            if (hotel.getHotelId() == id) {
                hotel.display();
                return;
            }
        }

        System.out.println("Hotel Not Found!");
    }

    public static void updateHotel() {
        System.out.print("Enter Hotel ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Hotel hotel : hotels) {
            if (hotel.getHotelId() == id) {

                System.out.print("Enter New Hotel Name: ");
                hotel.setHotelName(sc.nextLine());

                System.out.print("Enter New Location: ");
                hotel.setLocation(sc.nextLine());

                System.out.print("Enter New Number of Rooms: ");
                hotel.setRooms(sc.nextInt());

                System.out.print("Enter New Room Price: ");
                hotel.setRoomPrice(sc.nextDouble());

                System.out.println("Hotel Updated Successfully!");
                return;
            }
        }

        System.out.println("Hotel Not Found!");
    }

    public static void deleteHotel() {
        System.out.print("Enter Hotel ID to Delete: ");
        int id = sc.nextInt();

        for (Hotel hotel : hotels) {
            if (hotel.getHotelId() == id) {
                hotels.remove(hotel);
                System.out.println("Hotel Deleted Successfully!");
                return;
            }
        }

        System.out.println("Hotel Not Found!");
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== HOTEL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Hotel");
            System.out.println("2. Display Hotels");
            System.out.println("3. Search Hotel");
            System.out.println("4. Update Hotel");
            System.out.println("5. Delete Hotel");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addHotel();
                    break;

                case 2:
                    displayHotels();
                    break;

                case 3:
                    searchHotel();
                    break;

                case 4:
                    updateHotel();
                    break;

                case 5:
                    deleteHotel();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}