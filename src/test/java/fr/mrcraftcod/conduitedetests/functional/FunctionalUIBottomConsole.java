package fr.mrcraftcod.conduitedetests.functional;

import fr.mrcraftcod.conduitedetests.InvalidInput;
import fr.mrcraftcod.conduitedetests.Pile;
import fr.mrcraftcod.conduitedetests.inputstrategy.ViewInputPile;
import fr.mrcraftcod.conduitedetests.observers.ViewBottomPileUI;
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
		ViewBottomPileUI controller = new ViewBottomPileUI(input, 2);
		pile.addObserver(controller);
		
		controller.push(10);
		assertEquals(1, controller.getList().size());
		assertEquals((Integer) 10, controller.peekList());
		
		controller.push(100);
		assertEquals(2, controller.getList().size());
		assertEquals((Integer) 100, controller.peekList());
		
		controller.push(1000);
		assertEquals(3, controller.getList().size());
		assertEquals((Integer) 100, controller.peekList());
		
		controller.pop();
		assertEquals(2, controller.getList().size());
		assertEquals((Integer) 100, controller.peekList());
		
		controller.pop();
		assertEquals(1, controller.getList().size());
		assertEquals((Integer) 10, controller.peekList());
		
		controller.pop();
		assertEquals(0, controller.getList().size());
		assertNull(controller.peekList());
	}
}
