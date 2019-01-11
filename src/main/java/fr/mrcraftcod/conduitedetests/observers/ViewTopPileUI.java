package fr.mrcraftcod.conduitedetests.observers;

import fr.mrcraftcod.conduitedetests.Observable;
import fr.mrcraftcod.conduitedetests.Pile;
import fr.mrcraftcod.conduitedetests.event.ClearEvent;
import fr.mrcraftcod.conduitedetests.event.PopEvent;
import fr.mrcraftcod.conduitedetests.event.PushEvent;
import fr.mrcraftcod.conduitedetests.inputstrategy.ViewInputPile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.LinkedList;

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
		list = FXCollections.observableList(new LinkedList<>());
		maxSize = i;
	}
	
	@Override
	public void push(Integer toPush){
		viewInputPile.push(toPush);
	}
	
	@Override
	public int pop(){
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
		if(o instanceof Pile){
			if(obj instanceof PopEvent){
				if (!list.isEmpty()) {
                    list.remove(0);
                }
                if(viewInputPile.getPile().getSizeList() >= maxSize)
                    list.add(viewInputPile.getPile().getEntier(viewInputPile.getPile().getSizeList() -maxSize));
            }
			else if(obj instanceof PushEvent){
                list.add(0, ((PushEvent) obj).getValue());
                if(list.size() > maxSize)
                    list.remove(list.size()-1);
			}
			else if(obj instanceof ClearEvent){
				list.clear();
			}
		}
	}
}
