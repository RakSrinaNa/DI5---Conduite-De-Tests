package fr.mrcraftcod.conduitedetests;

import java.util.List;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public class ViewBottomPile implements Observer{

    private OutputStream out;

    public ViewBottomPile(OutputStream out) {
        this.out = out;
    }

    @Override
	public void update(Observable o, Object obj){
        try {
            out.write("View Bottom".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public List<Integer> getBottom(){
		return null;
	}
}
