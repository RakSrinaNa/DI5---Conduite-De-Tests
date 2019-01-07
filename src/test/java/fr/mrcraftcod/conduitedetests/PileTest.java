package fr.mrcraftcod.conduitedetests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
class PileTest{
	private Pile pile;
	
	private class TestObserver implements Observer{
		private boolean gotUpdated = false;
		
		@Override
		public void update(Observable o, Object obj){
			gotUpdated = true;
		}
		
		public boolean isGotUpdated(){
			return gotUpdated;
		}
	}
	
	@BeforeEach
	void setUp(){
		pile = new Pile();
	}
	
	@Test
	void setChanged(){
		//TODO
	}
	
	@Test
	void notifyObserversPush(){
		TestObserver obs = new TestObserver();
		
		pile.addObserver(obs);
		pile.push(10);
		assertTrue(obs.isGotUpdated());
	}
	
	@Test
	void notifyObserversPop(){
		TestObserver obs = new TestObserver();
		
		pile.push(10);
		
		pile.addObserver(obs);
		pile.pop();
		assertTrue(obs.isGotUpdated());
	}
	
	@Test
	void notifyObserversPopEmpty(){
		TestObserver obs = new TestObserver();
		
		pile.addObserver(obs);
		try{
			
			pile.pop();
		}
		catch(ArrayIndexOutOfBoundsException ignored){
		}
		assertFalse(obs.isGotUpdated());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {
			0,
			1,
			2,
			3,
			15,
			25,
			50,
			100,
			1000
	})
	void getSizeList(int addCount){
		for(int i = 0; i < addCount; i++){
			pile.push(i);
		}
		assertEquals(addCount, pile.getSizeList());
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
	void getEntier(int addCount){
		for(int i = 0; i < addCount; i++){
			pile.push(i);
		}
		for(int i = 0; i < addCount; i++){
			assertEquals(i, pile.getEntier(i));
		}
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
	void push(int addCount){
		for(int i = 0; i < addCount; i++){
			pile.push(i);
			assertEquals(i, pile.peek());
		}
		assertEquals(addCount, pile.getSizeList());
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
		assertTrue(pile.isEmpty());
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
		assertTrue(pile.isEmpty());
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
	void peek(int addCount){
		for(int i = 0; i < addCount; i++){
			pile.push(i);
			assertEquals(i, pile.peek());
		}
		assertEquals(addCount, pile.getSizeList());
	}
	
	@Test
	void peekEmpty(){
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> pile.peek());
	}
}