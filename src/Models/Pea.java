package Models;

public class Pea
{
    private Effect effect;
    private int damagePerShoot;
    private boolean pierce;

    public Pea(int damagePerShoot, boolean pierce, Effect effect) {
        this.effect = effect;
        this.damagePerShoot = damagePerShoot;
        this.pierce = pierce;
    }

    public Effect getEffect() {
        return effect;
    }

    public int getDamagePerShoot() {
        return damagePerShoot;
    }

    public boolean isPierce() {
        return pierce;
    }
}
