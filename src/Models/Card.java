package Models;

import java.util.ArrayList;
import java.util.Random;

public class Card {
    protected Cell coordination;
    protected String type;
    protected String name ;
    protected int price ;
    protected int health ;
    private  static ArrayList<Card> allCards = new ArrayList<>() ;

    protected Card(String name, String type, int health, Cell coordination)
    {
        this.name = name;
        this.type = type;
        this.health = health;
        this.coordination = coordination;
    }

    public Card copy()
    {
        return new Card(this.name , this.type , this.health , this.coordination);
    }

    public static Card getRandomCard(Collection hand)
    {
        Random random = new Random();
        int pos = random.nextInt(hand.getSize()) + 1;
        return hand.getCard(pos);
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
        System.out.println(name + " " + health + " " + coordination.getX() + " " + coordination.getY());
    }

    public void doYourJob()
    {

    }

    public Cell getCoordination() {
        return coordination;
    }
    public void setCoordination(Cell coordination)
    {
        this.coordination = coordination;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) { this.health = health; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
}