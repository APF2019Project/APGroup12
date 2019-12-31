package Models;


public class ZombiePower {

    private boolean footballer ;
    private boolean bucketHead ;
    private boolean strongCar ;
    private boolean weakCar ;
    private boolean bungee ;
    private boolean balloon ;
    private boolean newspaper ;
    private boolean target ;
    private boolean screenDoor ;
    private boolean gigaGargantuar ;
    private boolean pogo ;
    private boolean snorkel ;
    private boolean dolphinRider ;



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
        else
            plant.setHealth( plant.getHealth() - 1 );
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
    public boolean isNewspaper() { return newspaper; }
    public void setNewspaper(boolean newspaper) { this.newspaper = newspaper; }
    public boolean isTarget() { return target; }
    public void setTarget(boolean target) { this.target = target; }
    public boolean isScreenDoor() { return screenDoor; }
    public void setScreenDoor(boolean screenDoor) { this.screenDoor = screenDoor; }
    public boolean isGigaGargantuar() { return gigaGargantuar ; }
    public void setGigaGargantuar(boolean gigaGargantuar) { this.gigaGargantuar = gigaGargantuar; }
    public boolean isPogo() { return pogo; }
    public void setPogo(boolean pogo) { this.pogo = pogo; }
    public boolean isSnorkel() { return snorkel; }
    public void setSnorkel(boolean snorkel) { this.snorkel = snorkel; }
    public boolean isDolphinRider() { return dolphinRider; }
    public void setDolphinRider(boolean dolphinRider) { this.dolphinRider = dolphinRider; }


}
