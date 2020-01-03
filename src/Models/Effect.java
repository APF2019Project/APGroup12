package Models;

public class Effect
{
    private int slowDuration, stunDuration;
    private boolean slow, stun;

    public Effect()
    {

    }

    public Effect(int slowDuration, int stunDuration, boolean slow, boolean stun) {
        this.slowDuration = slowDuration;
        this.stunDuration = stunDuration;
        this.slow = slow;
        this.stun = stun;
    }

    public void merge(Effect effect)
    {
        this.slowDuration += effect.slowDuration;
        this.stunDuration += effect.stunDuration;
    }

    public int getSlowDuration() {
        return slowDuration;
    }

    public int getStunDuration() {
        return stunDuration;
    }

    public void decreaseSlowDuration() {
        if (slowDuration > 0) slowDuration--;
    }

    public void decreaseStunDuration() {
        if (slowDuration > 0) stunDuration--;
    }

    public boolean isSlow() {
        return slow;
    }

    public boolean isStun() {
        return stun;
    }
}
