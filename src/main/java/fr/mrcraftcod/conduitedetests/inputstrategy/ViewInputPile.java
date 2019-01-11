package fr.mrcraftcod.conduitedetests.inputstrategy;

import fr.mrcraftcod.conduitedetests.Pile;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public class ViewInputPile extends InputPileStrategy{
	public ViewInputPile(Pile pile){
		super(pile);
	}
	
	@Override
	Integer actionCommande(){
		return null;
	}

	@Override
	public void push(int toPush) {
		super.push(toPush);
	}

	@Override
	public int pop() {
		return super.pop();
	}

	@Override
	public int clear() {
		return super.clear();
	}
}
