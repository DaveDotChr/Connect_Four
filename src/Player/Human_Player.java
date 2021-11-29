package Player;
import Connect_Four.Field;
import Connect_Four.Turn;


public class Human_Player extends Player{


    public Human_Player(Field[][] Field_Matrix, String Color){
        super(Field_Matrix, Color);
    }

    public void StartTurn(){
        boolean test = false;
        Exception ex = null;
        while (!test){
            //Lets Player choose a Line to place the Symbol in, if not full places the Symbol
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