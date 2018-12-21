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
	
	public Pile(){pile = new ArrayList<>();}
	
	@Override
	void setChanged(){
	
	}
	
	@Override
	void notifyObservers(){
	
	}
	
	@Override
	public void addObserver(Observer obs){
	
	}
	
	public int peek(){
		return 0;
	}
	
	public int getSizeList(){
		return pile.size();
	}
	
	public int getEntier(int index){
		return pile.get(index);
	}
	
	void push(int entier){
		pile.add(entier);
	}
	
	public int pop(){
		return pile.remove(pile.size() -1);
	}
	
	void clear(){
		pile.clear();
	}
}
