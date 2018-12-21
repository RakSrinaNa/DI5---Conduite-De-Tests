package fr.mrcraftcod.conduitedetests;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public class FunctionnalKeyboardConsole{
	@Test
	public void test()
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		Pile pile = new Pile();
		KbdInputPile input = new KbdInputPile(pile);
		ViewBottomPile bottom = new ViewBottomPile(bos);
		pile.addObserver(bottom);
		
		input.actionCommandeInput("push 10");
		assertEquals("pushed 10, stack is 10", bos.toString());
		bos.reset();
		
		input.actionCommandeInput("push 100");
		assertEquals("pushed 100, stack is 10,100", bos.toString());
		bos.reset();
		
		input.actionCommandeInput("push 1000");
		assertEquals("pushed 1000, stack is 10,100,1000", bos.toString());
		bos.reset();
		
		input.actionCommandeInput("pop");
		assertEquals("popped 1000, stack is 10,100", bos.toString());
		bos.reset();
		
		input.actionCommandeInput("pop");
		assertEquals("popped 100, stack is 10", bos.toString());
		bos.reset();
		
		input.actionCommandeInput("pop");
		assertEquals("popped 10, stack is empty", bos.toString());
		bos.reset();
		
		input.actionCommandeInput("pop");
		assertEquals("popped 10, stack is empty", bos.toString());
	}
}
