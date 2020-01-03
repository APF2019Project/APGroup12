package Models;

public class Scardyshroom extends AttackerPlant
{
    private Scardyshroom(String name, String type, int health, int coolDownTime, int requiredSuns, boolean cactus,
                 Pea pea, int numberOfBulletsPerShoot, int coolDownForNextShoot, String direction, Cell coordination) {
        super(name, type, health, coolDownTime, requiredSuns, cactus, pea, numberOfBulletsPerShoot,
                coolDownForNextShoot, direction, coordination);
    }

    @Override
    public Scardyshroom copy()
    {
        return new Scardyshroom(this.name , this.type , this.health , this.coolDownTime , this.requiredSuns ,
                this.cactus , this.pea , this.numberOfBulletsPerShoot , this.coolDownForNextShoot ,
                this.direction , null);
    }

    public static Scardyshroom getScardyshroom()
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(1 , false , effect);
        return new Scardyshroom("Scaredy-shroom" , "Land" , 1 , 2 , 1 ,
                false , pea , 1 , 2 , "Right" , null);
    }

    @Override
    public void doYourJob()
    {
        if (coordination == null)
        {
            super.doYourJob();
            return;
        }

        Zombie target = coordination.getRightZombie();

        if (target.getCoordination().getX() - coordination.getX() <= 2)
        {
            return;
        }
        else {
            super.doYourJob();
        }
    }
}
