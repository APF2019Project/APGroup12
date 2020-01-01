
import Controller.Controller;
import Models.JSONHandler;
import Models.Plant;


public class Main {
    public static void main(String[] args) {
        //JSONHandler.createObjects();
        JSONHandler.readAllFromJsons();
        for ( Plant plant: Plant.getAllPlants()) {
            System.out.println(plant.getName());
        }


        Controller ctrl = new Controller() ;
        ctrl.gameHandle();
    }
}
