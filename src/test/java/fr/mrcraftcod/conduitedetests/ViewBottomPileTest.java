package fr.mrcraftcod.conduitedetests;

import fr.mrcraftcod.conduitedetests.observers.ViewBottomPile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
class ViewBottomPileTest{
	private ViewBottomPile bottom;
	private Pile pile;
	
	@BeforeEach
	void setUp(){
		pile = new Pile();
		bottom = new ViewBottomPile(2, System.out); //TODO bos
		pile.addObserver(bottom);
	}
	
	@Test
	void noAction(){
		assertEquals(0, bottom.getBottom().size());
	}
}