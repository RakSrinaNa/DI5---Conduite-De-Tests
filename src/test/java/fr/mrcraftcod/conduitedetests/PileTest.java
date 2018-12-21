package fr.mrcraftcod.conduitedetests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
class PileTest{
	private Pile pile;
	
	@BeforeEach
	void setUp(){
		pile = new Pile();
	}
	
	@Test
	void setChanged(){
	}
	
	@Test
	void notifyObservers(){
	}
	
	@Test
	void getPile(){
	}
	
	@Test
	void getSizeList(){
	}
	
	@Test
	void getEntier(){
	}
	
	@Test
	void push(){
	}
	
	@ParameterizedTest
	@ValueSource(ints = {
			1,
			2,
			3,
			15,
			25,
			50,
			100,
			1000
	})
	void pop(int addCount){
		for(int i = 0; i < addCount; i++){
			pile.push(i);
		}
		for(int i = addCount - 1; i >= 0; i--){
			assertEquals(i, pile.pop());
		}
		assertEquals(0, pile.getSizeList());
	}
	
	@Test
	void popEmpty(){
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> pile.pop());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {
			1,
			2,
			3,
			15,
			25,
			50,
			100,
			1000
	})
	void clear(int addCount){
		for(int i = 0; i < addCount; i++){
			pile.push(i);
		}
		pile.clear();
		assertEquals(0, pile.getSizeList());
	}
}