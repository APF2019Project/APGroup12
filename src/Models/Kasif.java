package Models;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Kasif {
    private static final String plantName = "([\\S\\s]+)";
    private static final String number = "([0-9]+)";

    public static void main(String[] args) {
        //JSONHandler.createObjects();
        JSONHandler.readAllFromJsons();

        Collection ph = new Collection();
        ph.add(Plant.getAllPlants().getCard("Snow Pea"));
        //ph.add(Plant.getAllPlants().getCard("Snow Pea"));

        Collection zh = new Collection();
        zh.add(Zombie.getAllZombies().getCard("Zombie"));
        //zh.add(Zombie.getAllZombies().getCard("Screen Door Zombie"));

        System.out.println(":D " + ph.getSize() + " " + zh.getSize());
        ph.show();
        zh.show();

        DayMode a = DayMode.createDayMode(Map.createLandMap() , ph , zh , false);

        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 100; i++)
        {
            String input = sc.nextLine();

            if (input.equals("end"))
            {
                return;
            }

            if (input.equals("show"))
            {
                a.showLawn();
            }

            if (input.equals("sun"))
            {
                System.out.println(a.getSuns());
            }

            if (input.equals("end turn"))
            {
                a.endTurn();
                a.getMap().show();
                a.showHand();
                System.out.println();
            }

            if (Pattern.matches("select " + plantName , input))
            {
                System.out.println("XDXD");
                a.select(input.substring(7));
            }

            if (Pattern.matches("plant " + number + " " + number , input))
            {
                a.plant(Integer.parseInt(input.split(" ")[1]) , Integer.parseInt(input.split(" ")[2]));
            }
        }
    }
}
