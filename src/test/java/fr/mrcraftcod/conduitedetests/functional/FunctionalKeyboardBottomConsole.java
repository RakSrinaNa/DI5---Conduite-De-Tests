package fr.mrcraftcod.conduitedetests.functional;

import fr.mrcraftcod.conduitedetests.InvalidInput;
import fr.mrcraftcod.conduitedetests.Pile;
import fr.mrcraftcod.conduitedetests.inputstrategy.KbdInputPile;
import fr.mrcraftcod.conduitedetests.observers.ViewBottomPile;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public class FunctionalKeyboardBottomConsole{
	@Test
	public void test() throws InvalidInput{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		Pile pile = new Pile();
		KbdInputPile input = new KbdInputPile(pile);
		ViewBottomPile bottom = new ViewBottomPile(2, bos);
		pile.addObserver(bottom);
		
		input.actionCommandeInput("push 10");
		assertEquals("pushed 10, bottom stack is 10" + System.getProperty("line.separator"), bos.toString());
		bos.reset();
		
		input.actionCommandeInput("push 100");
		assertEquals("pushed 100, bottom stack is 10, 100" + System.getProperty("line.separator"), bos.toString());
		bos.reset();
		
		input.actionCommandeInput("push 1000");
		assertEquals("pushed 1000, bottom stack is 10, 100" + System.getProperty("line.separator"), bos.toString());
		bos.reset();
		
		input.actionCommandeInput("pop");
		assertEquals("popped 1000, bottom stack is 10, 100" + System.getProperty("line.separator"), bos.toString());
		bos.reset();
		
		input.actionCommandeInput("pop");
		assertEquals("popped 100, bottom stack is 10" + System.getProperty("line.separator"), bos.toString());
		bos.reset();
		
		input.actionCommandeInput("pop");
		assertEquals("popped 10, bottom stack is empty" + System.getProperty("line.separator"), bos.toString());
		bos.reset();
		
		input.actionCommandeInput("clear");
		assertEquals("cleared 0 elements" + System.getProperty("line.separator"), bos.toString());
		bos.reset();
		
		input.actionCommandeInput("push 10");
		input.actionCommandeInput("push 10");
		input.actionCommandeInput("push 10");
		bos.reset();
		input.actionCommandeInput("clear");
		assertEquals("cleared 3 elements" + System.getProperty("line.separator"), bos.toString());
		bos.reset();
		
		bottom.close();
	}
}
