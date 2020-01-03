package Models;

public class Game
{
    protected Map map;
    protected Collection plantHand , zombieHand;
    protected int passedTurns = 0;

    protected Game(Map map , Collection plantHand , Collection zombieHand)
    {
        this.map = map;
        this.plantHand = plantHand;
        this.zombieHand = zombieHand;
    }

    protected void youHaveWon()
    {
        System.out.println("You have won!");
    }
    protected void youHaveLost()
    {
        System.out.println("You have lost!");
    }

    public void showLawn()
    {
        map.showLawn();
    }

    public void endTurn()
    {
        passedTurns++;
        map.endTurn();
    }

    public Map getMap() {
        return map;
    }

    public Collection getPlantHand() {
        return plantHand;
    }

    public Collection getZombieHand() {
        return zombieHand;
    }
}
