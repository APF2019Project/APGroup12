package Models;

import java.util.ArrayList;

public class Plant extends Card
{
    protected int requiredSuns;
    protected boolean cactus;

    protected Plant(String name, String type, int health, int coolDownTime, int requiredSuns, boolean cactus,
                    Cell coordination)
    {
        super(name , type , health , coolDownTime , coordination);
        this.requiredSuns = requiredSuns;
        this.cactus = cactus;
    }

    public static void putPeashooter(Cell coordination)
    {

    }

    public static void putSnowPea(Cell coordination)
    {

    }

    public static void putCabbagepult(Cell coordination)
    {

    }

    public static void putRepeater(Cell coordination)
    {

    }

    public static void putThreepeater(Cell coordination)
    {

    }

    public static void putCactus(Cell coordination)
    {

    }

    public static void putGatlingPea(Cell coordination)
    {
    }

    public static void putScardyShroom(Cell coordination)
    {

    }

    public static void putKernelpult(Cell coordination)
    {

    }

    public static void putSplitPea(Cell coordination)
    {

    }

    public static void putExplodeonut(Cell coordination)
    {
        coordination.insertCard(new Plant("Explode-o-nut" , "Land" , 3 , 5 ,
                4 , true ,  coordination));
    }

    public static void putMelonpult(Cell coordination)
    {

    }

    public static void putLilyPad(Cell coordination)
    {
        coordination.insertCard(new Plant("Lily Pad" , "Water" , 1 , 1 ,
                0 , false ,  coordination));
    }

    public static void putWinterMelon(Cell coordination)
    {

    }

    public static void putWallnut(Cell coordination)
    {
        coordination.insertCard(new Plant("Wall-nut" , "Land" , 4 , 4 ,
                2 , false ,  coordination));
    }

    public static void putTangleKelp(Cell coordination)
    {

    }

    public static void putTallnut(Cell coordination)
    {
        coordination.insertCard(new Plant("Tall-nut" , "Land" , 6 , 6 ,
                4 , false ,  coordination));
    }

    public static void putCattail(Cell coordination)
    {

    }

    public static void putPotatoMine(Cell coordination)
    {

    }

    public static void putCherryBomb(Cell coordination)
    {

    }

    public static void putMagnetshroom(Cell coordination)
    {

    }

    public static void putSunflower(Cell coordination)
    {

    }

    public static void putTwinSunflower(Cell coordination)
    {

    }

    public static void putJalapeno(Cell coordination)
    {

    }

    @Override
    public void doYourJob()
    {
        super.doYourJob();
    }

    public boolean isCactus() {
        return cactus;
    }

    public int getRequiredSuns() {
        return requiredSuns;
    }
}
