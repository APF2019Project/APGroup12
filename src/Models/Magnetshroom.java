package Models;

public class Magnetshroom extends Plant
{
    private int currentAbsorptionCoolDown;

    private Magnetshroom(String name, String type, int health, int coolDownTime, int requiredSuns, boolean cactus,
                    Cell coordination)
    {
        super(name , type , health , coolDownTime  , requiredSuns , cactus , coordination);
        currentAbsorptionCoolDown = 0;
    }

    public static void putMagnetshroom(Cell coordination)
    {
        coordination.insertCard(new Plant("Magnet-shroom" , "Land" , 2 , 4 ,
                4 , false ,  coordination));
    }

    @Override
    public void doYourJob()
    {
        super.doYourJob();

        if (currentAbsorptionCoolDown > 0)
        {
            currentAbsorptionCoolDown--;
            return;
        }

        int x = coordination.getX() , y = coordination.getY();

        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                Cell cur = coordination.getMap().getByCoordination(x + i , y + j);

                if (cur.getAbsorbed())
                {
                    currentAbsorptionCoolDown = 3;
                }
            }
        }
    }
}
