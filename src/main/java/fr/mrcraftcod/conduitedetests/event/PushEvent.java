package fr.mrcraftcod.conduitedetests.event;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-23.
 *
 * @author Thomas Couchoud
 * @since 2018-12-23
 */
public class PushEvent{
	private final int value;
	
	public PushEvent(int value){this.value = value;}
	
	public int getValue(){
		return value;
	}
}
