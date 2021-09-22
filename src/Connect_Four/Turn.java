package Connect_Four;

import Player.Player;
import jdk.jfr.Description;

    /* @Description Not sure how to use this as of yet
    */

public class Turn {

    private int x_pos; //local use
    private int y_pos; //local use
    private Field Field;
    private int connects = 0;
    private int TurnNumber;
    private Player Player;


    public Turn(int Turnnum, Player Player, Field[][] matchstate){
        this.TurnNumber = Turnnum;
        this.Field = Player.currentField();
        this.Player = Player;
        connects();
    }

    private void connects(){
        //TODO Berechnung der sich verbindenden gleichfarbingen Felder bzw direkt in check wincondition methode
        this.connects = 0;
    }

    public int getNumber(){
        return this.TurnNumber;
    }
    
}
