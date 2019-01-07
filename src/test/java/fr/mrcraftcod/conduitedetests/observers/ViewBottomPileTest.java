package fr.mrcraftcod.conduitedetests.observers;

import fr.mrcraftcod.conduitedetests.Pile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.ByteArrayOutputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
class ViewBottomPileTest{
	private ViewBottomPile bottom;
	private Pile pile;
	private ByteArrayOutputStream bos;
	
	@BeforeEach
	void setUp(){
		bos = new ByteArrayOutputStream();
		
		pile = new Pile();
		bottom = new ViewBottomPile(2, bos);
		pile.addObserver(bottom);
	}
	
	@AfterEach
	void tearDown(){
		bottom.close();
	}
	
	@Test
	void noAction(){
		assertEquals(0, bottom.getBottom().size());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 5, 10, 1000})
	void push(int value){
		pile.push(value);
		assertEquals(String.format("pushed %d, bottom stack is %d\n", value, value), bos.toString());
	}
	
	@Test
	void pushMultiple(){
		pile.push(2);
		bos.reset();
		pile.push(4);
		assertEquals("pushed 4, bottom stack is 2, 4\n", bos.toString());
	}
	
	@Test
	void pushOverLimit(){
		pile.push(2);
		bos.reset();
		pile.push(4);
		bos.reset();
		pile.push(6);
		assertEquals("pushed 6, bottom stack is 2, 4\n", bos.toString());
	}
	
	@Test
	void unknownEvent(){
		bottom.update(pile, new Object());
		assertEquals("unknown event\n", bos.toString());
	}
}