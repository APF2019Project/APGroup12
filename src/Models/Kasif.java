package Models;

import View.View;

public class Kasif {
    private static final String plantName = "([\\S\\s]+)";
    private static final String number = "([0-9]+)";

    public static void main(String[] args) {
        JSONHandler.createObjects();
        JSONHandler.readAllFromJsons();

        View view = new View();
        view.loginMenu();
    }
}
