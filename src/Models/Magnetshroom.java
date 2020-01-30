package Models;

public class Magnetshroom extends Plant
{
    private int currentAbsorptionCoolDown;

    private Magnetshroom(String name, String type, int health, int coolDownTime, int requiredSuns, boolean cactus,
                         Cell coordination , String url)
    {
        super(name , type , health , coolDownTime  , requiredSuns , cactus , coordination , url);
        currentAbsorptionCoolDown = 0;
    }

    @Override
    public Magnetshroom copy()
    {
        Magnetshroom res = new Magnetshroom(this.name , this.type , this.health , this.coolDownTime , this.requiredSuns ,
                this.cactus , null , null);

        this.copyCgi(res);
        return res;
    }

    public static Magnetshroom getMagnetshroom()
    {
        return new Magnetshroom("Magnet-shroom" , "Land" , 2 , 4 ,
            4 , false ,  null , "Resources/magnetshroom.webp");
    }

    @Override
    public void doYourJob()
    {
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
