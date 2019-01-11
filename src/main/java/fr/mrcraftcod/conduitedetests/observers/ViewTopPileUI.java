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
public class ViewTopPileUI extends ViewController{
	
	protected ObservableList<Integer> list;
	protected int maxSize;
	
	public ViewTopPileUI(ViewInputPile viewInputPile, Integer i){
		super(viewInputPile);
		list = FXCollections.emptyObservableList();
		maxSize = i;
	}
	
	@Override
	public void push(Integer toPush){
		viewInputPile.push(toPush);
	}
	
	@Override
	public Integer pop(){
		return viewInputPile.pop();
	}
	
	@Override
	public int clear(){
		return viewInputPile.clear();
	}
	
	@Override
	public Integer peekList(){
		if(list.isEmpty()){
			return null;
		}
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
