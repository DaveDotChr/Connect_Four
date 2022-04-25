package Utility;

import Connect_Four.Field;
import Connect_Four.Turn;
import Player.Player;
import Player.Teams;

//Functional Class that calculates Moves propability etc.

public class Calculations {

    protected Field[][] Field_Matrix;
    private int Turnnum = 0;

    public Calculations(Field[][] Field_Matrix) {
        this.Field_Matrix = Field_Matrix;
    }

    public void calcPredictions() {
        for (int x = 0; x <= 6; x++) {
            for (int y = 0; y <= 5; y++) {
                Field field = Field_Matrix[x][y];
                if (field.isSetable()) {
                    // Logic for calcualation here
                }
            }
        }
    }

    // Checks how many Field of a specific Color Match and returns the number
    public int h_concurrentConnections(Teams match, int c_y) {
        // Check for connections in straight line
        int concurrent = 0;

        for (int x = 0; x <= 6; x++) {
            if (this.Field_Matrix[x][c_y].colorMatch(match)) {
                concurrent++;
            } else {
                concurrent = 0;
            }
            if (concurrent == 4)
                return concurrent;
        }
        return concurrent;
    }

    /**
     * @Description Helper method for Diagonal Checks
     * @param direction if "ll" -> Finds the lowest Field down the left diagonal
     *                  if "lr" -> Finds the lowest Field down the right diagonal
     */
    public int[] findLowest(int x, int y, String direction) {
        int[] result = { 0, 0 };
        if (direction.equals("ll")) {
            while (x != 0 && y != 0) {
                x--;
                y--;
            }
            result[0] = x;
            result[1] = y;
        } else if (direction.equals("lr")) {
            while (x != 6 && y != 0) {
                x++;
                y--;
            }
            result[0] = x;
            result[1] = y;
        }

        return result;
    }

    /**
     * @Description Basic Horizontal Win Check
     */
    public boolean checkHorizontal(Player currentPlayer) {
        int concurrent = 0;
        int c_y = currentPlayer.currentField().getCoordinates()[1];

        for (int x = 0; x <= 6; x++) {
            if (this.Field_Matrix[x][c_y].colorMatch(currentPlayer.getColor())) {
                concurrent++;
            } else {
                concurrent = 0;
            }
            if (concurrent == 4)
                return true;
        }

        return false;
    }

    /**
     * @Description Basic Vertical Win Check
     */
    public boolean checkVertical(Player currentPlayer) {
        int concurrent = 0;
        int c_x = currentPlayer.currentField().getCoordinates()[0];
        for (int y = 0; y <= 5; y++) {
            if (this.Field_Matrix[c_x][y].colorMatch(currentPlayer.getColor())) {
                concurrent++;
            } else {
                concurrent = 0;
            }
            if (concurrent == 4)
                return true;
        }
        return false;
    }

    /**
     * @Description Basic Diagonal Win Check
     */
    public boolean checkDiagonals(Player currentPlayer) {
        int concurrent = 0;
        int c_y = currentPlayer.currentField().getCoordinates()[1];
        int c_x = currentPlayer.currentField().getCoordinates()[0];
        int[] lineStart = findLowest(c_x, c_y, "ll");
        int tempx = lineStart[0];
        int tempy = lineStart[1];
        Teams match = currentPlayer.getColor();

        // has to check direction up right
        while (tempx <= 6 && tempy <= 5) {
            if (this.Field_Matrix[tempx][tempy].colorMatch(match)) {
                concurrent++;
            } else {
                concurrent = 0;
            }
            if (concurrent == 4)
                return true;
            tempx++;
            tempy++;
        }
        concurrent = 0;

        // Has to check direction up left
        lineStart = findLowest(c_x, c_y, "lr");
        tempx = lineStart[0];
        tempy = lineStart[1];

        while (tempx >= 0 && tempy <= 5) {
            if (this.Field_Matrix[tempx][tempy].colorMatch(match)) {
                concurrent++;
            } else {
                concurrent = 0;
            }
            if (concurrent == 4)
                return true;
            tempx--;
            tempy++;
        }
        return false;
    }

    public Turn CheckWincondition(Player currentPlayer) {
        Turn turn = new Turn(Turnnum, currentPlayer.currentField());
        Turnnum++;
        // Directional Checks
        
        if (checkHorizontal(currentPlayer) || checkDiagonals(currentPlayer) || checkVertical(currentPlayer)) {
            currentPlayer.setWon();
        }

        return turn;
    }

    /**
     * @Description Kann genutzt werden um die Ki für einen guten Zug zu belohnen
     *              oder
     *              einen versäumten Gewinn zu bestrafen.
     * @param ? Evtl Turn Objekt oder Koordinaten
     * @returns Gibt true zurück wenn das spiel in dem Momentanen Zug gewinnar war.
     */
    private void winnable(Turn turn) {
        // TODO Implementieren

    }

}
