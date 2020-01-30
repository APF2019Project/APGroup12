package Models;

import java.util.ArrayList;
import java.util.Random;

public class Zombie extends Card
{
    private int bungeeTimer = 0;
    private int shield;
    private int speed;
    private int passedTurnsAfterUse ;  // for check coolDown
    private ZombiePower powers = new ZombiePower();
    private Effect effect = new Effect();
    private static Collection allZombies = new Collection();

    static {
        allCards.addAll(allZombies.getList());
    }

    private Zombie(String type , String name , int health, int speed , int shield , ZombiePower powers ,
                   Cell coordination , String url) {
        super(name , type , health , coordination , url);
        this.speed = speed;
        this.shield = shield;
        this.powers = powers;
        this.price = ( ( 1 + this.speed ) * this.health * 10 ) ;
    }

    private Zombie(String type , String name , int health, int speed , int shield , ZombiePower powers ,
                   Cell coordination) {
        super(name , type , health , coordination);
        this.speed = speed;
        this.shield = shield;
        this.powers = powers;
        this.price = ( ( 1 + this.speed ) * this.health * 10 ) ;
    }

    public static void addAll() {
        allCards.addAll(allZombies.getList());
    }

    @Override
    public Zombie copy()
    {
        Zombie res = new Zombie(this.type , this.name , this.health , this.speed , this.shield , this.powers.copy() ,
                null , this.url);

        this.copyCgi(res);
        return res;
    }

    public static boolean putZombie(Zombie zombie , Cell coordination)
    {
        Cell resCo = coordination;

        if (zombie.getPowers().isBungee())
        {
            Random random = new Random();
            resCo = coordination.getMap().getByCoordination(coordination.getX() , random.nextInt(19) + 1);
        }

        if (resCo.checkValidity(zombie))
        {
            Zombie fresh = zombie.copy();
            resCo.insertCard(fresh);
            return true;
        }

        return false;
    }

    public static Zombie getZombie()
    {
        ZombiePower zombiePower = new ZombiePower();
        return new Zombie("Land" , "Zombie" , 2 , 2 , 0 , zombiePower , null ,
        "Resources/zombie.webp");
    }

    public static Zombie getFootballZombie()
    {
        ZombiePower zombiePower = new ZombiePower();
        zombiePower.setFootballer(true);
        return new Zombie("Land" , "Football Zombie" , 4 , 3 , 0 , zombiePower , null);
    }

    public static Zombie getBucketheadZombie()
    {
        ZombiePower zombiePower = new ZombiePower();
        zombiePower.setBucketHead(true);
        return new Zombie("Land" , "Buckethead Zombie" , 3 , 2 , 0 , zombiePower , null);
    }

    public static Zombie getConeheadZombie()
    {
        ZombiePower zombiePower = new ZombiePower();
        return new Zombie("Land" , "Conehead Zombie" , 3 , 2 , 0 , zombiePower , null);
    }

    public static Zombie getZomboni()
    {
        ZombiePower zombiePower = new ZombiePower();
        zombiePower.setStrongCar(true);
        return new Zombie("Land" , "Zomboni" , 3 , 2 , 0 , zombiePower , null);
    }

    public static Zombie getCatapultZombie()
    {
        ZombiePower zombiePower = new ZombiePower();
        zombiePower.setWeakCar(true);
        return new Zombie("Land" , "Catapult Zombie" , 3 , 2 , 0 , zombiePower , null);
    }

    public static Zombie getBungeeZombie()
    {
        ZombiePower zombiePower = new ZombiePower();
        zombiePower.setBungee(true);
        return new Zombie("Land" , "Bungee Zombie" , 3 , 0 , 0 , zombiePower , null);
    }

    public static Zombie getBalloonZombie()
    {
        ZombiePower zombiePower = new ZombiePower();
        zombiePower.setBalloon(true);
        return new Zombie("Land" , "Balloon Zombie" , 3 , 2 , 0 , zombiePower , null);
    }

    public static Zombie getNewspaperZombie()
    {
        ZombiePower zombiePower = new ZombiePower();
        return new Zombie("Land" , "Newspaper Zombie" , 2 , 2 , 2 , zombiePower , null);
    }

    public static Zombie getTargetZombie()
    {
        ZombiePower zombiePower = new ZombiePower();
        zombiePower.setScreenDoor(true);
        return new Zombie("Land" , "Target Zombie" , 3 , 2 , 3 , zombiePower , null);
    }

    public static Zombie getScreenDoorZombie()
    {
        ZombiePower zombiePower = new ZombiePower();
        return new Zombie("Land" , "Screen Door Zombie" , 3 , 2 , 4 , zombiePower , null);
    }

    public static Zombie getGigagargantuar()
    {
        ZombiePower zombiePower = new ZombiePower();
        zombiePower.setGigaGargantuar(true);
        return new Zombie("Land" , "Giga-gargantuar" , 6 , 1 , 0 , zombiePower , null);
    }

    public static Zombie getPogoZombie()
    {
        ZombiePower zombiePower = new ZombiePower();
        zombiePower.setPogo(true);
        return new Zombie("Land" , "Pogo Zombie" , 2 , 2 , 0 , zombiePower , null);
    }

    public static Zombie getSnorkelZombie()
    {
        ZombiePower zombiePower = new ZombiePower();
        zombiePower.setSnorkel(true);
        return new Zombie("Water" , "Snorkel Zombie" , 2 , 2 , 0 , zombiePower , null);
    }

    public static Zombie getDolphinRiderZombie()
    {
        ZombiePower zombiePower = new ZombiePower();
        zombiePower.setSnorkel(true);
        return new Zombie("Water" , "Dolphin Rider Zombie" , 2 , 2 , 2 , zombiePower , null);
    }

    public void getHit(Pea pea)
    {
        if (this.getPowers().isBalloon() && !pea.isPierce())
        {
            return;
        }

        effect.merge(pea.getEffect());

        if (shield > 0 && !pea.isPierce())
        {
            if (shield <= pea.getDamagePerShoot())
            {
                shield = 0;
            }
            else
            {
                shield -= pea.getDamagePerShoot();
            }

            return;
        }

        health -= pea.getDamagePerShoot();

        if (health <= 0)
        {
            coordination.killZombie(this);

            if (this.getPowers().isStrongCar())
            {
                putZombie(getZombie() , coordination);
            }
        }
    }

    private void hitPlant(Plant plant)
    {
        if (powers.isGigaGargantuar() || powers.isStrongCar() || powers.isWeakCar())
        {
            plant.getDestroyed();
            return;
        }

        if (powers.isPogo())
        {
            return;
        }

        plant.getEaten(this);
    }

    private void move()
    {
        int x = coordination.getX() , y = coordination.getY();
        coordination.clear(this);
        coordination.getMap().getByCoordination(x , y - 1).insertCard(this);
    }

    private void partyTime(int x)
    {
        if (coordination.getMap().getJaroo(x))
        {
            coordination.getMap().jarooUp(x);
        }
        else {
            coordination.clear(this);
            coordination.getMap().eatBrain();
        }
    }

    public void getDestroyed()
    {
        coordination.killZombie(this);
    }

    public void doYourJob()
    {
        if (coordination == null)
        {
            super.doYourJob();
            return;
        }

        if (powers.isBungee())
        {
            //System.out.println(":OO " + this.coordination.getX() + " " + this.coordination.getY() + " " + bungeeTimer);

            if (bungeeTimer == 3)
            {
                if (coordination.getAsset() instanceof Plant) {
                    coordination.killPlant();
                }

                coordination.vanishZombie(this);
                return;
            }

            bungeeTimer++;
        }

        int curSpeed = speed;

        if (effect.getSlowDuration() > 0) {
            curSpeed /= 2;
            effect.decreaseSlowDuration();
        }

        if (effect.getStunDuration() > 0)
        {
            effect.decreaseStunDuration();
            return;
        }

        for (int i = 0; i < curSpeed; i++) {
            int x = coordination.getX(), y = coordination.getY();

            if (y == 1) {
                partyTime(x);
                break;
            } else {
                if (coordination.getMap().getByCoordination(x, y - 1).getAsset() instanceof Plant) {
                    hitPlant((Plant) (coordination.getMap().getByCoordination(x, y - 1).getAsset()));

                    if (powers.isWeakCar() || powers.isStrongCar()) {
                        move();
                    }
                    else {
                        if (powers.isPogo()) {
                            move();
                            move();
                        }
                        else {
                            break;
                        }
                    }
                } else {
                    move();
                }
            }
        }
    }

    public static ArrayList<Zombie> getAWave(Collection zombieHand){
        Random random = new Random();
        int waveSize = ( random.nextInt(7) + 4 ) ;
        ArrayList<Zombie> waveZombies = new ArrayList<>( waveSize );
        for( int i = 0 ; i < waveSize ; i++ ){
            int index = random.nextInt(zombieHand.getSize()) + 1;
            waveZombies.add((Zombie)(zombieHand.getCard(index)));
        }
        return waveZombies ;
    }

    public void setZombiePrice(){
        int price = ( (1 + this.speed ) * this.health * 10 ) ;
        this.setPrice( price );
    }

    public int getPassedTurnsAfterUse() { return passedTurnsAfterUse; }
    public void setPassedTurnsAfterUse(int passedTurnsAfterUse) { this.passedTurnsAfterUse = passedTurnsAfterUse; }
    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }
    public int getShield() { return shield; }
    public void setShield(int shield) { this.shield = shield; }
    public ZombiePower getPowers() {return powers;}
    public static Collection getAllZombies() { return allZombies; }
    public int getRequiredCoins() {
        return 10 * speed;
    }
}