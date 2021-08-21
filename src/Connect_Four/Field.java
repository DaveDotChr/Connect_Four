package Connect_Four;

import jdk.jfr.Description;

public class Field {
    
    private String Color;
    private boolean Set;
    private int x_pos;
    private int y_pos;
    private static int FieldCount = 1;


    public Field(int x_pos, int y_pos){
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.Set = false;
        this.Color = null;
        System.out.println("Field " + FieldCount + " created" + x_pos + " <x-y> " + y_pos);
        FieldCount++;
    }


    public void Fill (String setColor){
        this.Color = setColor;
        this.Set = true;
    }

    public boolean CheckIfSet(){
        return this.Set;
    }

    public String CheckColor(){
        return Color;
    }

    private boolean CheckPlacement(){
        //Checks if the Field is already acessible or not (Cant put Symbol in 2 before 1 is filled etc.)asdasd
        return true;
    }

    /**
    @Description Checks if the selected field is already occupied by a Symbol, if not it sets the Symbol of the Player
    @param Takes the field that has been selected by the Player
    @returns Returns False if the 
    */
    public boolean placeSymbol(Field Field){
        boolean setable = !CheckIfSet();
        setable = CheckPlacement();
        if(setable){
            Field.Fill(this.Color);
        }
        return setable;
    }
}
