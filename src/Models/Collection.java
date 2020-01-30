package Models;

import java.util.ArrayList;

public class Collection
{
    private ArrayList<Card> list = new ArrayList<Card>();

    public Collection() {

    }

    public Collection(ArrayList<Card> list) {
        this.list.addAll(list);
    }

    void show()
    {
        for (Card card : list)
        {
            System.out.print(card.getName() + " ");
        }

        System.out.println();
    }

    int getSize()
    {
        return list.size();
    }

    public void add(Card card)
    {
        list.add(card);
    }

    void remove(Card card)
    {
        list.remove(card);
    }

    public Card getCard(String name)
    {
        for (Card card : list)
        {
            if (card.getName().equals(name))
            {
                return card;
            }
        }

        return null;
    }

    Card getCard(int position)
    {
        if (position > list.size())
        {
            return null;
        }

        return list.get(position - 1);
    }

    public void endTurn()
    {
        for (Card card : list)
        {
            card.doYourJob();
        }
    }

    public ArrayList<Card> getList() {
        return list;
    }
}