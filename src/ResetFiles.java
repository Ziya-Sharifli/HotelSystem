import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ResetFiles {

    public static void resetFiles() {

        PrintWriter pw = null;
        try {
            pw = new PrintWriter("listOfCustomers.txt");
            pw = new PrintWriter("listOfSalaries.txt");
            pw = new PrintWriter("listOfEmployees.txt");
            pw = new PrintWriter("listOfRooms.txt");
            pw = new PrintWriter("listOfReservations.txt");
            System.out.println("All files (excl. commands.txt) has been reset successfully.");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        pw.close();


    }

}
