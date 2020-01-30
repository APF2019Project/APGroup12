package Models;

public class Threepeater extends AttackerPlant
{
    private AttackerPlant firstPea , secondPea , thirdPea;

    private Threepeater(String name, String type, int health, int coolDownTime, int requiredSuns, boolean cactus,
                Pea pea, int numberOfBulletsPerShoot, int coolDownForNextShoot, String direction, Cell coordination,
                        String url) {
        super(name, type, health, coolDownTime, requiredSuns, cactus, pea, numberOfBulletsPerShoot,
                coolDownForNextShoot, direction, coordination , url);
        firstPea = null;
        secondPea = null;
        thirdPea = null;
    }

    @Override
    public Threepeater copy()
    {
        Threepeater threepeater = new Threepeater(this.name , this.type , this.health , this.coolDownTime , this.requiredSuns ,
                this.cactus , this.pea , this.numberOfBulletsPerShoot , this.coolDownForNextShoot ,
                this.direction , null , this.url);

        threepeater.firstPea = this.firstPea.copy();
        threepeater.secondPea = this.secondPea.copy();
        threepeater.thirdPea = this.thirdPea.copy();

        this.copyCgi(threepeater);
        return threepeater;
    }

    public static Threepeater getThreepeater()
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(1 , false , effect);
        Threepeater threepeater = new Threepeater("Threepeater" , "Land" , 5 , 4 , 3 ,
                false , pea , 1 , 4 , "Right" , null ,
                "Resources/threepeater.webp");

        threepeater.firstPea = AttackerPlant.getPeashooter();
        threepeater.secondPea = AttackerPlant.getPeashooter();
        threepeater.thirdPea = AttackerPlant.getPeashooter();

        return threepeater;
    }

    @Override
    public void doYourJob()
    {
        if (coordination == null)
        {
            super.doYourJob();
            return;
        }

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

    @Override
    public void setCoordination(Cell coordination)
    {
        int x = coordination.getX() , y = coordination.getY();
        this.coordination = coordination;
        firstPea.coordination = coordination.getMap().getByCoordination(x - 1 , y);
        secondPea.coordination = coordination.getMap().getByCoordination(x , y);
        thirdPea.coordination = coordination.getMap().getByCoordination(x + 1 , y);
    }
}
