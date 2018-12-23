package fr.mrcraftcod.conduitedetests.observers;

import fr.mrcraftcod.conduitedetests.Observable;
import fr.mrcraftcod.conduitedetests.Observer;
import fr.mrcraftcod.conduitedetests.Pile;
import fr.mrcraftcod.conduitedetests.event.PopEvent;
import fr.mrcraftcod.conduitedetests.event.PushEvent;
import org.jetbrains.annotations.NotNull;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public class ViewTopPile implements Observer{
	private final PrintWriter out;
	private final int topSize;
	
	public ViewTopPile(int topSize, @NotNull OutputStream out){
		this.topSize = topSize;
		this.out = new PrintWriter(out, true);
	}
	
	@Override
	public void update(Observable o, Object obj){
		if(o instanceof Pile){
			if(obj instanceof PopEvent){
				out.println(String.format("popped %d, top stack is %s", ((PopEvent) obj).getValue(), getTopAsString((Pile)o)));
			}
			else if(obj instanceof PushEvent){
				out.println(String.format("pushed %d, top stack is %s", ((PushEvent) obj).getValue(), getTopAsString((Pile)o)));
			}
			else{
				out.println("unknown event");
			}
		}
	}
	
	public String getTopAsString(Pile pile)
	{
		if(pile.getSizeList() < 1){
			return "empty";
		}
		ArrayList<Integer> top = new ArrayList<>(topSize);
		for(int i = Math.max(0, pile.getSizeList() - topSize); i < pile.getSizeList(); i++)
		{
			top.add(pile.getEntier(i));
		}
		return top.stream().map(i -> "" + i).collect(Collectors.joining(", "));
	}
	
	public void close()
	{
		out.close();
	}
}
