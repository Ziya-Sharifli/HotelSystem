import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class AdvancedRead {

    public static void advancedRead() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("commands.txt"));
            String line = reader.readLine();

            while (line != null) {

                String[] arrOfCommands = line.split(";");

                if (line.contains("listRooms")) {
                    System.out.println("--------------------------------------------------------------------");
                    ListCommands.listRoom();
                    System.out.println("--------------------------------------------------------------------");
                }
                if (line.contains("listEmployees")) {
                    System.out.println("--------------------------------------------------------------------");
                    ListCommands.listEmployee();
                    System.out.println("--------------------------------------------------------------------");
                }
                if (line.contains("listCustomers")) {
                    System.out.println("--------------------------------------------------------------------");
                    ListCommands.listCustomer();
                }
                if (line.contains("listReservations")) {
                    System.out.println("--------------------------------------------------------------------");
                    ListCommands.listReservations();
                    System.out.println("--------------------------------------------------------------------");
                }
                if (line.contains("addRoom")) {

                    Room.numberOfRooms = Integer.parseInt(arrOfCommands[1]);
                    Room.roomType = arrOfCommands[2];
                    Room.roomType = Room.roomType.substring(0, 1).toUpperCase() + Room.roomType.substring(1);
                    Room.airCon = arrOfCommands[3];
                    Room.airCon = Room.airCon.substring(0, 1).toUpperCase() + Room.airCon.substring(1);
                    if (Room.airCon.equals("True")) {
                        Room.airCon = "AirCondition";
                    }
                    if (Room.airCon.equals("False")) {
                        Room.airCon = "No-Aircondition";
                    }
                    Room.balcony = arrOfCommands[4];
                    Room.balcony = Room.balcony.substring(0, 1).toUpperCase() + Room.balcony.substring(1);
                    if (Room.balcony.equals("True")) {
                        Room.balcony = "Balcony";
                    }
                    if (Room.balcony.equals("False")) {
                        Room.balcony = "No-Balcony";
                    }
                    Prices.prices = Integer.parseInt(arrOfCommands[5]);
                    Room.roomFile();

                }
                if (line.contains("addEmployee")) {

                    Employee.name = arrOfCommands[1];
                    Employee.surname = arrOfCommands[2];
                    Employee.gender = arrOfCommands[3].substring(0,1).toUpperCase()+arrOfCommands[3].substring(1);
                    Employee.birthdate = arrOfCommands[4];
                    if (Employee.birthdate.length() == 8) {
                        Employee.birthdate = "0" + Employee.birthdate.substring(0,2) + "0" + Employee.birthdate.substring(2);
                    } else if (Employee.birthdate.length() == 9 && Employee.birthdate.charAt(1) == '.') {
                        Employee.birthdate = "0" + Employee.birthdate;
                    } else if (Employee.birthdate.length() == 9 && Employee.birthdate.charAt(4) == '.') {
                        Employee.birthdate = Employee.birthdate.substring(0, 3) + "0" + Employee.birthdate.substring(3);
                    }
                    //address = Advanced.arrOfInput[5];
                    Employee.district = arrOfCommands[6];
                    Employee.city = arrOfCommands[7];
                    Employee.phone = arrOfCommands[8];
                    Employee.job= arrOfCommands[9].substring(0,1).toUpperCase()+arrOfCommands[9].substring(1);
                    Employee.salary= Integer.parseInt(arrOfCommands[10]);
                    Employee.listEmployee();

                }
                if (line.contains("addCustomer")) {

                    Customer.name = arrOfCommands[1];
                    Customer.surname = arrOfCommands[2];
                    Customer.gender = arrOfCommands[3];
                    Customer.birthdate = arrOfCommands[4];
                    if (Customer.birthdate.length() == 8) {
                        Customer.birthdate = "0" + Customer.birthdate.substring(0,2) + "0" + Customer.birthdate.substring(2);
                    } else if (Customer.birthdate.length() == 9 && Customer.birthdate.charAt(1) == '.') {
                        Customer.birthdate = "0" + Customer.birthdate;
                    } else if (Customer.birthdate.length() == 9 && Customer.birthdate.charAt(4) == '.') {
                        Customer.birthdate = Customer.birthdate.substring(0, 3) + "0" + Customer.birthdate.substring(3);
                    }
                    //address = Advanced.arrOfInput[5];
                    Customer.district = arrOfCommands[6];
                    Customer.city = arrOfCommands[7];
                    Customer.phone = arrOfCommands[8];
                    Customer.listCustomer();
                }
                if (line.contains("addReservation")) {
                    LineNumber.lineNumber();

                    Reservation.customerNum = Integer.parseInt(arrOfCommands[1]);
                    Reservation.roomNum = Integer.parseInt(arrOfCommands[2]);
                    Reservation.startDate = arrOfCommands[3];
                    Reservation.endDate = arrOfCommands[4];
                    if (Reservation.customerNum > LineNumber.lineCustomers) {
                        System.out.println("ERROR. This customer does not exist. Please add this customer to the system first.");
                        MainMenu.menuSkip();
                        MainMenu.mainMenu();
                    }

                    if (Reservation.roomNum > LineNumber.lineRooms) { // check if this room exists
                        System.out.println("ERROR. This room does not exist. Please create this room first.");
                        MainMenu.menuSkip();
                        MainMenu.mainMenu();
                    }


                    Reservation.dateFormat.setLenient(false); // fix for february month, checks leniency of date format.
                    try {
                        Reservation.dateFormat.parse(Reservation.startDate);
                    } catch (ParseException ex) {
                        System.out.println("Incorrect date format. Please input in dd.MM.yyyy");
                        MainMenu.menuSkip();
                        MainMenu.mainMenu();
                    }

                    try {
                        Reservation.dateFormat.parse(Reservation.endDate);
                    } catch (ParseException ex) {
                        System.out.println("Incorrect date format. Please input in dd.MM.yyyy");
                        MainMenu.menuSkip();
                        MainMenu.mainMenu();
                    }

                    if (Reservation.endDate.equals(Reservation.startDate)) { // check if end and start date is the same
                        System.out.println("ERROR! End date and start date can not be the same!");
                        MainMenu.menuSkip();
                        MainMenu.mainMenu();
                    }

                    try {
                        Date d1 = Reservation.dateFormat.parse(Reservation.startDate);
                        Date d2 = Reservation.dateFormat.parse(Reservation.endDate);
                        if (d1.compareTo(d2) > 0) { // check if end date is before start date
                            System.out.println("ERROR! End date can not be before start date!");
                            MainMenu.menuSkip();
                            MainMenu.mainMenu();
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    Reservation.addReservation();


                }
                if (line.contains("statistics")) {
                    Statistics.mostReserved();
                    Statistics.bestCustomer();
                    Statistics.getExpenses();
                }
                if (line.contains("deleteEmployee")) {

                    DeleteEmployee.deleteInput = Integer.parseInt(arrOfCommands[1]);
                    DeleteEmployee.deleteEmployee();
                    System.out.println("\nEmployee successfully deleted from system.");

                }
                if (line.contains("searchCustomer")) {

                    System.out.println("\n-----SEARCH CUSTOMER-----");
                    System.out.println("Search input was: "+arrOfCommands[1]);
                    SearchCustomer.searchInput = arrOfCommands[1];
                    SearchCustomer.searchCustomer();
                    System.out.println("--------------------------------------------------------");
                }

                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("commands.txt does not exist! Please add it first before continuing.");
            MainMenu.menuSkip();
            MainMenu.mainMenu();
        }

        System.out.println("\nWARNING! If you want to run all commands from commands.txt again, \n you must reset all files. (12 function in Menu)");


    }

}
