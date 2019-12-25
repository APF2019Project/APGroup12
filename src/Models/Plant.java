package Models;

public class Plant extends Card
{
    protected int requiredSuns;
    protected boolean cactus;

    protected Plant(String name, String type, int health, int coolDownTime, int requiredSuns, boolean cactus,
                    Cell coordination)
    {
        super(name , type , health , coolDownTime , coordination);
        this.requiredSuns = requiredSuns;
        this.cactus = cactus;
    }

    public boolean isCactus() {
        return cactus;
    }

    public int getRequiredSuns() {
        return requiredSuns;
    }
}
