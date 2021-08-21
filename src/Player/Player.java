package Player;
import Connect_Four.Connect_Four;
import Connect_Four.Field;


public abstract class Player {
    
private Connect_Four cf;
private Field Field;
private String Color;

    public void PlaceSymbol(){
        do {
        //Runs until the Player selects a Field that isn't already occupied or not selectable yet    
        } while (Field.placeSymbol(Field));
        cf.CheckWincondition(Field);
    }

}
