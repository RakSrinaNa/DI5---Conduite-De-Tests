package fr.mrcraftcod.conduitedetests.observers;

import fr.mrcraftcod.conduitedetests.Observable;
import fr.mrcraftcod.conduitedetests.inputstrategy.ViewInputPile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2019-01-07.
 *
 * @author Thomas Couchoud
 * @since 2019-01-07
 */
public class ViewBottomPileUI extends ViewController{

	protected ObservableList<Integer> list;
	protected int maxSize;
	
	public ViewBottomPileUI(ViewInputPile viewInputPile, Integer i){
		super(viewInputPile);
		list = FXCollections.emptyObservableList();
		maxSize = i;
	}
	
	@Override
	public void push(Integer toPush){
		viewInputPile.push(toPush);
		if(list.size() < maxSize)
			list.add(toPush);
	}
	
	@Override
	public Integer pop(){
		if(!list.isEmpty())
			list.remove(0);
		return viewInputPile.pop();
	}
	
	@Override
	public int clear(){
		list.clear();
		return viewInputPile.clear();
	}
	
	@Override
	public Integer peekList(){
		if(list.isEmpty())
			return null;
		return list.get(0);
	}
	
	@Override
	public ObservableList<Integer> getList(){
		return list;
	}
	
	@Override
	public void update(Observable o, Object obj){

	}
}
