package Models;

public class Effect
{
    private int slowDuration, stunDuration;
    private boolean slow, stun;

    public Effect(int slowDuration, int stunDuration, boolean slow, boolean stun) {
        this.slowDuration = slowDuration;
        this.stunDuration = stunDuration;
        this.slow = slow;
        this.stun = stun;
    }

    public int getSlowDuration() {
        return slowDuration;
    }

    public int getStunDuration() {
        return stunDuration;
    }

    public boolean isSlow() {
        return slow;
    }

    public boolean isStun() {
        return stun;
    }
}
