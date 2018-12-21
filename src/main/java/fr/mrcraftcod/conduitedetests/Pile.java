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
	
	public Pile(){pile = null;}
	
	@Override
	void setChanged(){
	
	}
	
	@Override
	void notifyObservers(){
	
	}
	
	@Override
	public void update(Observable o, Object obj){
	
	}
	
	public ArrayList<Integer> getPile(){
		return pile;
	}
	
	public int getSizeList(){
		return 0;
	}
	
	public int getEntier(int index){
		return 0;
	}
	
	void push(int entier){
	
	}
	
	public int pop(){
		return 0;
	}
	
	void clear(){
	
	}
}
