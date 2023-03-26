import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Statistics {

    static Map<String, Long> resvMap = new HashMap<>();

    public static void mostReserved() {

        ReadFiles.readFiles();


        for (int i = 0; i < ReadFiles.listReservationArray.length; i++) {

            String[] splitListResv = ReadFiles.listReservationArray[i].split(" ", 5);
            String lastRoomNum = splitListResv[0] + " " + splitListResv[1];


            long count = resvMap.containsKey(lastRoomNum) ? resvMap.get(lastRoomNum) : 0;
            resvMap.put(lastRoomNum, count + 1);

        }

        long a = 0;
        String roomNum = null;

        for (var entry : resvMap.entrySet()) {

            if (entry.getValue() > a) {

                a = entry.getValue();
                roomNum = entry.getKey();

            }

        }
        System.out.println("1. The most reserved room = " + roomNum);


    }


    public static void bestCustomer() {

        ReadFiles.readFiles();

        File listDates = new File("listDates.txt");

        for (int i = 0; i < ReadFiles.listReservationArray.length; i++) {

            try {
                String[] splitResvArray = ReadFiles.listReservationArray[i].split(" ");
                int splitResvArrayInt = splitResvArray.length;

                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
                Date firstDate = sdf.parse(splitResvArray[splitResvArrayInt - 2]);
                Date secondDate = sdf.parse(splitResvArray[splitResvArrayInt - 1]);

                long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
                long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

                String fullName = splitResvArray[2] + " " + splitResvArray[3];

                PrintWriter out = new PrintWriter(new FileWriter("listDates.txt", true));

                out.println(fullName + " " + diff);
                out.close();


            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        String[] listDatesArray;
        try {
            listDatesArray = Files.readAllLines(Paths.get("listDates.txt")).toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int firstNum = 0;
        String finalNum = null;

        File dates = new File("dates.txt");
        for (int i = 0; i < listDatesArray.length; i++) {

            try {
                String[] splitListDates = listDatesArray[i].split(" ");
                int number = Integer.parseInt(splitListDates[2]);

                PrintWriter out = new PrintWriter(new FileWriter("dates.txt", true));

                out.println(number);
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        int largest = 0;

        try {
            Scanner file = new Scanner(new File("dates.txt"));
            largest = file.nextInt();


            while (file.hasNextInt()) {
                int number = file.nextInt();

                if (number > largest) {
                    largest = number;
                }

            }
            file.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String largestNum = String.valueOf(largest);

        for (int i = 0; i < listDatesArray.length; i++) {

            if (listDatesArray[i].contains(largestNum)) {
                System.out.println("2. The best customer = " + listDatesArray[i] + " days");
            }

        }

        dates.delete();
        listDates.delete();


    }

    public static void getExpenses() {

        ReadFiles.readFiles();

        int sum = 0;
        int number = 0;
        int consExpense = 120000;

        for (int i = 0; i < ReadFiles.listSalariesArray.length; i++) {

            number = Integer.parseInt(ReadFiles.listSalariesArray[i]);

            sum = sum + number;

        }

        System.out.println("3. "+"Income = "+
                          "\n   Salary = "+sum+
                          "\n   Constant expenses = "+consExpense+
                          "\n   Profit = ");


    }
}
