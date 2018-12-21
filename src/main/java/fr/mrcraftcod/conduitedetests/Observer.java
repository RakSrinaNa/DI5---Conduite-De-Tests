package fr.mrcraftcod.conduitedetests;

import java.io.OutputStream;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public interface Observer{
	void update(Observable o, Object obj);
}
