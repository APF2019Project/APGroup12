package GraphicalInterface;

import Models.Card;
import javafx.scene.image.ImageView;

import java.util.Queue;

public class PlantGraphicalInterface extends CardGraphicalInterface
{
    private static Queue<Operation> operations;

    public PlantGraphicalInterface(Card card, ImageView pic) {
        super(card, pic);
    }
}