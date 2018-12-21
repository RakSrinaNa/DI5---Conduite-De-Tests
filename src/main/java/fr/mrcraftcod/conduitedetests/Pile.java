package fr.mrcraftcod.conduitedetests;

import java.util.ArrayList;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public class Pile extends Observable{
	private final ArrayList<Integer> pile;
	
	public Pile(){
		super();
		pile = new ArrayList<>();
	}
	
	@Override
	void setChanged(){
	    //TODO
	}
	
	@Override
	void notifyObservers(){
	    observers.forEach(o -> o.update(this, null));
	}

	@Override
	public void addObserver(Observer obs){
        observers.add(obs);
	}

	public int peek(){
		return pile.get(pile.size() -1);
	}

	public int getSizeList(){
		return pile.size();
	}
	
	public int getEntier(int index){
		return pile.get(index);
	}
	
	void push(int entier){
		pile.add(entier);
		setChanged();
		notifyObservers();
	}
	
	public int pop(){
	    int i = pile.remove(pile.size() -1);
	    setChanged();
		notifyObservers();
        return i;
    }
	
	void clear(){
		pile.clear();
	}
}
