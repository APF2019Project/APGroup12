package GraphicalInterface;

import javafx.scene.layout.Pane;

public class MapGraphicalInterface
{
    private Pane pane;
    private int diffX, diffY, upRightX, upRightY;

    public MapGraphicalInterface(Pane pane)
    {
        diffX = 40;
        diffY = 88;
        upRightX = 180;
        upRightY = 0;
        this.pane = pane;
    }

    public int getDiffX() {
        return diffX;
    }

    public int getDiffY() {
        return diffY;
    }

    public int getUpRightX() {
        return upRightX;
    }

    public int getUpRightY() {
        return upRightY;
    }

    public Pane getPane() {
        return pane;
    }
}