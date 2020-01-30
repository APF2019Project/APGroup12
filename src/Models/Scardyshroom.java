package Models;

public class Scardyshroom extends AttackerPlant
{
    private Scardyshroom(String name, String type, int health, int coolDownTime, int requiredSuns, boolean cactus,
                 Pea pea, int numberOfBulletsPerShoot, int coolDownForNextShoot, String direction, Cell coordination,
                         String url) {
        super(name, type, health, coolDownTime, requiredSuns, cactus, pea, numberOfBulletsPerShoot,
                coolDownForNextShoot, direction, coordination , url);
    }

    @Override
    public Scardyshroom copy()
    {
        Scardyshroom res = new Scardyshroom(this.name , this.type , this.health , this.coolDownTime , this.requiredSuns ,
                this.cactus , this.pea , this.numberOfBulletsPerShoot , this.coolDownForNextShoot ,
                this.direction , null , this.url);

        this.copyCgi(res);
        return res;
    }

    public static Scardyshroom getScardyshroom()
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(1 , false , effect);
        return new Scardyshroom("Scaredy-shroom" , "Land" , 1 , 2 , 1 ,
                false , pea , 1 , 2 , "Right" , null ,
                "Resources/scardyshroom.webp");
    }

    @Override
    public void doYourJob()
    {
        if (coordination == null)
        {
            super.doYourJob();
            return;
        }

        Zombie target = coordination.getRightZombie(pea.isPierce());

        if (target == null || target.getCoordination().getY() - coordination.getY() <= 2)
        {
            return;
        }
        else {
            super.doYourJob();
        }
    }
}
