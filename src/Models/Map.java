package Models;

import java.util.ArrayList;

public class Map
{
    private int deadPlants = 0 , deadZombies = 0 , sun = 0;
    private boolean brain = true;
    private ArrayList<Cell> cells = new ArrayList<Cell>();

    private Map(String type)
    {
        for (int i = 1; i <= 6; i++)
        {
            for (int j = 1; j <= 30; j++)
            {
                String w = "Land";

                if (type.equals("Water") && (i == 3 || i == 4)) {
                    w = "Water";
                }

                cells.add(new Cell(this , i , j , w));
            }
        }
    }

    public static Map createLandMap()
    {
        return new Map("Land");
    }

    public static Map createWaterMap()
    {
        return new Map("Water");
    }

    public void show()
    {
        for (int i = 1; i <= 6; i++)
        {
            for (int j = 1; j <= 19; j++)
            {
                Cell cell = getByCoordination(i , j);

                if (cell.getAsset() == null)
                {
                    if (cell.getType().equals("Land")) {
                        System.out.print('.');
                    }
                    else
                    {
                        System.out.print("w");
                    }
                }

                if (cell.getAsset() instanceof Plant)
                {
                    System.out.print('P');
                }

                if (cell.getAsset() instanceof Zombie)
                {
                    System.out.print('Z');
                }
            }

            System.out.println();
        }
    }

    public Cell getByCoordination(int x, int y) {
        for (Cell cell : cells) {
            if (cell.getX() == x && cell.getY() == y) {
                return cell;
            }
        }

        return null;
    }

    public void showLawn()
    {
        for (Cell cell : cells)
        {
            cell.show();
        }
    }

    private void plantTurn()
    {
        for (Cell cell : cells)
        {
            if (cell.getAsset() instanceof Plant)
            {
                cell.endTurn();
            }
        }
    }

    private void zombieTurn()
    {
        for (Cell cell : cells)
        {
            if (cell.getAsset() instanceof Zombie)
            {
                cell.endTurn();
            }
        }
    }

    public void endTurn()
    {
        plantTurn();
        zombieTurn();
    }

    public boolean hasRemainingZombie()
    {
        for (Cell cell : cells)
        {
            if (cell.getAsset() instanceof Zombie)
            {
                return true;
            }
        }

        return false;
    }

    public boolean hasRemainingPlant()
    {
        for (Cell cell : cells)
        {
            if (cell.getAsset() instanceof Plant)
            {
                return true;
            }
        }

        return false;
    }

    public boolean hasBrain()
    {
        return brain;
    }

    public void eatBrain()
    {
        brain = false;
    }

    public void getABrain()
    {
        brain = true;
    }

    public int getDeadPlants() {
        return deadPlants;
    }

    public void plantDown() {
        deadPlants++;
    }

    public int getDeadZombies() {
        return deadZombies;
    }

    public void zombieDown() {
        deadZombies++;
    }

    public int getSun() {
        return sun;
    }

    public void setSun(int sun) {
        this.sun = 0;
    }

    public void addSun(int sun) {
        this.sun += sun;
    }
}
