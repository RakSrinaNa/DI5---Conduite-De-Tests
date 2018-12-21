package fr.mrcraftcod.conduitedetests;

import java.util.Scanner;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public class KbdInputPile extends InputPileStrategy{
	@Override
	public void actionCommande(){
        Scanner sc = new Scanner(System.in);
        actionCommandeInput(sc.next());
	}

	public void actionCommandeInput(String input){
        int i = Integer.parseInt(input);
        pile.push(i);
    }

}
