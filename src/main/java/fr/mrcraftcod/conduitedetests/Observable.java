package fr.mrcraftcod.conduitedetests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public abstract class Observable {

	protected List<Observer> observers;


    protected Observable() {
        this.observers = new ArrayList<>();
    }

    abstract void setChanged();
	
	abstract void notifyObservers();
	
	public abstract void addObserver(Observer obs);
}
