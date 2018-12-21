package fr.mrcraftcod.conduitedetests;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public class KbdInputPile extends InputPileStrategy{

    public KbdInputPile(Pile pile) {
        super(pile);
    }

    @Override
	public Integer actionCommande() throws InvalidInput {
        Scanner sc = new Scanner(System.in);
        return actionCommandeInput(sc.next());
	}

	public Integer actionCommandeInput(String input) throws InvalidInput {
        if(input == null)
            throw new InvalidInput("Input is null");

        String[] list = new String[]{"push ", "pop"};

        switch (input.split(" ")[0]){
            case "push":
                return actionPush(input);
            case "pop":
                return actionPop(input);
            default:
                throw new InvalidInput("Invalid command");
        }


    }

    private Integer actionPush(String input) throws InvalidInput {
        try {
            int i = Integer.parseInt(input.substring(5));
            pile.push(i);
            return null;
        }catch(Exception e){
            throw new InvalidInput(e.getMessage());
        }
    }

    private Integer actionPop(String input) throws InvalidInput {
        if(!input.equals("pop"))
            throw new InvalidInput("Invalid pop");
        return pile.pop();
    }

}
