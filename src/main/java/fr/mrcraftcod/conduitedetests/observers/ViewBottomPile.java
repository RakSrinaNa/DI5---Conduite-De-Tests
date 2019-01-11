package fr.mrcraftcod.conduitedetests.observers;

import fr.mrcraftcod.conduitedetests.Observable;
import fr.mrcraftcod.conduitedetests.Observer;
import fr.mrcraftcod.conduitedetests.Pile;
import fr.mrcraftcod.conduitedetests.event.ClearEvent;
import fr.mrcraftcod.conduitedetests.event.PopEvent;
import fr.mrcraftcod.conduitedetests.event.PushEvent;
import org.jetbrains.annotations.NotNull;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public class ViewBottomPile implements Observer{
	private final int bottomSize;
	private PrintWriter out;
	private LinkedList<Integer> bottom;
	
	public ViewBottomPile(int bottomSize, @NotNull OutputStream out){
		this.bottomSize = bottomSize;
		this.bottom = new LinkedList<>();
		this.out = new PrintWriter(out, true);
	}
	
	@Override
	public void update(Observable o, Object obj){
		if(o instanceof Pile){
			if(obj instanceof PopEvent){
				if(((Pile) o).getSizeList() < bottomSize){
					bottom.pollLast();
				}
				out.println(String.format("popped %d, bottom stack is %s", ((PopEvent) obj).getValue(), getBottomAsString()));
			}
			else if(obj instanceof PushEvent){
				if(bottom.size() < bottomSize){
					bottom.add(((PushEvent) obj).getValue());
				}
				out.println(String.format("pushed %d, bottom stack is %s", ((PushEvent) obj).getValue(), getBottomAsString()));
			}
			else if(obj instanceof ClearEvent){
				out.println(String.format("cleared %d elements", ((ClearEvent) obj).getValue()));
			}
			else{
				out.println("unknown event");
			}
		}
	}
	
	private String getBottomAsString(){
		if(getBottom().isEmpty()){
			return "empty";
		}
		return getBottom().stream().limit(bottomSize).map(i -> "" + i).collect(Collectors.joining(", "));
	}
	
	public List<Integer> getBottom(){
		return bottom;
	}
	
	public void close()
	{
		out.close();
	}
}
