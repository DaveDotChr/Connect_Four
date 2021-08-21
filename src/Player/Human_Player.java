package Player;
import Connect_Four.Field;


public class Human_Player extends Player{

    private Field[][] Field_Matrix;

    public Human_Player(Field[][] FieldMatrix){
        this.Field_Matrix = FieldMatrix;
    }

}