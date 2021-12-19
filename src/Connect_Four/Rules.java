package Connect_Four;

import Player.Player;

public class Rules extends General_Functions{
    
    private Field[][] Field_Matrix;
    private Player currentPlayer;
    private int Turnnum = 0;


    public Rules (Field[][] Field_Matrix){
        super(Field_Matrix);
    }

    public Turn CheckWincondition(Player currentPlayer) {
        Turn turn = new Turn(Turnnum, currentPlayer, this.Field_Matrix);
        Turnnum++;
        this.currentPlayer = currentPlayer;

        //Directional Checks
        if(checkHorizontal(currentPlayer) || checkDiagonals(currentPlayer) || checkVertical(currentPlayer)){
            currentPlayer.setWon();
        }

        return turn;
    }


}
