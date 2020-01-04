package Models;

public class MultiPlayerMode extends Game
{
    private int zr = 0 , pr = 0 , rounds = 0 , numberOfWaves;
    private DayMode plants;
    private ZombieMode zombies;
    private int turn = 1;

    private MultiPlayerMode(Map map , Collection plantHand , Collection zombieHand , int numberOfWaves)
    {
        super(map , plantHand , zombieHand);
        plants = DayMode.createDayMode(map , plantHand , zombieHand , true);
        zombies = ZombieMode.createZombieMode(map , plantHand , zombieHand , true);
        this.numberOfWaves = numberOfWaves;
    }

    public static MultiPlayerMode createMultiPlayerMode(Map map , Collection plantHand , Collection zombieHand , int numberOfWaves)
    {
        return new MultiPlayerMode(map , plantHand , zombieHand , numberOfWaves);
    }

    private void draw()
    {
        System.out.println("Draw");
    }

    private void plantsHaveWon()
    {
        System.out.println("Plants Have Won");
    }
    private void plantsTurn()
    {
        System.out.println("Plants turn");
    }

    private void zombiesHaveWon()
    {
        System.out.println("Zombies have won");
    }
    private void zombiesTurn()
    {
        System.out.println("Zombies turn");
    }

    private void start()
    {
        map.getABrain();
        zombies.start();

        while (!zombies.hasWaveEnded())
        {
            int killedPlants = map.getDeadPlants();
            super.endTurn();
            plants.endTurn();
            zombies.endTurn();
            zombies.getCoin(10 * (map.getDeadPlants() - killedPlants));
        }

        if (map.hasBrain())
        {
            pr++;
        }
        else
        {
            zombies.getCoin(200);
            zr++;
        }
    }

    public void ready()
    {
        if (turn == 1)
        {
            turn = 2;
            zombiesTurn();
        }
        else
        {
            turn = 1;
            rounds++;
            start();
            plantsTurn();
        }

        if (rounds == numberOfWaves)
        {
            winnerIs();
        }
    }

    private void winnerIs()
    {
        if (pr == zr)
        {
            draw();
        }
        else
        {
            if (pr > zr)
            {
                plantsHaveWon();
            }
            else
            {
                zombiesHaveWon();
            }
        }
    }

    public DayMode getPlants() {
        return plants;
    }

    public ZombieMode getZombies() {
        return zombies;
    }

    public int getTurn() {
        return turn;
    }
}