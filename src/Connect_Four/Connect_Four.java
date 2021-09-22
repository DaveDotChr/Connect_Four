package Connect_Four;

import Player.Player;

import java.util.ArrayList;

import AI.AI;
import Player.Human_Player;

public class Connect_Four implements Runnable{

    private Field[][] Field_Matrix;
    private Human_Player[] Players;
    private Player currentPlayer;
    private int PlayerIndex = 0;
    private StringBuilder str = new StringBuilder();
    private AI[] AI_Players;
    private Rules rules;
    private Turn turn;
    ArrayList<ArrayList<Turn>> list;
    //TODO Write Data of Turns array to File for reuse etc.
    private ArrayList<Turn> Turns = new ArrayList<Turn>();

    public Connect_Four(ArrayList<ArrayList<Turn>> list) {
        this.list = list;
    }

    private void initFieldMatrix() {
        for (int x = 0; x <= 6; x++) {

            for (int y = 0; y <= 5; y++) {
                this.Field_Matrix[x][y] = new Field(x, y);
            }
        }
        this.rules = new Rules(Field_Matrix);
    }

    public void run(){
        System.out.println("Game started");
        this.Field_Matrix = new Field[7][6];
        initFieldMatrix();
        initPlayers(); //Decide if want Ai or Human Players/ maybe mix to test 1 Ai vs 1 Human
        startGame();
    }

    private void initPlayers() {
        Players = new Human_Player[2];
        Players[0] = new Human_Player(this.Field_Matrix, "R");
        Players[1] = new Human_Player(this.Field_Matrix, "B");

        
        AI_Players = new AI[2];
        AI_Players[0]= new AI(this.Field_Matrix, "R");
        AI_Players[1]= new AI(this.Field_Matrix, "B");

    }

    private void startGame() {
        // Runs until one Player has won the Game
        while (!Players[0].getWon() && !Players[1].getWon()) {
            nextTurn();
        }
        endGame();

    }

    private void nextTurn() {
        currentPlayer = Players[PlayerIndex];
        System.out.println("Turn: " + currentPlayer.getColor());
        // Changes Player for next turn
        if (PlayerIndex == 0) {
            PlayerIndex = 1;
        } else {
            PlayerIndex = 0;
        }
        drawBoard();
        currentPlayer.StartTurn();
        Turns.add(rules.CheckWincondition(currentPlayer));
    }

    private void endGame() {
        list.add(Turns);
        System.out.println("Spieler: " + currentPlayer.getColor() + " hat gewonnen");
        drawBoard();
        System.exit(0);
    }

    private void drawBoard() {
        str.delete(0, str.length());
        for (int y = 5; y >= 0; y--) {
            str.append("     ");
            for (int x = 0; x <= 6; x++) {
                str.append("[" + Field_Matrix[x][y].CheckColor() + "] ");

            }
            str.append("\n");
        }
        str.append("Line [0] [1] [2] [3] [4] [5] [6]");
        System.out.println(str.toString() + "\n ----------------------------------- \n");

    }

}
