import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumber {

    public static long lineRooms;
    public static long lineEmployees;
    public static long lineCustomers;
    public static long lineReservations;

    public static void lineNumber() {

        try {
            lineRooms = Files.lines(Paths.get("listOfRooms.txt")).count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            lineEmployees = Files.lines(Paths.get("listOfEmployees.txt")).count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            lineCustomers = Files.lines(Paths.get("listOfCustomers.txt")).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
