package Models;

import java.util.ArrayList;
import java.util.Random;

public class Zombie extends Card{
    private int speed ;
    private int price ;
    private int health ;
    private int coolDownTime ;
    private int passedTurnsAfterUse ;  // for check coolDown
    private ArrayList<ZombiePower> powers = new ArrayList<>();

    private static ArrayList<Zombie> allZombies = new ArrayList<>() ;

    public void doYourJob( Plant plant ){
        for (ZombiePower power : this.getPowers())
            power.makeYourEffect(plant);

    }

    public static ArrayList<Zombie> getAWave( ArrayList<Zombie> gameZombies){
        Random random = new Random();
        int waveSize = ( random.nextInt(7) + 4 ) ;
        ArrayList<Zombie> waveZombies = new ArrayList<>( waveSize );
        for( int i = 0 ; i < waveSize ; i++ ){
            int index = random.nextInt( gameZombies.size() );
            waveZombies.add( gameZombies.get(index) ) ;
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
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public int gethealth() { return health; }
    public void sethealth(int health) { this.health = health; }
    public int getCoolDownTime() { return coolDownTime; }
    public void setCoolDownTime(int coolDownTime) { this.coolDownTime = coolDownTime; }
    public ArrayList<ZombiePower> getPowers() {return powers; }
    public static ArrayList<Zombie> getAllZombies() { return allZombies; }
    public static void setAllZombies(ArrayList<Zombie> allZombies) { Zombie.allZombies = allZombies; }

}
