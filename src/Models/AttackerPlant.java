package Models;

public class AttackerPlant extends Plant
{
    private Pea pea;
    private int numberOfBulletsPerShoot, coolDownForNextShoot , currentCoolDownForNextShoot;
    private String direction;

    protected AttackerPlant(String name, String type, int health, int coolDownTime, int requiredSuns, boolean cactus,
                  Pea pea, int numberOfBulletsPerShoot, int coolDownForNextShoot, String direction, Cell coordination)
    {
        super(name , type , health , coolDownTime , requiredSuns , cactus , coordination);
        this.pea = pea;
        this.numberOfBulletsPerShoot = numberOfBulletsPerShoot;
        this.coolDownForNextShoot = coolDownForNextShoot;
        this.currentCoolDownForNextShoot = 0;
        this.direction = direction;
    }

    public static void putPeashooter(Cell coordination)
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(1 , false , effect);
        coordination.insertCard(new AttackerPlant("Peashooter" , "Land" , 2 , 2 , 2 ,
                false , pea , 1 , 2 , "Right" , coordination));
    }

    public static void putSnowPea(Cell coordination)
    {
        Effect effect = new Effect(3 , 0 , true , false);
        Pea pea = new Pea(1 , false , effect);
        coordination.insertCard(new AttackerPlant("Snow Models.Pea" , "Land" , 3 , 3 , 3 ,
                false , pea , 1 , 3 , "Right" , coordination));
    }

    public static void putCabbagepult(Cell coordination)
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(2 , true , effect);
        coordination.insertCard(new AttackerPlant("Cabbage-pult" , "Land" , 2 , 3 , 2 ,
                false , pea , 1 , 2 , "Right" , coordination));
    }

    public static void putRepeater(Cell coordination)
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(1 , false , effect);
        coordination.insertCard(new AttackerPlant("Repeater" , "Land" , 4 , 4 , 3 ,
                false , pea , 2 , 3 , "Right" , coordination));
    }

    public static void putThreepeater(Cell coordination)
    {

    }

    public static void putCactus(Cell coordination)
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(1 , false , effect);
        coordination.insertCard(new AttackerPlant("Cactus" , "Land" , 5 , 4 , 5 ,
                true , pea , 1 , 2 , "Right" , coordination));
    }

    public static void putGatlingPea(Cell coordination)
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(1 , false , effect);
        coordination.insertCard(new AttackerPlant("Gatling Models.Pea" , "Land" , 3 , 4 , 5 ,
                false , pea , 4 , 5 , "Right" , coordination));
    }

    public static void putScardyShroom(Cell coordination)
    {

    }

    public static void putKernelpult(Cell coordination)
    {
        Effect effect = new Effect(0 , 2 , false , true);
        Pea pea = new Pea(0 , true , effect);
        coordination.insertCard(new AttackerPlant("Kernel-pult" , "Land" , 2 , 3 , 3 ,
                false , pea , 1 , 4 , "Right" , coordination));
    }

    public static void putMelonpult(Cell coordination)
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(3 , true , effect);
        coordination.insertCard(new AttackerPlant("Melon-pult" , "Land" , 3 , 3 , 3 ,
                false , pea , 1 , 4 , "Right" , coordination));
    }

    public static void putWinterMelon(Cell coordination)
    {
        Effect effect = new Effect(3 , 0 , true , false);
        Pea pea = new Pea(3 , true , effect);
        coordination.insertCard(new AttackerPlant("Winter Melon" , "Land" , 3 , 5 , 4 ,
                false , pea , 1 , 4 , "Right" , coordination));
    }

    public static void putCattail(Cell coordination)
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(1 , false , effect);
        coordination.insertCard(new AttackerPlant("Cattail" , "Land" , 3 , 5 , 5 ,
                false , pea , 1 , 4 , "Closest" , coordination));
    }

    @Override
    public void doYourJob()
    {
        super.doYourJob();

        if (currentCoolDownForNextShoot > 0)
        {
            currentCoolDownForNextShoot--;
            return;
        }
        Zombie target = null;

        switch (direction){
            case "Right":
                target = coordination.getRightZombie();
                break;
            case "Left":
                target = coordination.getLeftZombie();
                break;
            case "Closest":
                target = coordination.getClosestZombie();
                break;
        }

        if (target == null)
        {
            return;
        }

        currentCoolDownForNextShoot = coolDownForNextShoot;

        for (int i = 0; i < numberOfBulletsPerShoot; i++)
        {
            target.getHit(pea);
        }
    }

    public Pea getPea() {
        return pea;
    }

    public int getNumberOfBulletsPerShoot() {
        return numberOfBulletsPerShoot;
    }

    public int getCoolDownForNextShoot() {
        return coolDownForNextShoot;
    }

    public int getCurrentCoolDownForNextShoot() {
        return currentCoolDownForNextShoot;
    }

    public String getDirection() {
        return direction;
    }
}