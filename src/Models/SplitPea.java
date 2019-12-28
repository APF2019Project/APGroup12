package Models;

public class SplitPea extends AttackerPlant
{
    private AttackerPlant firstPea , secondPea;

    private SplitPea(String name, String type, int health, int coolDownTime, int requiredSuns, boolean cactus,
                    Pea pea, int numberOfBulletsPerShoot, int coolDownForNextShoot, String direction, Cell coordination) {
        super(name, type, health, coolDownTime, requiredSuns, cactus, pea, numberOfBulletsPerShoot,
                coolDownForNextShoot, direction, coordination);
        firstPea = null;
        secondPea = null;
    }

    public static void putSplitPea(Cell coordination)
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(1 , false , effect);
        SplitPea splitPea = new SplitPea("Split Models.Pea" , "Land" , 3 , 4 , 4 ,
                false , pea , 1 , 2 , "Right" , coordination);

        splitPea.firstPea = new AttackerPlant("Split Models.Pea" , "Land" , 2 , 2 , 2 ,
                false , pea , 1 , 2 , "Right" , coordination);

        splitPea.firstPea = new AttackerPlant("Split Models.Pea" , "Land" , 4 , 4 , 3 ,
                false , pea , 2 , 3 , "Left" , coordination);
    }

    @Override
    public void doYourJob()
    {
        firstPea.doYourJob();
        secondPea.doYourJob();
    }
}
