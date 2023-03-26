import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Employee {
    static Scanner keyboard = new Scanner(System.in);
    static String name;
    static String surname;
    static String gender;
    static String birthdate;
    static String address;
    static String district;
    static String city;
    static String phone;
    static String job;
    static int salary;

    //This class takes the features of employee from console.Some features separated because they include recursive call.
    public static void addEmployee() {

        if (MainMenu.menuChoice.equals("0")) {
            name = Advanced.arrOfInput[1];
            surname = Advanced.arrOfInput[2];
            gender = Advanced.arrOfInput[3];
            birthdate = Advanced.arrOfInput[4];
            if (birthdate.length() == 8) {
                birthdate = "0" + birthdate.substring(0,2) + "0" + birthdate.substring(2);
            } else if (birthdate.length() == 9 && birthdate.charAt(1) == '.') {
                birthdate = "0" + birthdate;
            } else if (birthdate.length() == 9 && birthdate.charAt(4) == '.') {
                birthdate = birthdate.substring(0, 3) + "0" + birthdate.substring(3);
            }
            //address = Advanced.arrOfInput[5];
            district = Advanced.arrOfInput[6];
            city = Advanced.arrOfInput[7];
            phone = Advanced.arrOfInput[8];
            job=Advanced.arrOfInput[9];
            salary= Integer.parseInt(Advanced.arrOfInput[10]);
            listEmployee();
            Advanced.executedMsg();
            MainMenu.menuSkip();
            MainMenu.mainMenu();
        }

        System.out.print("Enter the name of the employee: ");
        name = keyboard.next();

        System.out.print("Enter the surname of the employee: ");
        surname = keyboard.next();
        getGender();
        getBirthdate();

        System.out.print("Enter the address of the employee: ");
        address = keyboard.next();

        System.out.print("Enter the district that the employee lives in: ");
        district = keyboard.next();

        System.out.print("Enter the city that the employee lives in: ");
        city = keyboard.next();
        getPhone();
        getJob();

        getSalary();

        listEmployee();
    }

    public static void listEmployee() {
        File listEmployeesFile = new File("listOfEmployees.txt"); // Create new file for listEmployees

        long lines = 0;

        try { // Read the number of lines in listOfEmployees.txt file
            lines = Files.lines(Paths.get("listOfEmployees.txt")).count();
        } catch (IOException e) {//If you do not have this text file. The program will create.
            System.out.println("\nError 1: Java IOEXCEPTION - listOfEmployees.txt does not exist in your folder. \n\nThe program automatically created it for you.\n");
        }

        try {
            PrintWriter out = new PrintWriter(new FileWriter("listOfEmployees.txt", true));

            lines++; // this increases the line count in listOfEmployee.txt to get the number of rooms in the list
            out.printf("%-1s%-4s%-10s%-10s%-10s%-11s%-1s\n", "Employee #", lines, name, surname, gender, birthdate, job);
            out.close();

        } catch (IOException ex) {
            System.out.println("Error 1: Java IOEXCEPTION");
        }
    }

    public static void getBirthdate() {
        System.out.print("Enter the birthdate of the employee in [dd.mm.yyyy] format: ");
        birthdate = keyboard.next();
        int year = 0, month = 0, day = 0;
        //With the help of the following try catch blocks. We can take the input in [dd.m.yyyy] format
        try {
            year = Integer.parseInt(birthdate.substring(6, 10));
            month = Integer.parseInt(birthdate.substring(3, 5));
            day = Integer.parseInt(birthdate.substring(0, 2));
        } catch (Exception d) {
            try {
                year = Integer.parseInt(birthdate.substring(5, 9));
                month = Integer.parseInt(birthdate.substring(3, 4));
                day = Integer.parseInt(birthdate.substring(0, 2));
                birthdate = day + ".0" + month + "." + year;
            } catch (Exception f) {
                getBirthdate();
            }
        }

        if ((birthdate.length() == 10 && year < 2006 && birthdate.charAt(5) == '.' && month <= 12 && month > 0 && birthdate.charAt(2) == '.')) {
            if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)) {
                if ((day <= 31 && day > 0)) {

                } else {
                    System.out.println("error");
                    getBirthdate();
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day <= 30 && day > 0) {

                } else {
                    System.out.println("error");
                    getBirthdate();
                }
            } else if (month == 2) {
                if (day <= 28 && day > 0) {

                } else if (day == 29 && year % 4 == 0) {
                    if (year % 100 == 0 && year % 400 != 0) {
                        System.out.println("error");
                        getBirthdate();
                    }
                }
            } else {
                System.out.println("error");
                getBirthdate();
            }
        } else {
            System.out.println("error");
            getBirthdate();
        }
    }

    public static void getGender() {
        System.out.print("Choose the gender:\nM for male\nF for female\n-> ");
        gender = keyboard.next().toUpperCase();
        switch (gender) {
            case "M" -> gender = "Male";
            case "F" -> gender = "Female";
            default -> getGender();
        }
    }

    public static void getJob() {
        System.out.print("Choose the type of occupation:\nA for Admin\nR for Receptionist\nH for Housekeeper\n-> ");
        String jobTypeInput = keyboard.next().toUpperCase();
        switch (jobTypeInput) {
            case "A" -> job = "Admin";
            case "R" -> job = "Receptionist";
            case "H" -> job = "Housekeeper";
            default -> getJob();
        }
    }

    public static void getPhone() {
        System.out.print("Enter the phone number of the employee: ");
        phone = keyboard.next();
        phone = phone.replaceAll("\\s", "");//This deletes all the blanks in the input.
        String phone0 = String.valueOf(phone.charAt(0));
        //This if block adds country code to the num.
        if (phone0.equals("0") && phone.length() == 11) {
            phone = "+9" + phone;
        } else if (phone0.equals("5") && phone.length() == 10) {
            phone = "+90" + phone;
        } else {
            getPhone();
        }
        //With this we recast the phone number to +90 (xxx) xxxxxxx format.
        String temp1 = phone.substring(0, 3);
        String temp2 = phone.substring(3, 6);
        String temp3 = phone.substring(6);
        phone = temp1 + " (" + temp2 + ") " + temp3;
    }


    public static void getSalary() {

        try {
            System.out.print("Enter the salary of the employee: ");
            salary = keyboard.nextInt();

            PrintWriter out = new PrintWriter(new FileWriter("listOfSalaries.txt", true));

            out.println(salary);
            out.close();
        } catch (Exception exp) {
            System.out.println("Enter an integer value!!");
            getSalary();
        }
    }
}
