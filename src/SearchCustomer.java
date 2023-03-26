import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchCustomer {

    public static String searchInput;
    public static String[] arrOfSearchInput;
    public static String[] searchSym;
    static Scanner keyboard = new Scanner(System.in);

    public static void searchCustomerInit() {

        if (MainMenu.menuChoice.equals("0")) {

            searchInput = Advanced.arrOfInput[1];
            searchCustomer();
            MainMenu.menuSkip();
            MainMenu.mainMenu();

        }

        System.out.println("Enter your search term: ");
        searchInput = keyboard.nextLine();


        searchCustomer();
    }


    public static void searchCustomer() {

        if (searchInput.contains("*")) {
            arrOfSearchInput = searchInput.split("\\*");
            searchInput = arrOfSearchInput[0];
        }
        //else if (searchInput.contains("?")) {

        //}

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("listOfCustomers.txt"));
            String line = reader.readLine();

            while (line != null) {

                if (line.contains(searchInput)){
                    System.out.println(line);
                }


                line = reader.readLine();
            }
        }
        catch (IOException e){
                e.printStackTrace();
            }

    }



}
