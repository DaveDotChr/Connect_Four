package Connect_Four;

import Player.Player;

public class Rules {
    
    private Field[][] Field_Matrix;
    private Player currentPlayer;
    private int Turnnum = 0;


    public Rules (Field[][] Field_Matrix){
        this.Field_Matrix = Field_Matrix;
    }

    private int[] findLowest(int x, int y, String direction) {
        int[] result = { 0, 0 };
        if (direction.equals("ll")) {
            while (x != 0 && y != 0) {
                x--;
                y--;
            }
            result[0] = x;
            result[1] = y;
            //System.out.println(x + " " + y + " lowest left");
        } else if (direction.equals("lr")) {
            while (x != 6 && y != 0) {
                x++;
                y--;
            }
            result[0] = x;
            result[1] = y;
            //System.out.println(x + " " + y + " lowest right");
        }

        return result;
    }


    public Turn CheckWincondition(Player currentPlayer) {
        Turn turn = new Turn(Turnnum, currentPlayer, this.Field_Matrix);
        Turnnum++;
        this.currentPlayer = currentPlayer;
        String match = currentPlayer.getColor();
        Field current = currentPlayer.currentField();
        int concurrent = 0;
        int c_x = current.getCoordinates()[0];
        int c_y = current.getCoordinates()[1];
        //TODO Export checks into method to make code more readable and not as cluttered
        // Horizontal Check

        for (int x = 0; x <= 6; x++) {
            if (this.Field_Matrix[x][c_y].CheckColor().equals(match)) {
                concurrent++;
            } else {
                concurrent = 0;
            }
            if (concurrent == 4)
                currentPlayer.setWon();
        }
        //System.out.println("Horizontal" + concurrent);
        concurrent = 0;
        // Vertical Check

        for (int y = 0; y <= 5; y++) {
            if (this.Field_Matrix[c_x][y].CheckColor().equals(match)) {
                concurrent++;
            } else {
                concurrent = 0;
            }
            if (concurrent == 4)
                currentPlayer.setWon();
        }
        //System.out.println("Vertical" + concurrent);

        // Diagonal Check
        concurrent = 0;
        int[] lineStart;
        // has to check direction up right
        lineStart = findLowest(c_x, c_y, "ll");
        int tempx = lineStart[0];
        int tempy = lineStart[1];

        while (tempx <= 6 && tempy <= 5) {
            if (this.Field_Matrix[tempx][tempy].CheckColor().equals(match)) {
                concurrent++;
            } else {
                concurrent = 0;
            }
            if (concurrent == 4)
                currentPlayer.setWon();
            tempx++;
            tempy++;
        }
        concurrent = 0;

        // Has to check direction up left
        lineStart = findLowest(c_x, c_y, "lr");
        tempx = lineStart[0];
        tempy = lineStart[1];

        while (tempx >= 0 && tempy <= 5) {
            if (this.Field_Matrix[tempx][tempy].CheckColor().equals(match)) {
                concurrent++;
            } else {
                concurrent = 0;
            }
            if (concurrent == 4)
                currentPlayer.setWon();
            tempx--;
            tempy++;
        }

        return turn;
    }


}
