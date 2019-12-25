public class Effect
{
    private int slowTime , stopTime;
    private boolean slowEffect , stopEffect;

    public Effect(int slowTime, int stopTime, boolean slowEffect, boolean stopEffect) {
        this.slowTime = slowTime;
        this.stopTime = stopTime;
        this.slowEffect = slowEffect;
        this.stopEffect = stopEffect;
    }

    public int getSlowTime() {
        return slowTime;
    }

    public int getStopTime() {
        return stopTime;
    }

    public boolean isSlowEffect() {
        return slowEffect;
    }

    public boolean isStopEffect() {
        return stopEffect;
    }
}
