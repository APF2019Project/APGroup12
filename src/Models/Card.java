package Models;

import java.util.ArrayList;

public class Card {
    protected Cell coordination;
    protected String type;
    protected String name ;
    protected int price ;
    protected int coolDownTime ;
    protected int health ;
    protected int currentCoolDownTime ;
    private  static ArrayList<Card> allCards = new ArrayList<>() ;

    protected Card(String name, String type, int health, int coolDownTime, Cell coordination)
    {
        this.name = name;
        this.type = type;
        this.health = health;
        this.coolDownTime = coolDownTime;
        this.coordination = coordination;
        this.currentCoolDownTime = 0;
    }

    public Card(String type , String name, int health) {
        this.name = name;
        this.type = type;
        this.health = health;
    }

    public Card() {
    }

    public static Card getCardObj (String name ){
        for ( Card card : allCards ) {
            if( card.getName().equalsIgnoreCase( name ) )
                return card ;
        }
        return null ;
    }

    public void show()
    {

    }

    public void doYourJob()
    {
        currentCoolDownTime--;
    }
    public boolean inCoolDown() {
        return currentCoolDownTime == 0;
    }
    public Cell getCoordination() {
        return coordination;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getCoolDownTime() {
        return coolDownTime;
    }
    public int getHealth() {
        return health;
    }
    public int getCurrentCoolDownTime() {
        return currentCoolDownTime;
    }
    public void setHealth(int health) { this.health = health; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
}