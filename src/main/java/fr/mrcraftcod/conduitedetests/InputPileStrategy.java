package fr.mrcraftcod.conduitedetests;

import java.util.ArrayList;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public abstract class InputPileStrategy{

	protected final Pile pile;

    protected InputPileStrategy() {
        pile = new Pile();
    }

    public void push(int entier)
	{
	    pile.push(entier);
	}
	
	public int pop()
	{
		return pile.pop();
	}
	
	public void clear()
	{
	    pile.clear();
	}
	
	abstract void actionCommande();
}
