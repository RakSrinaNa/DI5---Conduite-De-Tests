package fr.mrcraftcod.conduitedetests.inputstrategy;

import fr.mrcraftcod.conduitedetests.InvalidInput;
import fr.mrcraftcod.conduitedetests.Pile;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public abstract class InputPileStrategy{
	
	protected final Pile pile;
	
	protected InputPileStrategy(Pile pile){
		this.pile = pile;
	}
	
	protected void push(int entier){
		pile.push(entier);
	}
	
	protected int pop(){
		return pile.pop();
	}
	
	protected int clear(){
		return pile.clear();
    }
	
	abstract Integer actionCommande() throws InvalidInput;
}
