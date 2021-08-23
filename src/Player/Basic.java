package Player;

import Connect_Four.Field;

public interface Basic {
    

    boolean getWon();

    void setWon();

    //Prompts the Player for Input
    void StartTurn();

    //Returns the Field which has just been set
    Field currentField();

    //Returns the Color of a Player
    String getColor();

}
