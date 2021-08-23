package Connect_Four;
import Player.Player;
import Player.AI;
import Player.Human_Player;

public class Connect_Four {

    private Field Field;
    private Field[][] Field_Matrix; 
    private Human_Player[] Players;
    private AI[] AI_List;
    private Player currentPlayer;
    private int PlayerIndex = 0;

    public Connect_Four(){
        this.Field_Matrix = new Field[7][6];
        initFieldMatrix();
        initPlayers();
        startGame();
    }


    private void initFieldMatrix(){
        for (int x = 0; x <= 6; x++) {

            for(int y = 0; y <= 5; y++){
                this.Field_Matrix[x][y] = new Field(x,y);
            }
        }
    }

    private void initPlayers(){
        Players = new Human_Player[2];
        Players[0] = new Human_Player(this.Field_Matrix, "Red");
        Players[1] = new Human_Player(this.Field_Matrix, "Blue");

    }

    private void startGame(){
        //Runs until one Player has won the Game
        while (!Players[0].getWon() && !Players[1].getWon()){
            nextTurn();
        }
        endGame();

    }

    public boolean CheckWincondition(){
        boolean result = false;
        String match = currentPlayer.getColor();
        Field current = currentPlayer.currentField();
        int concurrent = 0;
        int c_x = current.getCoordinates()[0];
        int c_y = current.getCoordinates()[1];
 
        
        //Horizontal Check

        for (int x = 0; x <= 6; x++) {
            if(this.Field_Matrix[x][c_y].CheckColor().equals(match)) concurrent++;
            if(concurrent == 4) currentPlayer.setWon();
        }

        concurrent = 0;
        //Vertical Check

        for (int y = 0; y <= 5; y++) {
            if(this.Field_Matrix[c_x][y].CheckColor().equals(match)) concurrent++;
            if(concurrent == 4) currentPlayer.setWon();
        }

        //Diagonal Check
        int lowest = 0;
        int Diagonal_bottom_left = 0;
        int Diagonal_bottom_right = 0;

        if(c_y < c_x){
            lowest = c_y;
        } else if (c_x < c_y){
            lowest = c_x;
        } else {
            lowest = c_x;
        }


        for (int y = 0; y <= 5; y++) {
            
        }


        return result;
    }

    private void nextTurn(){
       
        currentPlayer = Players[PlayerIndex];
        //Changes Player for next turn
        if(PlayerIndex == 0){
            PlayerIndex = 1;
        } else {
            PlayerIndex = 0;
        }
        currentPlayer.StartTurn();
        CheckWincondition();
    }

    private void endGame(){
        System.out.println("Spieler: " + currentPlayer.getColor() + " hat gewonnen");
        System.exit(0);
    }

}
