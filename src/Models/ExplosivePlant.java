package Models;

import java.util.ArrayList;

public class ExplosivePlant extends Plant {
    private int delay;

    private ExplosivePlant(String name , String type , int health , int coolDownTime , int requiredSuns ,
                           boolean cactus, int delay , Cell coordination , String url)
    {
        super(name , type , health , coolDownTime , requiredSuns , cactus , coordination , url);
        this.delay = delay;
        this.coordination = coordination;
    }

    @Override
    public ExplosivePlant copy()
    {
        ExplosivePlant res = new ExplosivePlant(this.name , this.type , this.health , this.coolDownTime , this.requiredSuns ,
                this.cactus , this.delay , null , this.url);

        this.copyCgi(res);
        return res;
    }

    public static ExplosivePlant getTangleKelp()
    {
        return new ExplosivePlant("Tangle Kelp" , "Water" , 100 , 3 , 3 ,
                false , 0 , null , "Resources/tanglekelp.webp");
    }

    public static ExplosivePlant getPotatoMine()
    {
        return new ExplosivePlant("Potato Mine" , "Land" , 1 , 3 , 2 ,
                false , 1 , null , "Resources/potatomine.webp");
    }

    public static ExplosivePlant getCherryBomb()
    {
        return new ExplosivePlant("Cherry Bomb" , "Land" , 100 , 4 , 2 ,
                false , 0 , null , "Resources/cherrybomb.webp");
    }

    public static ExplosivePlant getJalapeno()
    {
        return new ExplosivePlant("Jalapeno" , "Land" , 100 , 5 , 4 ,
                false , 0  , null , "Resources/jalapeno.webp");
    }

    private ArrayList<Cell> getAffectedCells()
    {
        ArrayList<Cell> affectedCells = new ArrayList<Cell>();

        if (name.equals("Cherry Bomb"))
        {
            int x = coordination.getX() , y = coordination.getY();

            for (int i = -1; i <= 1; i++)
            {
                for (int j = -1; j <= 1; j++)
                {
                    if (coordination.getMap().getByCoordination(x + i , y + j) != null)
                    {
                        affectedCells.add(coordination.getMap().getByCoordination(x + i , y + j));
                    }
                }
            }
        }

        if (name.equals("Jalapeno"))
        {
            int x = coordination.getX();

            for (int i = 1; i <= 19; i++)
            {
                if (coordination.getMap().getByCoordination(x , i) != null)
                {
                    affectedCells.add(coordination.getMap().getByCoordination(x , i));
                }
            }
        }

        return affectedCells;
    }

    public void doYourJob()
    {
        if (coordination == null)
        {
            super.doYourJob();
            return;
        }

        if (delay == 0)
        {
            if (!name.equals("Potato Mine") && !name.equals("Tangle Kelp"))
            {
                ArrayList<Cell> affectedCells = this.getAffectedCells();

                for (Cell cell : affectedCells)
                {
                    cell.explode();
                }

                coordination.vanishPlant();
            }
        }
        else
        {
            delay--;
        }
    }

    public int getDelay() {
        return delay;
    }
}