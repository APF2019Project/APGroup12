package Models;

import java.util.ArrayList;

public class Profile {
    private String username ;
    private String password ;
    private int Coins ;
    private int sun ;
    private int record ;
    private Shop shop ;
    private Collection collection ;
    public static Profile currentProfile ;
    private ArrayList<Card> plants = new ArrayList<>() ;         // all user's plants
    private ArrayList<Card> zombies = new ArrayList<>();
    private ArrayList<Card> boughtCards = new ArrayList<>() ;
    private static ArrayList<Profile> allProfiles = new ArrayList<>() ;

    public Profile(String username, String password) {
        this.username = username;
        this.password = password;
        allProfiles.add( this ) ;
    }

    public void printUnSelectedCards( String type ){
        if( type.equals("plant")) {
            for (Card card : this.plants )
                if (! collection.getPlantsCollection().contains(card) )
                    System.out.println(card.getName());
        }
        else{
            for (Card card : this.zombies)
                if (! collection.getZombieCollection().contains(card))
                    System.out.println(card.getName());
        }
    }
    public static Profile getProfileObj( String username , String password ){
        for ( Profile p : allProfiles) {
            if( p.username.equals( username ) && p.password.equals( password))
                return p ;
        }
        return null ;
    }
    public static Profile getProfileObj( String username ){
        for ( Profile p : allProfiles) {
            if( p.username.equals( username ) )
                return p ;
        }
        return null ;
    }

    public void selectCard( String type , String nameCard ){
        if( type.equals("plant")) {
            for ( Card card : this.getPlants() ) {
                if( card.getName().equalsIgnoreCase( nameCard ) &&
                        ! this.collection.getPlantsCollection().contains(card) &&
                         (this.collection.getPlantsCollection().size() < 7 ) ) {
                    this.collection.getPlantsCollection().add(card);
                    return;
                }
            }
        }
        else if( type.equals("zombie")) {
            for ( Card card : this.getZombies() ) {
                if( card.getName().equalsIgnoreCase( nameCard ) &&
                        ! this.collection.getZombieCollection().contains( card) &&
                        (this.collection.getZombieCollection().size() < 7 )) {
                    this.collection.getZombieCollection().add(card);
                    return;
                }
            }
        }
        if( this.collection.getPlantsCollection().size()==7 || this.collection.getZombieCollection().size()==7){
            System.out.println("Your collection is full!");
            return;
        }
    }
    public void removeCard(String type , String nameCard ){
        if( type.equals("plant")) {
            for ( Card card : this.getPlants() ) {
                if( card.getName().equalsIgnoreCase( nameCard) &&
                        this.collection.getPlantsCollection().contains(card)) {
                    this.collection.getPlantsCollection().remove(card);
                    return;
                }
            }
        }
        if( type.equals("zombie")) {
            for ( Card card : this.getZombies() ) {
                if( card.getName().equalsIgnoreCase( nameCard ) &&
                        this.collection.getZombieCollection().contains( card)) {
                    this.collection.getZombieCollection().remove(card);
                    return;
                }
            }
        }
    }

    public void printShopCards(){
        System.out.println( "Plants:" );
        for (Card card : this.shop.getShopPlants() ) {
            System.out.println( card.getName() + ": " + card.getPrice() );
        }
        System.out.println( "Zombies:" );
        for ( Card card : this.shop.getShopZombies() ) {
            System.out.println( card.getName() + ": " + card.getPrice() );
        }
    }
    public void buyCard( String cardName ){
        Card card = Card.getCardObj( cardName );
        if( card == null )
            System.out.println("Invalid name!");
        else if( this.getCoins() >= card.getPrice()) {
             if ( this.shop.getShopPlants().contains(card) || this.shop.getShopZombies().contains( card )) {
                if (card.getType().equals("plant")) {
                    this.getPlants().add(card);
                    this.shop.getShopPlants().remove( card );
                }
                else {
                    this.getZombies().add(card);
                    this.shop.getShopZombies().remove( card );
                }
                this.getBoughtCards().add(card);
                this.setCoins( this.getCoins() - card.getPrice());
                 System.out.println("Card bought successfully!");
            }
        }
        else System.out.println("Not enough money!");
    }


    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public ArrayList<Card> getPlants() { return plants; }
    public ArrayList<Card> getZombies() { return zombies; }
    public static ArrayList<Profile> getAllProfiles() { return allProfiles; }
    public ArrayList<Card> getBoughtCards() { return boughtCards; }
    public int getCoins() { return Coins; }
    public void setCoins(int coins) { Coins = coins; }
    public int getSun() { return sun; }
    public void setSun(int sun) { this.sun = sun; }
    public int getRecord() { return record; }
    public void setRecord(int record) { this.record = record; }
    public static Profile getCurrentProfile() { return currentProfile; }
    public static void setCurrentProfile(Profile currentProfile) { Profile.currentProfile = currentProfile; }
    public Shop getShop() { return shop; }
    public void setShop(Shop shop) { this.shop = shop; }
    public Collection getCollection() { return collection; }
    public void setCollection(Collection collection) { this.collection = collection; }
}
