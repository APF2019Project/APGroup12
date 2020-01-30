package Models;

import GraphicalInterface.MapGraphicalInterface;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Map
{
    private MapGraphicalInterface mgi;
    private int deadPlants = 0 , deadZombies = 0 , sun = 0;
    private boolean brain = true;
    private ArrayList<Cell> cells = new ArrayList<Cell>();
    private boolean[] jaroo = new boolean[10];

    private Map(String type , boolean jaroo , Pane pane)
    {
        mgi = new MapGraphicalInterface(pane);

        for (int i = 1; i <= 6; i++)
        {
            this.jaroo[i] = jaroo;
        }

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

    public static Map createMap(String type , boolean jaroo , Pane pane)
    {
        return new Map(type , jaroo , pane);
    }

    public void randomize(Collection plantHand)
    {
        for (int i = 1; i <= 6; i++)
        {
            for (int j = 2; j <= 6; j += 2)
            {
                Plant.putPlant(((Plant) Card.getRandomCard(plantHand)) , getByCoordination(i , j));
            }
        }
    }

    public void jarooUp(int row)
    {
        jaroo[row] = false;

        for (int i = 1; i <= 19; i++)
        {
            getByCoordination(row , i).explode();
        }
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
            cell.plantEndTurn();
        }
    }

    private void zombieTurn()
    {
        for (Cell cell : cells)
        {
            cell.zombieEndTurn();
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

    public boolean getJaroo(int row)
    {
        return jaroo[row];
    }

    public MapGraphicalInterface getMgi() {
        return mgi;
    }
}
