package fr.mrcraftcod.conduitedetests;

import java.io.OutputStream;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public class ViewTopPile implements Observer{

    private OutputStream out;

	public ViewTopPile(OutputStream out) {
		this.out = out;
	}

	@Override
	public void update(Observable o, Object arg){
		System.out.println("View Top");
	}
}
