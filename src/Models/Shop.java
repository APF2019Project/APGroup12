package Models;

import java.util.ArrayList;


public abstract class Shop {
    private ArrayList<Plant> shopPlants = new ArrayList<>() ;
    private ArrayList<Zombie> shopZombies = new ArrayList<>() ;


    public ArrayList<Plant> getShopPlants() { return shopPlants; }
    public ArrayList<Zombie> getShopZombies() { return shopZombies; }
}
