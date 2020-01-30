package Models;

import java.util.Random;

public class RailMode extends Day
{
    private Collection hand = new Collection();
    private int gimme = 0 , dontGimme = 0 , nextGift , nextZombie;

    private RailMode(Map map , Collection plantHand , Collection zombieHand)
    {
        super(map , plantHand , zombieHand);

        Random random = new Random();
        nextGift = random.nextInt(3) + 2;
        nextZombie = random.nextInt(3) + 3;
    }

    public static RailMode createRailMode(Map map , Collection plantHand , Collection zombieHand)
    {
        return new RailMode(map , plantHand , zombieHand);
    }

    private void getGift()
    {
        if (hand.getSize() < 10) {
            hand.add((Plant)(Card.getRandomCard(plantHand)));
        }

        Random random = new Random();
        gimme = 0;
        nextGift = random.nextInt(3) + 2;
    }

    private void zombieArrival()
    {
        Random random = new Random();
        int row = random.nextInt(6) + 1;
        Cell coordination = map.getByCoordination(row , 20);
        while (!Zombie.putZombie((Zombie)(Card.getRandomCard(zombieHand)) , coordination));
        dontGimme = 0;
        nextZombie = random.nextInt(3) + 3;
    }

    @Override
    public void showHand()
    {
        hand.show();
    }

    @Override
    public void select(String name)
    {
        Plant plant = (Plant)hand.getCard(name);
        checkAndGet(plant);
    }

    @Override
    public void select(int position)
    {
        Plant plant = (Plant)hand.getCard(position);
        checkAndGet(plant);
    }

    @Override
    public boolean plant(int x , int y)
    {
        Plant z = selectedCard;

        if (super.plant(x , y)) {
            (hand).remove(z);
            return true;
        }

        return false;
    }

    @Override
    public void endTurn()
    {
        super.endTurn();

        if (!map.hasBrain())
        {
            youHaveLost();
        }

        if (gimme == nextGift)
        {
            getGift();
        }

        if (dontGimme == nextZombie)
        {
            zombieArrival();
        }

        gimme++;
        dontGimme++;
    }

    public int getNextGift() {
        return nextGift;
    }

    public int getNextZombie() {
        return nextZombie;
    }
}
