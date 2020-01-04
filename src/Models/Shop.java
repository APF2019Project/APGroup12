package Models;

import java.util.ArrayList;


public abstract class Shop {
    private ArrayList<Card> shopPlants = new ArrayList<>() ;
    private ArrayList<Card> shopZombies = new ArrayList<>() ;


    public ArrayList<Card> getShopPlants() { return shopPlants; }
    public ArrayList<Card> getShopZombies() { return shopZombies; }
}