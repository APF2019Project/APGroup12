package Models;

import java.util.ArrayList;

public class Cell {
    private Map map;
    private int x, y;
    private String type;
    private Plant plantAsset = null;
    private ArrayList<Zombie> zombieAsset = new ArrayList<Zombie>();

    public Cell(Map map, int x, int y, String type) {
        this.map = map;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public Cell copy()
    {
        return new Cell(this.map , this.x , this.y , this.type);
    }

    private static double getDist(Cell a , Cell b)
    {
        int x = (a.getX() - b.getX()) , y = (a.getY() - b.getY());
        return Math.sqrt(x * x + y * y);
    }

    public void insertCard(Plant card) {
        plantAsset = card;
        card.setCoordination(this);
    }

    public void insertCard(Zombie card) {
        zombieAsset.add(card);
        card.setCoordination(this);
    }

    public void clear() {
        plantAsset = null;
    }
    public void clear(Zombie zombie)
    {
        zombieAsset.remove(zombie);
    }

    public boolean checkValidity(Card card) {
        if (card instanceof Plant) {
            if (y % 2 == 1)
            {
                return false;
            }

            if (type.equals("Water")) {
                if (card.getType().equals("Water"))
                {
                    return plantAsset == null;
                }
                else
                {
                    return plantAsset != null && plantAsset.getName().equals("Lily Pad");
                }
            } else {
                return plantAsset == null;
            }
        }
        else
        {
            return plantAsset == null && ((Zombie) card).type.equals(type);
        }
    }

    public void show()
    {
        if (plantAsset != null)
        {
            plantAsset.show();
        }

        for (Zombie zombie : zombieAsset)
        {
            zombie.show();
        }
    }

    public void endTurn()
    {
        if (plantAsset != null)
        {
            plantAsset.doYourJob();
        }

        ArrayList<Zombie> tmp = new ArrayList<Zombie>();

        while (zombieAsset.size() > 0)
        {
            Zombie zombie = zombieAsset.get(0);
            zombie.doYourJob();

            if (zombieAsset.contains(zombie))
            {
                tmp.add(zombie);
                zombieAsset.remove(zombie);
            }
        }

        while (tmp.size() > 0)
        {
            Zombie zombie = tmp.get(0);
            zombieAsset.add(zombie);
            tmp.remove(zombie);
        }
    }

    public Zombie getRightZombie()
    {
        for (int i = y; i <= 19; i++)
        {
            if (map.getByCoordination(x , i).getAsset() instanceof Zombie)
            {
                return (Zombie)(map.getByCoordination(x , i).getAsset());
            }
        }

        return null;
    }

    public Zombie getLeftZombie()
    {
        for (int i = y; i >= 1; i--)
        {
            if (map.getByCoordination(x , i).getAsset() instanceof Zombie)
            {
                return (Zombie)(map.getByCoordination(x , i).getAsset());
            }
        }

        return null;
    }

    public Zombie getClosestZombie()
    {
        double dist = 100000.0;
        Zombie res = null;

        for (int i = 1; i <= 6; i++)
        {
            for (int j = 1; j <= 19; j++)
            {
                if (map.getByCoordination(i , j).getAsset() instanceof Zombie)
                {
                    if (getDist(this , map.getByCoordination(i , j)) < dist)
                    {
                        res = (Zombie)(map.getByCoordination(i , j).getAsset());
                    }
                }
            }
        }

        return res;
    }

    public void killPlant()
    {
        plantAsset = null;
        map.plantDown();
    }

    public void killZombie(Zombie zombie)
    {
        zombieAsset.remove(zombie);
        map.zombieDown();
    }

    public void explode()
    {
        while (zombieAsset.size() > 0)
        {
            Zombie zombie = zombieAsset.get(0);
            this.killZombie(zombie);
        }
    }

    public boolean getAbsorbed()
    {
        for (Zombie zombie : zombieAsset)
        {
            if (zombie.getPowers().isPogo())
            {
                zombie.getPowers().setPogo(false);
                return true;
            }

            if (zombie.getPowers().isScreenDoor())
            {
                zombie.getPowers().setScreenDoor(false);
                zombie.setShield(0);
                return true;
            }

            if (zombie.getPowers().isBucketHead())
            {
                if (zombie.getHealth() > 1)
                {
                    zombie.getHit(new Pea(1 , true , new Effect()));
                }

                zombie.getPowers().setBucketHead(false);
                return true;
            }
        }

        return false;
    }

    public Map getMap() {
        return map;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getType() {
        return type;
    }

    public Card getAsset()
    {
        if (plantAsset != null)
        {
            return plantAsset;
        }

        if (zombieAsset.size() > 0)
        {
            return zombieAsset.get(0);
        }

        return null;
    }
}