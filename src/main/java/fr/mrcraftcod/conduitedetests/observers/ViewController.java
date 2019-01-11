package fr.mrcraftcod.conduitedetests.observers;

import fr.mrcraftcod.conduitedetests.Observer;
import fr.mrcraftcod.conduitedetests.inputstrategy.ViewInputPile;
import javafx.collections.ObservableList;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2019-01-07.
 *
 * @author Thomas Couchoud
 * @since 2019-01-07
 */
public abstract class ViewController implements Observer{
	protected final ViewInputPile viewInputPile;
	
	public ViewController(ViewInputPile viewInputPile){
		this.viewInputPile = viewInputPile;
	}
	
	public abstract void push(Integer toPush);
	
	public abstract int pop();
	
	public abstract int clear();
	
	public abstract Integer peekList();
	
	public abstract ObservableList<Integer> getList();
}
