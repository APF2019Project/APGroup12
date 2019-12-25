package Models;

import java.util.ArrayList;

public class ExplosivePlant extends Plant {
    private boolean mine;
    private int delay;
    private ArrayList<Cell> affectedCells;

    private ExplosivePlant(String name , String type , int health , int coolDownTime , int requiredSuns ,
                           boolean cactus, int delay , boolean mine , Cell coordination , ArrayList<Cell> affectedCells)
    {
        super(name , type , health , coolDownTime , requiredSuns , cactus , coordination);
        this.delay = delay;
        this.coordination = coordination;
        this.affectedCells = affectedCells;
        coordination.insertCard(this);
    }

    public static void putCherryBomb(Cell coordination)
    {
        ArrayList<Cell> affectedCells = new ArrayList<Cell>();

        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                int x = coordination.getX() + i , y = coordination.getY() + j;
                Cell res = coordination.getMap().getByCoordination(x , y);
                if (res != null) affectedCells.add(res);
            }
        }

        new ExplosivePlant("Cherry Bomb" , "Land" , 100 , 4 , 2 ,
                false , 0 , false , coordination , affectedCells);
    }

    public static void putJalapeno(Cell coordination)
    {
        ArrayList<Cell> affectedCells = new ArrayList<Cell>();

        for (int i = -19; i <= 19; i++)
        {
            int x = coordination.getX() , y = coordination.getY() + i;
            Cell res = coordination.getMap().getByCoordination(x , y);
            if (res != null) affectedCells.add(res);
        }

        new ExplosivePlant("Jalapeno" , "Land" , 100 , 5 , 4 ,
                false , 0 , false , coordination , affectedCells);
    }

    public static void putPotatoMine(Cell coordination)
    {
        ArrayList<Cell> affectedCells = new ArrayList<Cell>();

        int x = coordination.getX() , y = coordination.getY() + 1;
        Cell res = coordination.getMap().getByCoordination(x , y);
        if (res != null) affectedCells.add(res);

        new ExplosivePlant("Potato Mine" , "Land" , 1 , 3 , 2 ,
                false , 1 , true , coordination , affectedCells);
    }

    public void doYourJob()
    {
        if (delay == 0) {
            if (!mine) {
                coordination.clear();
                for (Cell cell : affectedCells) {
                    cell.explode();
                }
            }
        }
        else
        {
            delay--;
        }
    }
}