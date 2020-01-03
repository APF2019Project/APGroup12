package Models;

public class Day extends Game
{
    protected Plant selectedCard;

    protected Day(Map map , Collection plantHand , Collection zombieHand)
    {
        super(map , plantHand , zombieHand);
    }

    protected void thereIsNoSuchPlantInYourHand()
    {
        System.out.println("There is no such plant in your hand");
    }

    protected void invalidCell()
    {
        System.out.println("Invalid cell");
    }

    protected void checkAndGet(Plant plant)
    {
        if (plant != null)
        {
            selectedCard = plant;
        }
        else
        {
            thereIsNoSuchPlantInYourHand();
        }
    }

    public void showHand()
    {
        plantHand.show();
    }

    public void select(String name)
    {
        Plant plant = (Plant)plantHand.getCard(name);
        checkAndGet(plant);
    }

    public void select(int position)
    {
        Plant plant = (Plant)plantHand.getCard(position);
        checkAndGet(plant);
    }

    public boolean plant(int x , int y)
    {
        Cell coordination = map.getByCoordination(x , y);

        if (coordination.checkValidity(selectedCard))
        {
            Plant.putPlant(selectedCard , coordination);
            selectedCard = null;
            return true;
        }

        invalidCell();
        return false;
    }

    public void remove(int x , int y)
    {
        Cell coordination = map.getByCoordination(x , y);

        if (coordination.getAsset() instanceof Plant)
        {
            coordination.clear();
        }
        else
        {
            invalidCell();
        }
    }
}
