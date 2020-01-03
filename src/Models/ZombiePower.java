package Models;

public class ZombiePower {

    private boolean footballer ;
    private boolean bucketHead ;
    private boolean strongCar ;
    private boolean weakCar ;
    private boolean bungee ;
    private boolean balloon ;
    private boolean screenDoor;
    private boolean gigaGargantuar ;
    private boolean pogo ;
    private boolean snorkel ;

    public ZombiePower()
    {

    }

    public ZombiePower(boolean footballer, boolean bucketHead, boolean strongCar, boolean weakCar, boolean bungee,
                       boolean balloon, boolean screenDoor, boolean gigaGargantuar, boolean pogo, boolean snorkel) {
        this.footballer = footballer;
        this.bucketHead = bucketHead;
        this.strongCar = strongCar;
        this.weakCar = weakCar;
        this.bungee = bungee;
        this.balloon = balloon;
        this.screenDoor = screenDoor;
        this.gigaGargantuar = gigaGargantuar;
        this.pogo = pogo;
        this.snorkel = snorkel;
    }

    public ZombiePower copy()
    {
        return new ZombiePower(this.footballer , this.bucketHead , this.strongCar , this.weakCar , this.bungee ,
                this.balloon , this.screenDoor , this.gigaGargantuar , this.pogo , this.snorkel);
    }

    public void makeYourEffect( Plant plant ){

        if( this.bungee ){
            // write it later
        }
        else if( this.gigaGargantuar ){
            plant.setHealth( 0 );                             // kill plant
        }
        else if ( this.pogo ){
            // write it later
        }
    }

    public boolean isFootballer() { return footballer; }
    public void setFootballer(boolean footballer) { this.footballer = footballer; }
    public boolean isBucketHead() { return bucketHead; }
    public void setBucketHead(boolean bucketHead) { this.bucketHead = bucketHead; }
    public boolean isStrongCar() { return strongCar; }
    public void setStrongCar(boolean strongCar) { this.strongCar = strongCar; }
    public boolean isWeakCar() { return weakCar; }
    public void setWeakCar(boolean weakCar) { this.weakCar = weakCar; }
    public boolean isBungee() { return bungee; }
    public void setBungee(boolean bungee) { this.bungee = bungee; }
    public boolean isBalloon() { return balloon; }
    public void setBalloon(boolean balloon) { this.balloon = balloon; }
    public boolean isScreenDoor() { return screenDoor; }
    public void setScreenDoor(boolean screenDoor) { this.screenDoor = screenDoor; }
    public boolean isGigaGargantuar() { return gigaGargantuar ; }
    public void setGigaGargantuar(boolean gigaGargantuar) { this.gigaGargantuar = gigaGargantuar; }
    public boolean isPogo() { return pogo; }
    public void setPogo(boolean pogo) { this.pogo = pogo; }
    public boolean isSnorkel() { return snorkel; }
    public void setSnorkel(boolean snorkel) { this.snorkel = snorkel; }
}