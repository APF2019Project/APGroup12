package Models;

class Sunflower extends Plant
{
    private int numberOfGivenSuns , coolDownForNextSun;

    private Sunflower(String name, String type, int health, int coolDownTime, int requiredSuns, boolean cactus,
                      int numberOfGivenSuns, Cell coordination , String url)
    {
        super(name , type , health , coolDownTime , requiredSuns , cactus , coordination , url);
        this.numberOfGivenSuns = numberOfGivenSuns;
        coolDownForNextSun = 2;
    }

    @Override
    public Sunflower copy()
    {
        Sunflower res = new Sunflower(this.name , this.type , this.health , this.coolDownTime , this.requiredSuns ,
                this.cactus , this.numberOfGivenSuns , null , this.url);

        this.copyCgi(res);
        return res;
    }

    public static Sunflower getSunflower()
    {
        return new Sunflower("Sunflower" , "Land" , 2 , 2 , 1 ,
                false , 1 , null , "Resources/sunflower.webp");
    }

    public static Sunflower getTwinSunflower()
    {
        return new Sunflower("Twin Sunflower" , "Land" , 2 , 2 , 1 ,
                false , 2 , null , "Resources/twinsunflower.webp");
    }

    public void doYourJob()
    {
        if (coordination == null)
        {
            super.doYourJob();
            return;
        }

        if (coolDownForNextSun > 0)
        {
            coolDownForNextSun--;
            return;
        }

        coordination.getMap().addSun(numberOfGivenSuns);
        coolDownForNextSun = 2;
    }
}
