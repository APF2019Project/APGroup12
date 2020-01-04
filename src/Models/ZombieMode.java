package Models;

public class ZombieMode extends Game
{
    private int coins;
    private boolean pvp;
    private Zombie[][] wave = new Zombie[10][10];
    private int[] last = new int[10];

    private ZombieMode(Map map , Collection plantHand , Collection zombieHand , boolean pvp)
    {
        super(map , plantHand , zombieHand);
        this.pvp = pvp;
        coins = 50;

        for (int i = 0; i < 10; i++)
        {
            wave[i] = new Zombie[10];
        }

        if (!pvp)
        {
            map.randomize(plantHand);
        }
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

            for (int j = 0; j < last[i]; j++)
            {
                System.out.print(wave[i][j].getName() + " ");
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

        if (cnt + last[row] > 2)
        {
            invalidWave();
            return false;
        }

        for (int i = 0; i < cnt; i++)
        {
            coins -= zombie.getRequiredCoins();
            wave[row][last[row]] = ((Zombie) zombieHand.getCard(name));
            last[row]++;
        }

        return true;
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

    public void start()
    {
        for (int i = 1; i <= 6; i++)
        {
            for (int j = 0; j < last[i]; j++)
            {
                put(wave[i][j] , i);
                wave[i][j] = null;
            }

            last[i] = 0;
        }
    }

    public boolean hasWaveEnded()
    {
        return (!map.hasRemainingZombie());
    }

    public int getCoins()
    {
        return coins;
    }

    public void getCoin(int value)
    {
        coins += value;
    }

    @Override
    public void endTurn()
    {
        if (!pvp)
        {
            int killedPlants = map.getDeadPlants();
            super.endTurn();
            coins += 10 * (map.getDeadPlants() - killedPlants);

            if (!map.hasRemainingPlant())
            {
                youHaveWon();
            }
        }
    }
}