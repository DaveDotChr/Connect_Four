package AI;

import java.util.Random;

import Connect_Four.Field;
import Player.Actions;
import Player.Teams;
import Utility.Calculations;
import Utility.Factory;
import Connect_Four.Turn;

public class AI implements Actions {

    private Field[][] Field_Matrix;
    private Calculations calc;
    private Turn turn;
    private Random r = new Random();
    private Teams Color;
    private Field currentField;
    private boolean Won;

    public AI(Field[][] Field_Matrix, Teams Color) {
        
        this.Field_Matrix = Field_Matrix;
        Factory.createCalculations(Field_Matrix);
        this.Color = Color;
    }

    @Override
    public void StartTurn() {
        // Has to make descision of what to do
        placeSymbol(Descision());

        evaluate_turn();
    }

    private int Descision() {
        return r.nextInt(6);
    }

    private void evaluate_turn() {

    }
    

    //May want to not inherit this Method at all since it will work differently anyways
    public void placeSymbol(int Line) {
        for (int y = 0; y <= 5; y++) {
            // System.out.println(Field_Matrix[Line][y].CheckIfSet());
            if (!Field_Matrix[Line][y].CheckIfSet()) {
                Field_Matrix[Line][y].Fill(this.Color);
                // System.out.println("Symbol with color: " + this.Color + " at x: " + Line + "
                // y: " + y);
                currentField = Field_Matrix[Line][y];
                break;
            }
        }

    }

    @Override
    public Field currentField() {
        return this.currentField;
    }

    @Override
    public Teams getColor() {
        return this.Color;
    }

    @Override
    public boolean getWon() {
        return this.Won;
    }

    @Override
    public void setWon() {
        this.Won = true;
    }
}
