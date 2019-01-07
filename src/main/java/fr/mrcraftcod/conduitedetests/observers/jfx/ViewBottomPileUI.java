package fr.mrcraftcod.conduitedetests.observers.jfx;

import fr.mrcraftcod.conduitedetests.Observable;
import fr.mrcraftcod.conduitedetests.inputstrategy.ViewInputPile;
import javafx.collections.ObservableList;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2019-01-07.
 *
 * @author Thomas Couchoud
 * @since 2019-01-07
 */
public class ViewBottomPileUI extends ViewController{
	public ViewBottomPileUI(ViewInputPile viewInputPile, int i){
		super(viewInputPile);
	}
	
	@Override
	void push(Integer toPush){
	
	}
	
	@Override
	Integer pop(){
		return null;
	}
	
	@Override
	int clear(){
		return 0;
	}
	
	@Override
	public Integer peekList(){
		return null;
	}
	
	@Override
	public ObservableList<Integer> getList(){
		return null;
	}
	
	@Override
	public void update(Observable o, Object obj){
	
	}
}
