package Connect_Four;

import Player.Teams;

public class Turn {

    private int x_pos; //local use
    private int y_pos; //local use
    private int[] coordinates = new int[2];
    private Teams color = Teams.neutral;
    //private Field Field; //Can be recreated by x, y and Color
    //private int connects = 0;
    private int TurnNumber;
    //private Player Player;

    public Turn(int Turnnum, Field currentField){
        this.TurnNumber = Turnnum;
        this.color = currentField.getColor();
        this.x_pos = currentField.getCoordinates()[0];
        this.y_pos = currentField.getCoordinates()[1];      
        this.coordinates[0] = x_pos;
        this.coordinates[1] = y_pos;
    }

    public int getNumber(){
        return this.TurnNumber;
    }

    public int[] getCoordinates(){
        return this.coordinates;
    }

    public Teams getColor(){
        return this.color;
    }

}
