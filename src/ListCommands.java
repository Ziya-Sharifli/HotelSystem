import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListCommands {

    public static void listCustomer() {

        String[] listCustomerArray;
        try {
            listCustomerArray = Files.readAllLines(Paths.get("listOfCustomers.txt")).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < listCustomerArray.length; i++) {

            System.out.println(listCustomerArray[i]);

        }
    }

    public static void listEmployee() {

        String[] listEmployeeArray;
        try {
            listEmployeeArray = Files.readAllLines(Paths.get("listOfEmployees.txt")).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < listEmployeeArray.length; i++) {

            System.out.println(listEmployeeArray[i]);

        }
    }

    public static void listRoom() {

        String[] listRoomArray;
        try {
            listRoomArray = Files.readAllLines(Paths.get("listOfRooms.txt")).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < listRoomArray.length; i++) {

            System.out.println(listRoomArray[i]);
        }
    }

    public static void listReservations() {

        String[] listReservationArray;
        try {
            listReservationArray = Files.readAllLines(Paths.get("listOfReservations.txt")).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < listReservationArray.length; i++) {

            System.out.println(listReservationArray[i]);

        }
    }
}
