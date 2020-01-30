package Models;

public class SplitPea extends AttackerPlant
{
    private AttackerPlant firstPea , secondPea;

    private SplitPea(String name, String type, int health, int coolDownTime, int requiredSuns, boolean cactus,
                     Pea pea, int numberOfBulletsPerShoot, int coolDownForNextShoot, String direction, Cell coordination,
                     String url) {
        super(name, type, health, coolDownTime, requiredSuns, cactus, pea, numberOfBulletsPerShoot,
                coolDownForNextShoot, direction, coordination, url);
        firstPea = null;
        secondPea = null;
    }

    @Override
    public SplitPea copy()
    {
        SplitPea splitPea = new SplitPea(this.name , this.type , this.health , this.coolDownTime , this.requiredSuns ,
                this.cactus , this.pea , this.numberOfBulletsPerShoot , this.coolDownForNextShoot ,
                this.direction , null , this.url);

        splitPea.firstPea = this.firstPea.copy();
        splitPea.secondPea = this.secondPea.copy();

        this.copyCgi(splitPea);
        return splitPea;
    }

    public static SplitPea getSplitPea()
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(1 , false , effect);
        SplitPea splitPea = new SplitPea("Split Pea" , "Land" , 3 , 4 , 4 ,
                false , pea , 1 , 2 , "Right" , null ,
                "Resources/splitpea.webp");

        splitPea.firstPea = AttackerPlant.getPeashooter();
        splitPea.secondPea = new AttackerPlant("Repeater" , "Land" , 4 , 4 , 3 ,
                false , pea , 2 , 3 , "Left" , null , null);

        return splitPea;
    }

    @Override
    public void doYourJob()
    {
        if (coordination == null)
        {
            super.doYourJob();
            return;
        }

        firstPea.doYourJob();
        secondPea.doYourJob();
    }

    @Override
    public void setCoordination(Cell coordination)
    {
        this.coordination = coordination;
        firstPea.setCoordination(coordination);
        secondPea.setCoordination(coordination);
    }
}
