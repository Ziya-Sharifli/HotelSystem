import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Reservation {

    static Scanner keyboard = new Scanner(System.in);
    static int roomNum;
    static int customerNum;
    static String startDate;
    static String endDate;
    static String fullName;
    static String roomNameFinal;
    static String[] splitStr;

    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    static String[] dateSplit;

    public static void addReservationInit() {

        LineNumber.lineNumber();

        if (MainMenu.menuChoice.equals("0")) {


            customerNum = Integer.parseInt(Advanced.arrOfInput[1]);
            roomNum = Integer.parseInt(Advanced.arrOfInput[2]);
            startDate = Advanced.arrOfInput[3];
            endDate = Advanced.arrOfInput[4];
            if (customerNum > LineNumber.lineCustomers) {
                System.out.println("ERROR. This customer does not exist. Please add this customer to the system first.");
                MainMenu.menuSkip();
                MainMenu.mainMenu();
            }

            if (roomNum > LineNumber.lineRooms) { // check if this room exists
                System.out.println("ERROR. This room does not exist. Please create this room first.");
                MainMenu.menuSkip();
                MainMenu.mainMenu();
            }


            dateFormat.setLenient(false); // fix for february month, checks leniency of date format.
            try {
                dateFormat.parse(startDate);
            } catch (ParseException ex) {
                System.out.println("Incorrect date format. Please input in dd.MM.yyyy");
                MainMenu.menuSkip();
                MainMenu.mainMenu();
            }

            try {
                dateFormat.parse(endDate);
            } catch (ParseException ex) {
                System.out.println("Incorrect date format. Please input in dd.MM.yyyy");
                MainMenu.menuSkip();
                MainMenu.mainMenu();
            }

            if (endDate.equals(startDate)) { // check if end and start date is the same
                System.out.println("ERROR! End date and start date can not be the same!");
                MainMenu.menuSkip();
                MainMenu.mainMenu();
            }

            try {
                Date d1 = dateFormat.parse(startDate);
                Date d2 = dateFormat.parse(endDate);
                if (d1.compareTo(d2) > 0) { // check if end date is before start date
                    System.out.println("ERROR! End date can not be before start date!");
                    MainMenu.menuSkip();
                    MainMenu.mainMenu();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            addReservation();
            Advanced.executedMsg();
            MainMenu.mainMenu();

        }


        System.out.println("Enter the number (ID) of the customer you would like to reserve for: ");
        customerNum = keyboard.nextInt();

        if (customerNum > LineNumber.lineCustomers) {
            System.out.println("ERROR. This customer does not exist. Please add this customer to the system first.");
            MainMenu.menuSkip();
            MainMenu.mainMenu();
        }

        System.out.println("Enter the number (ID) of the room you would like to reserve: ");
        roomNum = keyboard.nextInt();

        if (roomNum > LineNumber.lineRooms) { // check if this room exists
            System.out.println("ERROR. This room does not exist. Please create this room first.");
            MainMenu.menuSkip();
            MainMenu.mainMenu();
        }

        System.out.println("Enter the start date of the reservation: ");
        startDate = keyboard.next();

        dateFormat.setLenient(false); // fix for february month, checks leniency of date format.
        try {
            dateFormat.parse(startDate);
        } catch (ParseException ex) {
            System.out.println("Incorrect date format. Please input in dd.MM.yyyy");
            MainMenu.menuSkip();
            MainMenu.mainMenu();
        }

        System.out.println("Enter the end date of the reservation: ");
        endDate = keyboard.next();
        try {
            dateFormat.parse(endDate);
        } catch (ParseException ex) {
            System.out.println("Incorrect date format. Please input in dd.MM.yyyy");
            MainMenu.menuSkip();
            MainMenu.mainMenu();
        }


        if (endDate.equals(startDate)) { // check if end and start date is the same
            System.out.println("ERROR! End date and start date can not be the same!");
            MainMenu.menuSkip();
            MainMenu.mainMenu();
        }

        try {
            Date d1 = dateFormat.parse(startDate);
            Date d2 = dateFormat.parse(endDate);
            if (d1.compareTo(d2) > 0) { // check if end date is before start date
                System.out.println("ERROR! End date can not be before start date!");
                MainMenu.menuSkip();
                MainMenu.mainMenu();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        addReservation();

    }


    public static void addReservation() {


        File listReservations = new File("listOfReservations.txt");
        if(!listReservations.exists()) {
            try {
                listReservations.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        ReadFiles.readFiles();
        LineNumber.lineNumber();



        for (int i = 0; i < ReadFiles.listCustomerArray.length; i++) { // Get customer name details for reservation

            if (customerNum == Integer.parseInt(String.valueOf(ReadFiles.listCustomerArray[i].charAt(10)))) {

                splitStr = ReadFiles.listCustomerArray[i].split(" ", 5);
                fullName = splitStr[2] + " " + splitStr[3];

            }

        }



        roomNameFinal = "Room #" + roomNum;

        /*
        String[] listCustomerCheck;
        try {
            listCustomerCheck = Files.readAllLines(Paths.get("listOfReservations.txt")).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < listCustomerCheck.length; i++) {

            try {

                String[] arrListCustomerCheck = listCustomerCheck[i].split(" ", 10);

                Date sDate = dateFormat.parse(String.valueOf(arrListCustomerCheck[4]));
                Date eDate = dateFormat.parse(String.valueOf(arrListCustomerCheck[5]));
                Date dateToValidate = dateFormat.parse(startDate);
                String checkRoom = arrListCustomerCheck[0] + " " + arrListCustomerCheck[1];

                if (listCustomerCheck[i].contains(checkRoom)) {
                    if (dateToValidate.after(sDate) && dateToValidate.before(eDate)) {
                        System.out.println("This room has already been reserved between the given time periods.");
                        MainMenu.menuSkip();
                        MainMenu.mainMenu();
                    } else if (arrListCustomerCheck[4].equals(startDate)) {
                        System.out.println("This room has already been reserved between the given time periods.");
                        MainMenu.menuSkip();
                        MainMenu.mainMenu();
                    } else if (arrListCustomerCheck[5].equals(startDate)) {
                        System.out.println("This room has already been reserved between the given time periods.");
                        MainMenu.menuSkip();
                        MainMenu.mainMenu();
                    } else if (arrListCustomerCheck[5].equals(endDate)) {
                        System.out.println("This room has already been reserved between the given time periods.");
                        MainMenu.menuSkip();
                        MainMenu.mainMenu();
                    } else if (arrListCustomerCheck[4].equals(endDate)) {
                        System.out.println("This room has already been reserved between the given time periods.");
                        MainMenu.menuSkip();
                        MainMenu.mainMenu();
                    } else {
                        break;
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

         */

        try {
            PrintWriter out = new PrintWriter(new FileWriter("listOfReservations.txt", true));

            out.println(roomNameFinal + " " + fullName + " " + startDate + " " + endDate);
            out.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
