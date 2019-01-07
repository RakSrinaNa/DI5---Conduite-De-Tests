package fr.mrcraftcod.conduitedetests.functional;

import fr.mrcraftcod.conduitedetests.InvalidInput;
import fr.mrcraftcod.conduitedetests.Pile;
import fr.mrcraftcod.conduitedetests.inputstrategy.ViewInputPile;
import fr.mrcraftcod.conduitedetests.observers.jfx.ViewBottomPileUI;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public class FunctionalUIBottomConsole{
	@Test
	public void test() throws InvalidInput{
		Pile pile = new Pile();
		ViewInputPile input = new ViewInputPile(pile);
		ViewBottomPileUI bottom = new ViewBottomPileUI(input, 2);
		pile.addObserver(bottom);
		
		input.push(10);
		assertEquals(1, bottom.getList().size());
		assertEquals((Integer) 10, bottom.peekList());
		
		input.push(100);
		assertEquals(2, bottom.getList().size());
		assertEquals((Integer) 100, bottom.peekList());
		
		input.push(1000);
		assertEquals(3, bottom.getList().size());
		assertEquals((Integer) 100, bottom.peekList());
		
		input.pop();
		assertEquals(2, bottom.getList().size());
		assertEquals((Integer) 100, bottom.peekList());
		
		input.pop();
		assertEquals(1, bottom.getList().size());
		assertEquals((Integer) 10, bottom.peekList());
		
		input.pop();
		assertEquals(0, bottom.getList().size());
		assertNull(bottom.peekList());
	}
}
