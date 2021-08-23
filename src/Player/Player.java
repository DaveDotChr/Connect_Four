package Player;
import Connect_Four.Field;
import java.util.Scanner;


public abstract class Player implements Basic{
    
protected Field Field;
protected String Color;
protected boolean Won;
protected Scanner sc = new Scanner(System.in);
protected Field[][] Field_Matrix = new Field[7][6];
protected Field currentField;

    protected Player(Field[][] Field_Matrix, String Color){
        this.Field_Matrix = Field_Matrix;
        this.Color = Color;
    }

    public abstract void StartTurn();

    public void setWon(){
        this.Won = true;
    }

    public boolean getWon(){
        return this.Won;
    }

    /**
    @Description Checks if the selected field is already occupied by a Symbol, if not it sets the Symbol of the Player
    @param Takes the field that has been selected by the Player
    @returns Returns False if the 
    */
    protected boolean placeSymbol(int Line){
        boolean setable = false;

        for (int y = 0; y <= 5; y++) {
            //System.out.println(Field_Matrix[Line][y].CheckIfSet());
            if(!Field_Matrix[Line][y].CheckIfSet()){
                Field_Matrix[Line][y].Fill(this.Color);
                setable = true;
                //System.out.println("Symbol with color: " + this.Color + " at x: " + Line + " y: " + y);
                currentField = Field_Matrix[Line][y];
                break;
            }
        }
        return setable;
    }

    public Field currentField(){
        return currentField;
    }

    public String getColor(){
        return this.Color;
    }
}
