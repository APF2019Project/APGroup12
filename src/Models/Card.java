package Models;

public class Card {
    protected Cell coordination;
    protected String name, type;
    protected int coolDownTime, health , currentCoolDownTime;

    protected Card(String name, String type, int health, int coolDownTime, Cell coordination)
    {
        this.name = name;
        this.type = type;
        this.health = health;
        this.coolDownTime = coolDownTime;
        this.coordination = coordination;
        this.currentCoolDownTime = 0;
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