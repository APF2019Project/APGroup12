package Models;

public class Threepeater extends AttackerPlant
{
    private AttackerPlant firstPea , secondPea , thirdPea;

    private Threepeater(String name, String type, int health, int coolDownTime, int requiredSuns, boolean cactus,
                Pea pea, int numberOfBulletsPerShoot, int coolDownForNextShoot, String direction, Cell coordination) {
        super(name, type, health, coolDownTime, requiredSuns, cactus, pea, numberOfBulletsPerShoot,
                coolDownForNextShoot, direction, coordination);
        firstPea = null;
        secondPea = null;
        thirdPea = null;
    }

    public static void putThreepeater(Cell coordination)
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(1 , false , effect);
        Threepeater threepeater = new Threepeater("Models.Threepeater" , "Land" , 5 , 4 , 3 ,
                false , pea , 1 , 4 , "Right" , coordination);

        int x = coordination.getX() , y = coordination.getY();
        Cell firstCo = coordination.getMap().getByCoordination(x - 1 , y);
        Cell secondCo = coordination.getMap().getByCoordination(x , y);
        Cell thirdCo = coordination.getMap().getByCoordination(x + 1 , y);

        if (firstCo != null)
        {
            threepeater.firstPea = new AttackerPlant("Models.Threepeater" , "Land" , 5 , 4 , 3 ,
                    false , pea , 1 , 4 , "Right" , firstCo);
        }

        if (secondCo != null)
        {
            threepeater.firstPea = new AttackerPlant("Models.Threepeater" , "Land" , 5 , 4 , 3 ,
                    false , pea , 1 , 4 , "Right" , secondCo);
        }

        if (thirdCo != null)
        {
            threepeater.firstPea = new AttackerPlant("Models.Threepeater" , "Land" , 5 , 4 , 3 ,
                    false , pea , 1 , 4 , "Right" , thirdCo);
        }
    }

    @Override
    public void doYourJob()
    {
        if (firstPea != null)
        {
            firstPea.doYourJob();
        }

        if (secondPea != null)
        {
            secondPea.doYourJob();
        }

        if (thirdPea != null)
        {
            thirdPea.doYourJob();
        }
    }
}
