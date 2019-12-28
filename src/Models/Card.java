package Models;

import java.util.ArrayList;

public class Card {
    protected Cell coordination;
    protected String name, type;
    protected int coolDownTime, health , currentCoolDownTime;
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

    public static Card getCardObj ( String name ){
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
}