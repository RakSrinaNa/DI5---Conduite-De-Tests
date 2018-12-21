package fr.mrcraftcod.conduitedetests;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public abstract class Observable {
	abstract void setChanged();
	
	abstract void notifyObservers();
}
