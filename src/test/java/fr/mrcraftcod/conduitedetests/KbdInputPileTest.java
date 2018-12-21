package fr.mrcraftcod.conduitedetests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
class KbdInputPileTest{
	private KbdInputPile input;
	private Pile pile;
	
	@BeforeEach
	void setUp(){
		pile = new Pile();
		input = new KbdInputPile(pile);
	}
	
	@Test
	void actionCommandeInputPush(){
		input.actionCommandeInput("push 10");
		assertEquals(1, pile.getSizeList());
		assertEquals(10, pile.pop());
	}
	
	@Test
	void actionCommandeInputInvalidPush(){
		assertThrows(InvalidInput.class, () -> input.actionCommandeInput("push hello"));
	}
}