package fr.mrcraftcod.conduitedetests.event;

public class ClearEvent {

    private final int value;

    public ClearEvent(int value){this.value = value;}

    public int getValue(){
        return value;
    }
}
