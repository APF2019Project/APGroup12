package Models;

public class Scardyshroom extends AttackerPlant
{
    private Scardyshroom(String name, String type, int health, int coolDownTime, int requiredSuns, boolean cactus,
                 Pea pea, int numberOfBulletsPerShoot, int coolDownForNextShoot, String direction, Cell coordination) {
        super(name, type, health, coolDownTime, requiredSuns, cactus, pea, numberOfBulletsPerShoot,
                coolDownForNextShoot, direction, coordination);
    }

    public static void putScardyshroom(Cell coordination)
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(1 , false , effect);
        coordination.insertCard(new Scardyshroom("Scardy-shroom" , "Land" , 1 , 2 , 1 ,
                false , pea , 1 , 2 , "Right" , coordination));
    }

    @Override
    public void doYourJob()
    {
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
