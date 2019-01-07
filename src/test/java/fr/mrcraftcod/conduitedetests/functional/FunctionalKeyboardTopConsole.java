package fr.mrcraftcod.conduitedetests.functional;

import fr.mrcraftcod.conduitedetests.InvalidInput;
import fr.mrcraftcod.conduitedetests.Pile;
import fr.mrcraftcod.conduitedetests.inputstrategy.KbdInputPile;
import fr.mrcraftcod.conduitedetests.observers.ViewTopPile;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public class FunctionalKeyboardTopConsole{
	@Test
	public void test() throws InvalidInput{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		Pile pile = new Pile();
		KbdInputPile input = new KbdInputPile(pile);
		ViewTopPile top = new ViewTopPile(2, bos);
		pile.addObserver(top);
		
		input.actionCommandeInput("push 10");
		assertEquals("pushed 10, top stack is 10" + System.getProperty("line.separator"), bos.toString());
		bos.reset();
		
		input.actionCommandeInput("push 100");
		assertEquals("pushed 100, top stack is 10, 100" + System.getProperty("line.separator"), bos.toString());
		bos.reset();
		
		input.actionCommandeInput("push 1000");
		assertEquals("pushed 1000, top stack is 100, 1000" + System.getProperty("line.separator"), bos.toString());
		bos.reset();
		
		input.actionCommandeInput("pop");
		assertEquals("popped 1000, top stack is 10, 100" + System.getProperty("line.separator"), bos.toString());
		bos.reset();
		
		input.actionCommandeInput("pop");
		assertEquals("popped 100, top stack is 10" + System.getProperty("line.separator"), bos.toString());
		bos.reset();
		
		input.actionCommandeInput("pop");
		assertEquals("popped 10, top stack is empty" + System.getProperty("line.separator"), bos.toString());
		bos.reset();
		
		top.close();
	}
}
