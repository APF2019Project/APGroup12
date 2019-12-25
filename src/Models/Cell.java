package Models;

public class Cell {
    private Map map;
    private int x, y;
    private String type;
    private Card asset;

    private static double getDist(Cell a , Cell b)
    {
        int x = (a.getX() - b.getX()) , y = (a.getY() - b.getY());
        return Math.sqrt(x * x + y * y);
    }

    public void insertCard(Card card) {
        asset = card;
    }

    public void clear() {
        asset = null;
    }

    public boolean checkValidity(Card card) {
        if (!card.getType().equals(type)) {
            return false;
        }

        if (card instanceof Plant) {
            if (y % 2 == 1)
            {
                return false;
            }

            if (type.equals("Water")) {
                return asset != null && asset.getName().equals("Lily Pad");
            } else {
                return asset == null;
            }
        }

        return asset == null;
    }

    public void show()
    {
        if (asset != null)
        {
            asset.show();
        }
    }

    public void endTurn()
    {
        if (asset != null)
        {
            asset.doYourJob();
        }
    }

    public void explode()
    {
        if (asset instanceof Zombie)
        {
            asset = null;
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

    public Card getAsset() {
        return asset;
    }
}