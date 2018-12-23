package fr.mrcraftcod.conduitedetests;

import fr.mrcraftcod.conduitedetests.event.PopEvent;
import fr.mrcraftcod.conduitedetests.event.PushEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public class Pile extends Observable{
	private final List<Integer> pile;
	
	public Pile(){
		super();
		pile = new ArrayList<>();
	}
	
	@Override
	void setChanged(){
		//TODO
	}
	
	@Override
	void notifyObservers(Object obj){
		observers.forEach(o -> o.update(this, obj));
	}
	
	@Override
	public void addObserver(Observer obs){
		observers.add(obs);
	}
	
	public int peek(){
		return pile.get(pile.size() - 1);
	}
	
	public int getSizeList(){
		return pile.size();
	}
	
	public int getEntier(int index){
		return pile.get(index);
	}
	
	public void push(int entier){
		pile.add(entier);
		setChanged();
		notifyObservers(new PushEvent(entier));
	}
	
	public int pop(){
		int i = pile.remove(pile.size() - 1);
		setChanged();
		notifyObservers(new PopEvent(i));
		return i;
	}
	
	public void clear(){
		pile.clear();
	}
}
