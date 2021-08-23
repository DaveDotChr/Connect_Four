package Player;
import Connect_Four.Field;


public class Human_Player extends Player{

    private Field[][] Field_Matrix;

    public Human_Player(Field[][] Field_Matrix, String Color){
        super(Field_Matrix, Color);
    }

    public void StartTurn(){
        boolean test = false;

        while (!test){
            test = placeSymbol(Integer.parseInt(sc.nextLine()));

            if(!test)
            System.out.println("Line already full, please choose different line");
        }
    }

}