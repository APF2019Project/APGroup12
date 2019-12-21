package Models;

import java.util.ArrayList;

public class Profile {
    private String username ;
    private String password ;
    public static Profile currentProfile ;
    private ArrayList<Plant> plants = new ArrayList<>() ;         // all user's plants
    private ArrayList<Zombie> zombies = new ArrayList<>();
    private ArrayList unBoughtCards = new ArrayList() ;
    private ArrayList<Card> plantCollection = new ArrayList<>() ; // choose for hand
    private ArrayList<Card> zombieCollection = new ArrayList<>() ;

    public Profile(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public void printUnSelectedCards(String gameType ){
        if( gameType.equals("Day") || gameType.equals("Water")) {
            for (Card card : this.plants)
                if (!plantCollection.contains(card))
                    System.out.println(card.getName());
        }
        else if( gameType.equals("Zombie")) {
            for (Card card : this.zombies)
                if (!zombieCollection.contains(card))
                    System.out.println(card.getName());
        }
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public ArrayList<Card> getPlantCollection() { return plantCollection;}
    public ArrayList<Card> getZombieCollection() { return zombieCollection; }
    public ArrayList<Plant> getPlants() { return plants; }
    public ArrayList<Zombie> getZombies() { return zombies; }
    public ArrayList getUnBoughtCards() { return unBoughtCards; }
}
