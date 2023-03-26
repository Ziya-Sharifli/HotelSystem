import java.util.Scanner;

public class Advanced {

    public static String advInput;
    public static String[] arrOfInput;

    public static void AdvancedMode() {

        Scanner keyboard = new Scanner(System.in);

        // This is the code for using commands on the terminal, it is meant for advanced users

        while (true) {

            System.out.print("Enter your command: ");
            String tempInput=keyboard.nextLine();
            advInput=tempInput.replaceAll("\\s", "");

            if (advInput.isBlank() || advInput.isEmpty()) {
                AdvancedMode();
            } else {
                break;
            }
        }
        arrOfInput = advInput.split(";");

        switch (arrOfInput[0]) {
            case "listRooms" -> {
                ListCommands.listRoom();
                executedMsg();
            }
            case "listEmployees" -> {
                ListCommands.listEmployee();
                executedMsg();
            }
            case "addRoom" -> {
                Room.addRoom();
                executedMsg();
            }
            case "listCustomers" -> {
                ListCommands.listCustomer();
                executedMsg();
            }
            case "deleteEmployee" -> {
                DeleteEmployee.deleteEmployeeInit();
                executedMsg();
            }
            case "listReservations" -> {
                ListCommands.listReservations();
                executedMsg();
            }
            case "addReservation" -> {
                Reservation.addReservationInit();
                executedMsg();
            }
            case "addCustomer"->{
                Customer.addCustomer();
                executedMsg();
            }
            case "addEmployee"->{
                Employee.addEmployee();
                executedMsg();
            }
            case "searchCustomer"->{
                SearchCustomer.searchCustomerInit();
                executedMsg();
            }
            default -> {
                System.out.println("Unknown command. Please enter C in the Menu for the list of available commands.");
                MainMenu.menuSkip();
                MainMenu.mainMenu();
            }
        }
    }

    public static void executedMsg() {
        System.out.println("Your command has been successfully executed.");
        MainMenu.menuSkip();
        MainMenu.mainMenu();

    }

}
