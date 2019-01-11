package fr.mrcraftcod.conduitedetests.inputstrategy;

import fr.mrcraftcod.conduitedetests.InvalidInput;
import fr.mrcraftcod.conduitedetests.Pile;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by Thomas Couchoud (MrCraftCod - zerderr@gmail.com) on 2018-12-21.
 *
 * @author Thomas Couchoud
 * @since 2018-12-21
 */
public class KbdInputPile extends InputPileStrategy{
	
	public KbdInputPile(Pile pile){
		super(pile);
	}
	
	@Override
	public Integer actionCommande() throws InvalidInput{
		Scanner sc = new Scanner(System.in);
		return actionCommandeInput(sc.next());
	}
	
	public Integer actionCommandeInput(String input) throws InvalidInput{
		if(Objects.isNull(input) || input.length() <= 0){
			throw new InvalidInput("Input is null");
		}
		
		LinkedList<String> args = new LinkedList<>(Arrays.asList(input.split(" ")));
		
		switch(args.pop()){
			case "push":
				return actionPush(args);
			case "pop":
				return actionPop(args);
            case "clear":
                return actionClear(args);
			default:
				throw new InvalidInput("Invalid command");
		}
	}
	
	private Integer actionPush(LinkedList<String> input) throws InvalidInput{
		try{
			int i = Integer.parseInt(input.pop());
			super.push(i);
			return null;
		}
		catch(Exception e){
			throw new InvalidInput(e.getMessage());
		}
	}

    private Integer actionPop(LinkedList<String> input) throws InvalidInput{
        if(!input.isEmpty()){
            throw new InvalidInput("Invalid pop");
        }
        return super.pop();
    }

    private Integer actionClear(LinkedList<String> input) throws InvalidInput{
        if(!input.isEmpty()){
            throw new InvalidInput("Invalid clear");
        }
        return super.clear();
    }
}
