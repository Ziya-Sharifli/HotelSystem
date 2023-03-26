import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Room {

    static Scanner keyboard = new Scanner(System.in);
    public static int numberOfRooms;
    public static String roomTypeInput;
    public static String roomType;
    public static String airCon;
    public static String balcony;

    public static void addRoom() { // addRoom command


        if (MainMenu.menuChoice.equals("0")) {

            numberOfRooms = Integer.parseInt(Advanced.arrOfInput[1]);
            roomType = Advanced.arrOfInput[2];
            roomType = roomType.substring(0, 1).toUpperCase() + roomType.substring(1);
            airCon = Advanced.arrOfInput[3];
            airCon = airCon.substring(0, 1).toUpperCase() + airCon.substring(1);
            if (airCon.equals("True")) {
                airCon = "AirCondition";
            }
            if (airCon.equals("False")) {
                airCon = "No-Aircondition";
            }
            balcony = Advanced.arrOfInput[4];
            balcony = balcony.substring(0, 1).toUpperCase() + balcony.substring(1);
            if (balcony.equals("True")) {
                balcony = "Balcony";
            }
            if (balcony.equals("False")) {
                balcony = "No-Balcony";
            }
            Prices.prices = Integer.parseInt(Advanced.arrOfInput[5]);
            roomFile();
        }
        else {
            System.out.print("How many rooms would you like to add at once?: ");
            numberOfRooms = keyboard.nextInt();
            getRoomType();

            getAirCon();
            getBalcony();

            roomFile();
            System.out.println("Rooms have been added successfully to the system. To list them, press 2 in menu");
        }

    }

    public static void roomFile() {

        File listRoomsFile = new File("listOfRooms.txt"); // Create new file for listRooms

        long lines = 0;

        try { // Read the number of lines in listOfRooms.txt file
            lines = Files.lines(Paths.get("listOfRooms.txt")).count();
        } catch (IOException e) {
            System.out.println("\nError 1: Java IOEXCEPTION - listOfRooms.txt does not exist in your folder. \n\nThe program automatically created it for you.\n");
        }

        Prices.price();


        try {
            PrintWriter out = new PrintWriter(new FileWriter("listOfRooms.txt", true));

            for (int i = 1; i <= numberOfRooms; i++) {
                lines++; // this increases the line count in listOfRooms.txt to get the number of rooms in the list
                out.printf("%-1s%-3s%-10s%-16s%-12s%-7s%-1s\n", "Room #", lines, roomType, airCon, balcony, Prices.prices, " TL");
                //out.println("Room " + "#" + lines + " " + roomType + " " + airCon + " " + balcony + " " + Prices.prices + " TL");
            }
            out.close();

        } catch (IOException ex) {
            System.out.println("Error 1: Java IOEXCEPTION");
        }


    }

    public static void getRoomType() {
        System.out.println("Choose the type of room:\nR for regular\nD for deluxe\nS for suite\n-> ");
        roomTypeInput = keyboard.next().toUpperCase();
        switch (roomTypeInput) {
            case "R" -> roomType = "Regular";
            case "D" -> roomType = "Deluxe";
            case "S" -> roomType = "Suite";
            default -> getRoomType();
        }
    }

    public static void getAirCon() {
        System.out.println("Does this room have air conditioning? [T/F]");
        airCon = keyboard.next().toUpperCase();
        if (airCon.equals("T")) {
            airCon = "AirCondition";
        } else if (airCon.equals("F")) {
            airCon = "No-AirCondition";
        } else {
            System.out.println("Error 2: Wrong Input. Please type T OR F. (T for True, F for False)");
            getAirCon();
        }
    }

    public static void getBalcony() {
        System.out.println("Does this room have a balcony? [T/F]");
        balcony = keyboard.next().toUpperCase();
        if (balcony.equals("T")) {
            balcony = "Balcony";
        } else if (balcony.equals("F")) {
            balcony = "No-Balcony";
        } else {
            System.out.println("Error 2: Wrong Input. Please type T OR F. (T for True, F for False)");
            getBalcony();
        }
    }
}