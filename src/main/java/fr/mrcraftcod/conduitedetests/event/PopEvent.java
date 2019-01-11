package fr.mrcraftcod.conduitedetests.event;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-23.
 *
 * @author Thomas Couchoud
 * @since 2018-12-23
 */
public class PopEvent{
	private final int value;
	
	public PopEvent(int value){this.value = value;}
	
	public int getValue(){
		return value;
	}
}
