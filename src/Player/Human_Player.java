package Player;
import Connect_Four.Field;


public class Human_Player extends Player{


    public Human_Player(Field[][] Field_Matrix, String Color){
        super(Field_Matrix, Color);
    }

    public void StartTurn(){
        boolean test = false;
        Exception ex = null;
        while (!test){
            try{
                test = placeSymbol(Integer.parseInt(sc.nextLine()));
            } catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Line does not exist choose from 0-6");
                ex = e;
            }
            

            if(!test && ex == null)
            System.out.println("Line already full, please choose different line");
        }
    }

}