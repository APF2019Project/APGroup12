package GraphicalInterface;

import Models.Card;
import javafx.scene.image.ImageView;

public class CardGraphicalInterface
{
    protected Card card;
    protected ImageView pic;

    public CardGraphicalInterface(Card card , ImageView pic)
    {
        this.card = card;
        this.pic = pic;
    }

    private void update()
    {
        int x = card.getCoordination().getMap().getMgi().getUpRightX() +
                card.getCoordination().getMap().getMgi().getDiffX() * card.getCoordination().getY();
        int y = card.getCoordination().getMap().getMgi().getUpRightY() +
                card.getCoordination().getMap().getMgi().getDiffY() * card.getCoordination().getX();

        pic.setX(x);
        pic.setY(y);
    }

    public void put()
    {
        update();
        card.getCoordination().getMap().getMgi().getPane().getChildren().add(pic);
    }

    public void delete()
    {
        update();
        card.getCoordination().getMap().getMgi().getPane().getChildren().remove(pic);
    }

    public Card getCard() {
        return card;
    }

    public ImageView getPic() {
        return pic;
    }
}
