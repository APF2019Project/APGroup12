package Models;

public class Game
{
    protected Map map;
    protected Collection plantHand , zombieHand;
    protected int passedTurns = 0;
    protected boolean ended = false;

    protected Game(Map map , Collection plantHand , Collection zombieHand)
    {
        this.map = map;
        this.plantHand = plantHand;
        this.zombieHand = zombieHand;
    }

    protected void youHaveWon()
    {
        System.out.println("You have won!");
        ended = true;
    }

    protected void youHaveLost()
    {
        System.out.println("You have lost!");
        ended = true;
    }

    public void showLawn()
    {
        map.showLawn();
    }

    public void endTurn()
    {
        passedTurns++;
        this.plantHand.endTurn();
        this.zombieHand.endTurn();
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

    public boolean isEnded() {
        return ended;
    }

    public void end() { ended = true; }
}
