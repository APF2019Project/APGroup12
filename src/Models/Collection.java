package Models;

import java.util.ArrayList;

public class Collection {
    private ArrayList<Card> list = new ArrayList<>();

    public Collection() {
    }

    public Collection( ArrayList<Card> list) {
        this.list.addAll(list);
    }


    public Card getCard(String name) {
        for (Card card : list)
            if (card.getName().equals(name))
                return card;
        return null;
    }

    public Card getCard(int position) {
        if (position > list.size())
            return null;
        return list.get(position - 1);
    }

    public ArrayList<Card> getList() { return list; }
}