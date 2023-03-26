import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Scanner;

public class DeleteEmployee {

    public static int deleteInput;
    public static String[] employeeArray;

    static long lines;

    public static void deleteEmployeeInit() {

        Scanner keyboard = new Scanner(System.in);

        if (MainMenu.menuChoice.equals("0")) {

            deleteInput = Integer.parseInt(Advanced.arrOfInput[1]);
            deleteEmployee();
            MainMenu.menuSkip();
            MainMenu.mainMenu();
        }

        System.out.println("Enter the ID of the employee that you would like to delete: ");
        deleteInput = keyboard.nextInt();

        if (deleteInput <= 0) {
            System.out.println("The ID of the employee can not be less than or equal to 0!\n");
            deleteEmployeeInit();
        }

        deleteEmployee();
    }

    public static void deleteEmployee() {

        try {
            employeeArray = Files.readAllLines(Paths.get("listOfEmployees.txt")).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File tempList = new File("tempListOfEmployees.txt");

        try { // Read the number of lines in listOfEmployees.txt file
            lines = Files.lines(Paths.get("listOfEmployees.txt")).count();
        } catch (IOException e) {
            System.out.println("IOException");
        }
        for (int i = 0; i < lines; i++) {

            int arrayNum = Integer.parseInt(String.valueOf(employeeArray[i].charAt(10)));

            if (deleteInput == arrayNum) {
                employeeArray[i] = null;
            }
            else {
                try {
                    PrintWriter out = new PrintWriter(new FileWriter("tempListOfEmployees.txt", true));

                    out.println(employeeArray[i].substring(12));
                    out.close();

                } catch (IOException ex) {
                    System.out.println("Error 1: Java IOEXCEPTION");
                }
            }
        }

        File temp2List = new File("temp2ListOfEmployees.txt");

        String[] listEmployeeArray;
        try {
            listEmployeeArray = Files.readAllLines(Paths.get("tempListOfEmployees.txt")).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        long lines = 0;


        try {
            PrintWriter out = new PrintWriter(new FileWriter("temp2ListOfEmployees.txt", true));

            for (int i = 0; i < listEmployeeArray.length ; i++) {
                lines++; // this increases the line count in listOfRooms.txt to get the number of rooms in the list
                //out.printf("%-1s%1s%-4s%-9s%-8s%-1s\n","Room " , "#" , lines , roomType , airCon , balcony);
                out.println("Employee #"+lines+" "+listEmployeeArray[i]);
            }
            out.close();

        } catch (IOException ex) {
            //
        }

        tempList.delete();

        Path source = Paths.get("temp2ListOfEmployees.txt");

        try{
            // rename a file in the same directory
            Files.move(source, source.resolveSibling("listOfEmployees.txt"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        temp2List.delete();
    }
}