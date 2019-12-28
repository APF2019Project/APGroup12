package Models;

class Sunflower extends Plant
{
    private int numberOfGivenSuns , coolDownForNextSun;

    private Sunflower(String name, String type, int health, int coolDownTime, int requiredSuns, boolean cactus,
              int numberOfGivenSuns, Cell coordination)
    {
        super(name , type , health , coolDownTime , requiredSuns , cactus , coordination);
        this.numberOfGivenSuns = numberOfGivenSuns;
        coolDownForNextSun = 2;
    }

    public static void putSunflower(Cell coordination)
    {
        coordination.insertCard(new Sunflower("Sunflower" , "Land" , 2 , 2 ,
                1 , false , 1 , coordination));
    }

    public static void putTwinSunflower(Cell coordination)
    {
        coordination.insertCard(new Sunflower("Twin Sunflower" , "Land" , 2 , 2 ,
                1 , false , 2 , coordination));
    }

    public void doYourJob()
    {
        if (coolDownForNextSun > 0)
        {
            coolDownForNextSun--;
            return;
        }

        coolDownForNextSun = 2;
    }
}
