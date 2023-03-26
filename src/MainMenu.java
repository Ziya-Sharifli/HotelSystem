import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class MainMenu {

    static Scanner keyboard = new Scanner(System.in);

    static String menuChoice;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void mainMenu() {




        while (true) {

            System.out.println(ANSI_YELLOW + "== DEUCENG Hotel Management System v1.0 (beta) ==" + ANSI_RESET);
            System.out.println(ANSI_CYAN+"\nWhat would you like to do?"+ANSI_RESET);
            System.out.println(ANSI_BLUE+"1. Add a room to the system");
            System.out.println("2. List rooms");
            System.out.println("3. Add employee to the system");
            System.out.println("4. List employees");
            System.out.println("5. Delete an employee from the system");
            System.out.println("6. Add a customer to the system");
            System.out.println("7. List customers");
            System.out.println("8. Add a reservation");
            System.out.println("9. List reservations");
            System.out.println("10. Statistics"+ANSI_RESET);
            System.out.println(ANSI_RED+"\n***** Advanced *****"+ANSI_RESET);
            System.out.println(ANSI_PURPLE+"11. Read & execute all commands from commands.txt");
            System.out.println("12. Reset all text files");
            System.out.println("0. Advanced user mode (manual command entry)");
            System.out.println("Enter Q for quitting"+ANSI_RESET);
            System.out.print("\n-> ");

            menuChoice = keyboard.next();

            switch (menuChoice) {

                case "1":
                    Room.addRoom();
                    menuSkip();
                    mainMenu();
                case "2":
                    ListCommands.listRoom();
                    menuSkip();
                    mainMenu();
                case "3":
                    Employee.addEmployee();
                    menuSkip();
                    mainMenu();
                case "4":
                    ListCommands.listEmployee();
                    menuSkip();
                    mainMenu();
                case "5":
                    DeleteEmployee.deleteEmployeeInit();
                    menuSkip();
                    mainMenu();
                case "6":
                    Customer.addCustomer();
                    menuSkip();
                    mainMenu();
                case "7":
                    ListCommands.listCustomer();
                    menuSkip();
                    mainMenu();
                case "8":
                    Reservation.addReservationInit();
                    menuSkip();
                    mainMenu();
                case "9":
                    ListCommands.listReservations();
                    menuSkip();
                    mainMenu();
                case "10":
                    Statistics.mostReserved();
                    Statistics.bestCustomer();
                    Statistics.getExpenses();
                    menuSkip();
                    mainMenu();
                case "11":
                    AdvancedRead.advancedRead();
                    menuSkip();
                    mainMenu();
                case "12":
                    ResetFiles.resetFiles();
                    menuSkip();
                    mainMenu();
                case "0":
                    Advanced.AdvancedMode();
                    menuSkip();
                    mainMenu();
                case "C","c":
                    commands();
                    menuSkip();
                    mainMenu();
                case "q","Q":
                    System.out.println("The program has been stopped. Thank you for using DEUCENG Hotel software.");
                    System.exit(0);
            }
        }
    }

    public static void menuSkip() {

        try {
            System.out.print("Press ENTER to go back to the Main Menu -> ");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Error 1: Java IOEXCEPTION");
        }
    }
    public static void commands(){
        String[] commands1;
        try {
            commands1 = Files.readAllLines(Paths.get("commands.txt")).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < commands1.length; i++) {

            System.out.println(commands1[i]);


        }
    }
}
