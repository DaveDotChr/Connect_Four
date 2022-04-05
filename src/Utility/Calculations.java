package Utility;

import Connect_Four.Field;
import Connect_Four.Turn;
import Player.Player;
import Player.Teams;

//Functional Class that calculates Moves propability etc.

public class Calculations {

    private Field[][] Field_Matrix;
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

    public boolean is_H_Buildup(Field currentField) {
        //Moves a 4 Field grid from left to right to check all possible Buildup variants
        //If 4 was the placed Field the checks would look like this
        //0 [1 2 3 4] 5 6
        //0 1 [2 3 4 5] 6
        //0 1 2 [3 4 5 6]
        //0 1 2 3 4 5 6

        Teams opposite = null;
        if(currentField.getColor() == Teams.Blue){
            opposite = Teams.Red;
        } else if(currentField.getColor() == Teams.Red){
            opposite = Teams.Blue;
        } else if(currentField.getColor() == Teams.neutral){
            throw new IllegalArgumentException("Field shouldnt be neutral at this point");
        }

        int current_x = currentField.getCoordinates()[0];
        int current_y = currentField.getCoordinates()[1];

        int val = current_x - 3;
        int iterationen = (val > 0 ? 4 - val : 4 + val);
        int initial_x = 0;
        int colorCount = 0;
        int concurrent = 0;

        if ((current_x - 3) > 0) {
            initial_x = current_x - 3;
        }

        for (int i = 0; i < iterationen; i++) {
            colorCount = 0;
            concurrent = 0;
            for (int j = 0; j < 4; j++) {
                if (Field_Matrix[j+initial_x][current_y].colorMatch(currentField.getColor())) {
                    colorCount++;
                    concurrent++;
                } else {
                    if(Field_Matrix[j+initial_x][current_y].colorMatch(opposite)){
                        continue;
                    }
                    concurrent = 0;
                }
            }
            initial_x++;
            if (colorCount == 3 && concurrent != 3) {
                //if 3 in a row is true its not a buildup but a 3 in a row
                //can still be both like this -> 0 x x X 0 x 0
                //[0 x x X] 0 x 0 -> no buildup bcs 3 in a row
                //0 [x x X 0] x 0 -> no buildup bsc 3 in a row
                //0 x [x X 0 x] 0 -> Buildup bsc not 3 in a row but 3 in grid of 4
                return true;
            }
        }
        return false;
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
        System.out.println(is_H_Buildup(currentPlayer.currentField()));
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
