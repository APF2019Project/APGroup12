package Models;

public class AttackerPlant extends Plant
{
    protected Pea pea;
    protected int numberOfBulletsPerShoot, coolDownForNextShoot , currentCoolDownForNextShoot;
    protected String direction;

    protected AttackerPlant(String name, String type, int health, int coolDownTime, int requiredSuns, boolean cactus,
                            Pea pea, int numberOfBulletsPerShoot, int coolDownForNextShoot, String direction, Cell coordination,
                            String url)
    {
        super(name , type , health , coolDownTime , requiredSuns , cactus , coordination , url);
        this.pea = pea;
        this.numberOfBulletsPerShoot = numberOfBulletsPerShoot;
        this.coolDownForNextShoot = coolDownForNextShoot;
        this.currentCoolDownForNextShoot = 0;
        this.direction = direction;
    }

    @Override
    public AttackerPlant copy()
    {
        AttackerPlant res = new AttackerPlant(this.name , this.type , this.health , this.coolDownTime , this.requiredSuns ,
                this.cactus , this.pea , this.numberOfBulletsPerShoot , this.coolDownForNextShoot ,
                this.direction , null , this.url);

        this.copyCgi(res);
        return res;
    }

    public static AttackerPlant getPeashooter()
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(1 , false , effect);
        return new AttackerPlant("Peashooter" , "Land" , 2 , 2 , 2 ,
                false , pea , 1 , 2 , "Right" , null ,
                "Resources/peashooter.webp");
    }

    public static AttackerPlant getSnowPea()
    {
        Effect effect = new Effect(3 , 0 , true , false);
        Pea pea = new Pea(1 , false , effect);
        return new AttackerPlant("Snow Pea" , "Land" , 3 , 3 , 3 ,
                false , pea , 1 , 3 , "Right" , null ,
                "Resources/snowpea.webp");
    }

    public static AttackerPlant getCabbagepult()
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(2 , true , effect);
        return new AttackerPlant("Cabbage-pult" , "Land" , 2 , 3 , 2 ,
                false , pea , 1 , 2 , "Right" , null ,
                "Resources/cabbagepult.webp");
    }

    public static AttackerPlant getRepeater()
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(1 , false , effect);
        return new AttackerPlant("Repeater" , "Land" , 4 , 4 , 3 ,
                false , pea , 2 , 3 , "Right" , null ,
                "Resources/repeater.webp");
    }

    public static AttackerPlant getThreepeater()
    {
        return Threepeater.getThreepeater();
    }

    public static AttackerPlant getCactus()
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(1 , false , effect);
        return new AttackerPlant("Cactus" , "Land" , 5 , 4 , 5 ,
                true , pea , 1 , 2 , "Right" , null ,
                "Resources/cactus.webp");
    }

    public static AttackerPlant getGatlingPea()
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(1 , false , effect);
        return new AttackerPlant("Gatling Pea" , "Land" , 3 , 4 , 5 ,
                false , pea , 4 , 5 , "Right" , null ,
                "Resources/gatlingpea.webp");
    }

    public static AttackerPlant getScardyshroom()
    {
        return Scardyshroom.getScardyshroom();
    }

    public static AttackerPlant getKernelpult()
    {
        Effect effect = new Effect(0 , 2 , false , true);
        Pea pea = new Pea(0 , true , effect);
        return new AttackerPlant("Kernel-pult" , "Land" , 2 , 3 , 3 ,
                false , pea , 1 , 4 , "Right" , null ,
                "Resources/kernelpult.webp");
    }

    public static AttackerPlant getSplitPea()
    {
        return SplitPea.getSplitPea();
    }

    public static AttackerPlant getMelonpult()
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(3 , true , effect);
        return new AttackerPlant("Melon-pult" , "Land" , 3 , 3 , 3 ,
                false , pea , 1 , 4 , "Right" , null ,
                "Resources/melonpult.webp");
    }

    public static AttackerPlant getWinterMelon()
    {
        Effect effect = new Effect(3 , 0 , true , false);
        Pea pea = new Pea(3 , true , effect);
        return new AttackerPlant("Winter Melon" , "Land" , 3 , 5 , 4 ,
                false , pea , 1 , 4 , "Right" , null ,
                "Resources/wintermelon.webp");
    }

    public static AttackerPlant getCattail()
    {
        Effect effect = new Effect(0 , 0 , false , false);
        Pea pea = new Pea(1 , false , effect);
        return new AttackerPlant("Cattail" , "Land" , 3 , 5 , 5 ,
                false , pea , 1 , 4 , "Closest" , null ,
                "Resources/cattail.webp");
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

        if (currentCoolDownForNextShoot > 0)
        {
            currentCoolDownForNextShoot--;
            return;
        }

        Zombie target = null;

        switch (direction){
            case "Right":
                target = coordination.getRightZombie(pea.isPierce());
                break;
            case "Left":
                target = coordination.getLeftZombie(pea.isPierce());
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