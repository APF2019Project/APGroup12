package Models;

import java.util.ArrayList;

public class Card {
    private String cardType ;
    private String name ;
    private int coolDownTime ;
    private  int health ;
    private int price ;
    private  static ArrayList<Card> allCards = new ArrayList<>() ;

    public static Card getCardObj ( String name ){
        for ( Card card : allCards ) {
            if( card.getName().equalsIgnoreCase( name ) )
                return card ;
        }
        return null ;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getCoolDownTime() { return coolDownTime; }
    public void setCoolDownTime(int coolDownTime) { this.coolDownTime = coolDownTime; }
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }
    public static ArrayList<Card> getAllCards() { return allCards; }
    public String getCardType() { return cardType; }
    public void setCardType(String cardType) { this.cardType = cardType; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

}
