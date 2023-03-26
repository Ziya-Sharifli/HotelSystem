import java.util.Random;

public class Prices {

    static int prices;

    static Random rand = new Random();

    public static void price() {


        // Regular

        if (Room.roomType.equals("Regular") && Room.balcony.equals("Balcony") && Room.airCon.equals("AirCondition")) {

            prices = rand.nextInt(2000-1000) + 1000;

        }
        if (Room.roomType.equals("Regular") && Room.balcony.equals("Balcony") && Room.airCon.equals("No-AirCondition")) {

            prices = rand.nextInt(1800-900) + 900;

        }
        if (Room.roomType.equals("Regular") && Room.balcony.equals("No-Balcony") && Room.airCon.equals("AirCondition")) {

            prices = rand.nextInt(1600-800) + 800;

        }
        if (Room.roomType.equals("Regular") && Room.balcony.equals("No-Balcony") && Room.airCon.equals("No-AirCondition")) {

            prices = rand.nextInt(1500-700) + 700;

        }

        // Suite

        if (Room.roomType.equals("Suite") && Room.balcony.equals("Balcony") && Room.airCon.equals("AirCondition")) {

            prices = rand.nextInt(5000-4000) + 4000;

        }
        if (Room.roomType.equals("Suite") && Room.balcony.equals("Balcony") && Room.airCon.equals("No-AirCondition")) {

            prices = rand.nextInt(4800-3900) + 3900;

        }
        if (Room.roomType.equals("Suite") && Room.balcony.equals("No-Balcony") && Room.airCon.equals("AirCondition")) {

            prices = rand.nextInt(4500-3500) + 3500;

        }
        if (Room.roomType.equals("Suite") && Room.balcony.equals("False") && Room.airCon.equals("False")) {

            prices = rand.nextInt(4200-3200) + 3200;

        }


        // Deluxe

        if (Room.roomType.equals("Deluxe") && Room.balcony.equals("Balcony") && Room.airCon.equals("AirCondition")) {

            prices = rand.nextInt(3000-2000) + 2000;

        }
        if (Room.roomType.equals("Deluxe") && Room.balcony.equals("Balcony") && Room.airCon.equals("No-AirCondition")) {

            prices = rand.nextInt(2900-1900) + 1900;

        }
        if (Room.roomType.equals("Deluxe") && Room.balcony.equals("No-Balcony") && Room.airCon.equals("AirCondition")) {

            prices = rand.nextInt(2800-1800) + 1800;

        }
        if (Room.roomType.equals("Deluxe") && Room.balcony.equals("No-Balcony") && Room.airCon.equals("No-AirCondition")) {

            prices = rand.nextInt(2600-1600) + 1600;

        }





    }


}