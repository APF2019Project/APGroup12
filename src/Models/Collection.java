package Models;

import java.util.ArrayList;

public class Collection {
   private ArrayList<Card> plantsCollection = new ArrayList<>();
   private ArrayList<Card> zombieCollection = new ArrayList<>() ;


    public ArrayList<Card> getPlantsCollection() { return plantsCollection; }
    public ArrayList<Card> getZombieCollection() { return zombieCollection; }

}
