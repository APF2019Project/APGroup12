package Models;

import java.util.ArrayList;


public class Shop {
    private ArrayList<Card> shopPlants = Plant.getAllPlants().getList() ;
    private ArrayList<Card> shopZombies = Zombie.getAllZombies().getList() ;


    public ArrayList<Card> getShopPlants() { return shopPlants; }
    public ArrayList<Card> getShopZombies() { return shopZombies; }
}