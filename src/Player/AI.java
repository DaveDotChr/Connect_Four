package Player;

import Connect_Four.Field;

public class AI extends Player{

    private Field[][] Field_Matrix = new Field[5][6];

    public AI (Field[][] Field_Matrix, String Color){
        super(Field_Matrix, Color);
    }

    public void StartTurn(){
        System.out.println("do noting yet");
    }
    
}
