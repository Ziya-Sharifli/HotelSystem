import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFiles {

    public static String[] listCustomerArray;
    public static String[] listEmployeeArray;
    public static String[] listRoomArray;
    public static String[] listReservationArray;
    public static String[] listSalariesArray;


    public static void readFiles() {

        try {
            listCustomerArray = Files.readAllLines(Paths.get("listOfCustomers.txt")).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            listRoomArray = Files.readAllLines(Paths.get("listOfRooms.txt")).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            listEmployeeArray = Files.readAllLines(Paths.get("listOfEmployees.txt")).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            listReservationArray = Files.readAllLines(Paths.get("listOfReservations.txt")).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            listSalariesArray = Files.readAllLines(Paths.get("listOfSalaries.txt")).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




}
