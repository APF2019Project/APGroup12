package Models;

import java.util.ArrayList;

public class ZombieMode extends Game
{
    private int coins;
    private boolean pvp;
    private ArrayList<Zombie>[] wave = new ArrayList[10];
    private ArrayList<Zombie>[] currentWave = (ArrayList<Zombie>[])new Object[10];

    private ZombieMode(Map map , Collection plantHand , Collection zombieHand , boolean pvp)
    {
        super(map , plantHand , zombieHand);
        this.pvp = pvp;
        coins = 50;
    }

    public static ZombieMode createZombieMode(Map map , Collection plantHand , Collection zombieHand , boolean pvp)
    {
        return new ZombieMode(map , plantHand , zombieHand , pvp);
    }

    private void notEnoughCoin()
    {
        System.out.println("Not enough coin");
    }

    private void thereIsNoSuchZombieInYourHand()
    {
        System.out.println("There is no such zombie in your hand");
    }

    private void invalidWave()
    {
        System.out.println("Invalid wave");
    }

    public void showHand()
    {
        zombieHand.show();
    }

    public void showLanes()
    {
        for (int i = 1; i <= 6; i++)
        {
            System.out.print("#" + i + " : ");

            for (Zombie zombie : wave[i])
            {
                System.out.print(zombie.getName() + " ");
            }

            System.out.println();
        }
    }

    public boolean put(String name , int cnt , int row)
    {
        Zombie zombie = (Zombie)zombieHand.getCard(name);

        if (zombie == null)
        {
            thereIsNoSuchZombieInYourHand();
            return false;
        }

        if (zombie.getRequiredCoins() * cnt > coins)
        {
            notEnoughCoin();
            return false;
        }

        if (cnt + currentWave[row].size() > 2)
        {
            invalidWave();
            return false;
        }

        for (int i = 0; i < cnt; i++)
        {
            coins -= zombie.getRequiredCoins();
            currentWave[row].add(zombie);
        }

        return true;
    }

    public void start()
    {
        for (int i = 1; i <= 6; i++)
        {
            wave[i].addAll(wave[i].size() , currentWave[i]);
            currentWave[i].clear();
        }
    }

    public boolean hasWaveEnded()
    {
        if (map.hasRemainingZombie())
        {
            return false;
        }

        for (int i = 1; i <= 6; i++)
        {
            if (wave[i].size() > 0)
            {
                return false;
            }
        }

        return true;
    }

    public void getCoin(int value)
    {
        coins += value;
    }

    @Override
    public void endTurn()
    {
        for (int i = 1; i <= 6; i++)
        {
            if (wave[i].size() > 0)
            {
                Cell coordination = map.getByCoordination(i , 19);
                Zombie.putZombie(wave[i].get(0) , coordination);
                wave[i].remove(0);
            }
        }

        if (!pvp) {

            if (!map.hasRemainingPlant())
            {
                youHaveWon();
            }

            int killedPlants = map.getDeadPlants();
            super.endTurn();
            coins += 10 * (map.getDeadPlants() - killedPlants);
        }
    }
}