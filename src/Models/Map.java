package Models;

import java.util.ArrayList;

public class Map
{
    private ArrayList<Cell> cells = new ArrayList<Cell>();

    Map(String type)
    {
        for (int i = 1; i <= 6; i++)
        {
            for (int j = 1; j <= 19; j++)
            {
                String w = "Land";

                if (type.equals("Water") && (i == 3 || i == 4)) {
                    w = "Water";
                }

                cells.add(new Cell(this , i , j , w));
            }
        }
    }

    Cell getByCoordination(int x, int y) {
        for (Cell cell : cells) {
            if (cell.getX() == x && cell.getY() == y) {
                return cell;
            }
        }

        return null;
    }

    void showLawn()
    {
        for (Cell cell : cells)
        {
            cell.show();
        }
    }

    void endTurn()
    {
        for (Cell cell : cells)
        {
            cell.endTurn();
        }
    }
}
