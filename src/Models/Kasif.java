package Models;

import View.View;
import javafx.scene.layout.Pane;

public class Kasif {
    private static final String plantName = "([\\S\\s]+)";
    private static final String number = "([0-9]+)";

    public static void main(String[] args) throws InterruptedException {
        JSONHandler.createObjects();
        JSONHandler.readAllFromJsons();

        Collection pc = new Collection();
        pc.add(Plant.getAllPlants().getCard("Peashooter"));
        Collection zc = new Collection();
        zc.add(Zombie.getAllZombies().getCard("Bungee Zombie"));
        RailMode game = RailMode.createRailMode(Map.createMap("Land" , false , new Pane()) , pc , zc);
        View view = new View();
        view.run(game , new Profile("ali" , "123") , false);

        /*View view = new View();
        view.loginMenu();*/
    }
}
