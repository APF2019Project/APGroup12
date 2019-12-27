package Models;

import java.util.ArrayList;

public class Profile {
    private int Coins ;
    private int sun ;
    private String username ;
    private String password ;
    public static Profile currentProfile ;
    private ArrayList<Card> plants = new ArrayList<>() ;         // all user's plants
    private ArrayList<Card> zombies = new ArrayList<>();
    private ArrayList<Card> unBoughtCards = new ArrayList() ; // avalesh hme karta to unboughte hrchi k mikhare remove mishe
    private ArrayList<Card> plantCollection = new ArrayList<>() ; // choose for hand
    private ArrayList<Card> zombieCollection = new ArrayList<>() ;
    private ArrayList<Card> boughtCards = new ArrayList<>() ;
    private static ArrayList<Profile> allProfiles = new ArrayList<>() ;

    public Profile(String username, String password) {
        this.username = username;
        this.password = password;
        allProfiles.add( this ) ;
    }

    public void printUnSelectedCards( String type ){
        if( type.equals("plant")) {
            for (Card card : this.plants)
                if (!plantCollection.contains(card))
                    System.out.println(card.getName());
        }
        else{
            for (Card card : this.zombies)
                if (!zombieCollection.contains(card))
                    System.out.println(card.getName());
        }
    }
    public static Profile getProfileObj( String username ){
        for ( Profile p : allProfiles) {
            if( p.username.equals( username ))
                return p ;
        }
        return null ;
    }

    public void selectCard(String type , String nameCard ){
        if( type.equals("plant")) {
            for ( Card card : this.getPlants() ) {
                if( card.getName().equalsIgnoreCase( nameCard) )
                    this.getPlantCollection().add( card ) ;              // !!!!!
            }
        }
        if( type.equals("zombie")) {
            for ( Card card : this.getZombies() ) {
                if( card.getName().equalsIgnoreCase( nameCard ) )
                    this.getZombieCollection().add( card ) ;
            }
        }
    }
    public void removeCard(String type , String nameCard ){
        if( type.equals("plant")) {
            for ( Card card : this.getPlants() ) {
                if( card.getName().equalsIgnoreCase( nameCard) )
                    this.getPlantCollection().remove( card ) ;              // !!!!!
            }
        }
        if( type.equals("zombie")) {
            for ( Card card : this.getZombies() ) {
                if( card.getName().equalsIgnoreCase( nameCard ) )
                    this.getZombieCollection().remove( card ) ;
            }
        }
    }

    public void printShopCards(){
        for (Card card : this.unBoughtCards ) {
            System.out.printf( card.getName() + " : " + card.getPrice() );
        }
    }
    public void buyCard( String cardName ){
        Card card = Card.getCardObj( cardName );
        if( card == null )
            System.out.println("Invalid name!");
        else if( this.getCoins() >= card.getPrice()) {
             if (this.unBoughtCards.contains(card)) {
                if (card.getCardType().equals("plant"))
                    this.getPlants().add(card);
                else
                    this.getZombies().add(card);
                this.getBoughtCards().add(card);
                this.getUnBoughtCards().remove(card);
                this.setCoins( this.getCoins() - card.getPrice());
            }
        }
        else System.out.println("Not enough money!");
    }


    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public ArrayList<Card> getPlantCollection() { return plantCollection;}
    public ArrayList<Card> getZombieCollection() { return zombieCollection; }
    public ArrayList<Card> getPlants() { return plants; }
    public ArrayList<Card> getZombies() { return zombies; }
    public ArrayList getUnBoughtCards() { return unBoughtCards; }
    public static ArrayList<Profile> getAllProfiles() { return allProfiles; }
    public ArrayList<Card> getBoughtCards() { return boughtCards; }
    public int getCoins() { return Coins; }
    public void setCoins(int coins) { Coins = coins; }
    public int getSun() { return sun; }
    public void setSun(int sun) { this.sun = sun; }
}
