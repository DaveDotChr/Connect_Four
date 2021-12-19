package Player;

import Connect_Four.Field;
import java.util.Scanner;

public abstract class Player implements Actions{

    protected String Color;
    protected boolean Won;
    protected Scanner sc = new Scanner(System.in);
    protected Field[][] Field_Matrix = new Field[7][6];
    protected Field currentField;

    protected Player(Field[][] Field_Matrix, String Color) {
        this.Field_Matrix = Field_Matrix;
        this.Color = Color;
    }

    // public abstract void StartTurn(); Already in Interface

    public void setWon() {
        this.Won = true;
    }

    public boolean getWon() {
        return this.Won;
    }

    /**
     * @Description Checks if the selected Line is already full, if not places the
     *              Symbol if so, prompts the user to select a different line
     * @param Line the line that has been selected by the Player
     * @returns Returns false is the Line is already full, true if the Symbol has
     *          been placed
     */
    protected boolean placeSymbol(int Line) {
        boolean setable = false;

        for (int y = 0; y <= 5; y++) {
            // System.out.println(Field_Matrix[Line][y].CheckIfSet());
            if (!Field_Matrix[Line][y].CheckIfSet()) {
                Field_Matrix[Line][y].Fill(this.Color);
                setable = true;
                Field_Matrix[Line][y+1].setSetable(true);
                // System.out.println("Symbol with color: " + this.Color + " at x: " + Line + "
                // y: " + y);
                currentField = Field_Matrix[Line][y];
                break;
            }
        }
        return setable;
    }

    public Field currentField() {
        return currentField;
    }

    public String getColor() {
        return this.Color;
    }
}
