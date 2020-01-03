package Models;

import java.util.Random;

public class DayMode extends Day
{
    private int suns , lastWave = 0 , passedWaves = 0 , gimme = 0 , nextGift;
    private boolean pvp;

    private DayMode(Map map, Collection plantHand , Collection zombieHand , boolean pvp)
    {
        super(map, plantHand , zombieHand);
        this.pvp = pvp;
        suns = 2;

        if (pvp) {
            nextGift = 1;
        }
        else {
            Random random = new Random();
            nextGift = random.nextInt(2) + 1;
        }
    }

    public static DayMode createDayMode(Map map , Collection plantHand , Collection zombieHand , boolean pvp)
    {
        return new DayMode(map , plantHand , zombieHand , pvp);
    }

    private void notEnoughSun()
    {
        System.out.println("Not enough sun");
    }

    private void plantIsInCoolDown()
    {
        System.out.println("Plant is in cool down");
    }

    private boolean put(Zombie zombie , int row)
    {
        for (int i = 1; i <= 2; i++)
        {
            if (map.getByCoordination(row , 19 + i).getAsset() == null &&
                    Zombie.putZombie(zombie.copy(), map.getByCoordination(row, 19 + i))) {
                return true;
            }
        }

        return false;
    }

    private void startAWave()
    {
        lastWave = passedTurns;
        passedWaves++;

        Random random = new Random();
        int num = random.nextInt(7) + 4;

        for (int i = 0; i < num; i++)
        {
            int row = random.nextInt(6) + 1;
            Zombie zombie = (Zombie)Card.getRandomCard(zombieHand);

            while (!put(zombie , row))
            {
                zombie = (Zombie)Card.getRandomCard(zombieHand);
            }
        }
    }

    private void getGift() {
        if (pvp) {
            suns++;
            gimme = 0;
            nextGift = 1;
        } else {
            Random random = new Random();
            suns += random.nextInt(4) + 2;
            gimme = 0;
            nextGift = random.nextInt(2) + 1;
        }
    }

    @Override
    protected void checkAndGet(Plant plant)
    {
        if (plant != null)
        {
            if (plant.getRequiredSuns() <= suns)
            {
                if (plant.ready()) {
                    selectedCard = plant;
                }
                else
                {
                    plantIsInCoolDown();
                }
            }
            else
            {
                notEnoughSun();
            }
        }
        else
        {
            thereIsNoSuchPlantInYourHand();
        }
    }

    @Override
    public boolean plant(int x , int y)
    {
        if (selectedCard == null)
        {
            return false;
        }

        int price = selectedCard.getRequiredSuns();

        if (super.plant(x , y))
        {
            suns -= price;
            return true;
        }

        return false;
    }

    @Override
    public void endTurn()
    {
        if (!pvp)
        {
            super.endTurn();
        }

        if (!map.hasBrain())
        {
            youHaveLost();
        }

        suns += map.getSun();
        map.setSun(0);
        gimme++;

        if (gimme == nextGift)
        {
            getGift();
        }

        if (!pvp)
        {
            if (passedWaves == 3)
            {
                youHaveWon();
            }

            if (passedTurns == 3) {
                startAWave();
            }

            if (passedTurns - lastWave == 7) {
                startAWave();
            }
        }
    }

    public int getSuns() {
        return suns;
    }

    public int getNextGift() {
        return nextGift;
    }
}