
import Controller.Controller;
import Models.JSONHandler;



public class Main {
    public static void main(String[] args) {
        JSONHandler.createObjects();


        Controller ctrl = new Controller() ;
        ctrl.gameHandle();
    }
}
