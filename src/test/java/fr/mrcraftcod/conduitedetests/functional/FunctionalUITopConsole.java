package fr.mrcraftcod.conduitedetests.functional;

import fr.mrcraftcod.conduitedetests.Pile;
import fr.mrcraftcod.conduitedetests.inputstrategy.ViewInputPile;
import fr.mrcraftcod.conduitedetests.observers.ViewTopPileUI;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public class FunctionalUITopConsole{
	@Test
	public void test(){
		Pile pile = new Pile();
		ViewInputPile input = new ViewInputPile(pile);
		ViewTopPileUI controller = new ViewTopPileUI(input, 2);
		pile.addObserver(controller);
		
		controller.push(10);
		assertEquals(1, controller.getList().size());
		assertEquals((Integer) 10, controller.peekList());
		
		controller.push(100);
		assertEquals(2, controller.getList().size());
		assertEquals((Integer) 100, controller.peekList());
		assertTrue(controller.getList().contains(10));
		assertTrue(controller.getList().contains(100));
		
		controller.push(1000);
		assertEquals(2, controller.getList().size());
		assertEquals((Integer) 1000, controller.peekList());
		assertTrue(controller.getList().contains(100));
		assertTrue(controller.getList().contains(1000));
		
		controller.pop();
		assertEquals(2, controller.getList().size());
		assertEquals((Integer) 100, controller.peekList());
		assertTrue(controller.getList().contains(10));
		assertTrue(controller.getList().contains(100));
		
		controller.pop();
		assertEquals(1, controller.getList().size());
		assertEquals((Integer) 10, controller.peekList());
		assertTrue(controller.getList().contains(10));
		
		controller.pop();
		assertEquals(0, controller.getList().size());
		assertNull(controller.peekList());
	}
}
