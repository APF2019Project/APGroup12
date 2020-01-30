package Models;

public class Plant extends Card
{
    protected int requiredSuns;
    protected int coolDownTime ;
    protected int currentCoolDownTime = 0;
    protected boolean cactus;
    private static Collection allPlants = new Collection();

    static {
        allCards.addAll(allPlants.getList());
    }

    protected Plant(String name, String type, int health, int coolDownTime, int requiredSuns, boolean cactus,
                    Cell coordination , String url)
    {
        super(name , type , health , coordination , url);
        this.coolDownTime = coolDownTime;
        this.requiredSuns = requiredSuns;
        this.cactus = cactus;
        this.price = ( this.requiredSuns * this.coolDownTime * this.health + 1 ) ;
    }

    public static void addAll() {
        allCards.addAll(allPlants.getList());
    }

    @Override
    public Plant copy()
    {
        Plant res = new Plant(this.name , this.type , this.health , this.coolDownTime , this.requiredSuns ,
                this.cactus , null , this.url);

        this.copyCgi(res);
        return res;
    }

    public static boolean putPlant(Plant plant, Cell coordination)
    {
        if (coordination.checkValidity(plant)) {
            Plant fresh = plant.copy();
            fresh.currentCoolDownTime = plant.coolDownTime;
            coordination.insertCard(fresh);
            return true;
        }

        return false;
    }

    public static Plant getPeashooter()
    {
        return AttackerPlant.getPeashooter();
    }

    public static Plant getSnowPea()
    {
        return AttackerPlant.getSnowPea();
    }

    public static Plant getCabbagepult()
    {
        return AttackerPlant.getCabbagepult();
    }

    public static Plant getRepeater()
    {
        return AttackerPlant.getRepeater();
    }

    public static Plant getThreepeater()
    {
        return AttackerPlant.getThreepeater();
    }

    public static Plant getCactus()
    {
        return AttackerPlant.getCactus();
    }

    public static Plant getGatlingPea()
    {
        return AttackerPlant.getGatlingPea();
    }

    public static Plant getScardyShroom()
    {
        return AttackerPlant.getScardyshroom();
    }

    public static Plant getKernelpult()
    {
        return AttackerPlant.getKernelpult();
    }

    public static Plant getSplitPea()
    {
        return AttackerPlant.getSplitPea();
    }

    public static Plant getExplodeonut()
    {
        return new Plant("Explode-o-nut" , "Land" , 3 , 5 , 4 , true ,
                null , "Resources/explodeonut.webp");
    }

    public static Plant getMelonpult()
    {
        return AttackerPlant.getMelonpult();
    }

    public static Plant getLilyPad()
    {
        return new Plant("Lily Pad" , "Water" , 1 , 1 , 0 , false ,
                null , "Resources/lilypad.webp");
    }

    public static Plant getWinterMelon()
    {
        return AttackerPlant.getWinterMelon();
    }

    public static Plant getWallnut()
    {
        return new Plant("Wall-nut" , "Land" , 4 , 4 , 2 , false ,
                null , "Resources/wallnut.webp");
    }

    public static Plant getTangleKelp()
    {
        return ExplosivePlant.getTangleKelp();
    }

    public static Plant getTallnut()
    {
        return new Plant("Tall-nut" , "Land" , 6 , 6 , 4 , false ,
                null , "Resources/tallnut.webp");
    }

    public static Plant getCattail()
    {
        return AttackerPlant.getCattail();
    }

    public static Plant getPotatoMine()
    {
        return ExplosivePlant.getPotatoMine();
    }

    public static Plant getCherryBomb() { return ExplosivePlant.getCherryBomb(); }

    public static Plant getMagnetshroom()
    {
        return Magnetshroom.getMagnetshroom();
    }

    public static Plant getSunflower()
    {
        return Sunflower.getSunflower();
    }

    public static Plant getTwinSunflower()
    {
        return Sunflower.getTwinSunflower();
    }

    public static Plant getJalapeno()
    {
        return ExplosivePlant.getJalapeno();
    }

    public void getEaten(Zombie zombie)
    {
        if (this instanceof ExplosivePlant)
        {
            if (name.equals("Potato Mine") || name.equals("Tangle Kelp"))
            {
                if (((ExplosivePlant) this).getDelay() == 0)
                {
                    coordination.killZombie(zombie);
                    coordination.vanishPlant();
                }
            }
        }

        if (cactus)
        {
            zombie.getHit(new Pea(1 , true , new Effect()));
        }

        health--;

        if (health == 0)
        {
            coordination.killPlant();
        }
    }

    public void getDestroyed()
    {
        coordination.killPlant();
    }

    @Override
    public void doYourJob()
    {
        if (currentCoolDownTime > 0)
        {
            currentCoolDownTime--;
        }

        super.doYourJob();
    }

    public boolean isCactus() {
        return cactus;
    }

    public int getRequiredSuns() {
        return requiredSuns;
    }

    public boolean ready() {
        return currentCoolDownTime == 0;
    }

    public int getCurrentCoolDownTime() {
        return currentCoolDownTime;
    }

    public int getCoolDownTime() {
        return coolDownTime;
    }

    public static Collection getAllPlants() {
        return allPlants;
    }
}
