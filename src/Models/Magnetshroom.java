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

    @Override
    public Magnetshroom copy()
    {
        return new Magnetshroom(this.name , this.type , this.health , this.coolDownTime , this.requiredSuns ,
                this.cactus , null);
    }

    public static Magnetshroom getMagnetshroom()
    {
        return new Magnetshroom("Magnet-shroom" , "Land" , 2 , 4 ,
                4 , false ,  null);
    }

    @Override
    public void doYourJob()
    {
        System.out.println("Boooo!");
        if (coordination == null)
        {
            super.doYourJob();
            return;
        }

        super.doYourJob();

        if (currentAbsorptionCoolDown > 0)
        {
            currentAbsorptionCoolDown--;
            return;
        }

        int x = coordination.getX() , y = coordination.getY();
        boolean flag = false;

        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                Cell cur = coordination.getMap().getByCoordination(x + i , y + j);

                if (!flag && cur != null && cur.getAbsorbed())
                {
                    System.out.println(":X");
                    currentAbsorptionCoolDown = 3;
                    flag = true;
                }
            }
        }
    }
}
