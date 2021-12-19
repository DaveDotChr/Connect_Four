package Connect_Four;

import Player.Player;

public abstract class General_Functions {
    
    private Field[][] Field_Matrix;

    public General_Functions (Field[][] Field_Matrix){
        this.Field_Matrix = Field_Matrix;
    }

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

    public boolean checkHorizontal(Player currentPlayer){
        int concurrent = 0;
        int c_y = currentPlayer.currentField().getCoordinates()[1];
        
        for (int x = 0; x <= 6; x++) {
            if (this.Field_Matrix[x][c_y].CheckColor().equals(currentPlayer.getColor())) {
                concurrent++;
            } else {
                concurrent = 0;
            }
            if (concurrent == 4)
                return true;
        }
        
        return false;
    }
    //Checks how many Field of a specific Color Match and returns the number
    public int checkHorizontal(String match, int c_y){
        int concurrent = 0;
        for (int x = 0; x <= 6; x++) {
            if (this.Field_Matrix[x][c_y].CheckColor().equals(match)) {
                concurrent++;
            } else {
                concurrent = 0;
            }
            if (concurrent == 4)
                return concurrent;
        }
        
        return concurrent;
    }

    public boolean checkVertical(Player currentPlayer){
        int concurrent = 0;
        int c_x = currentPlayer.currentField().getCoordinates()[0];
        for (int y = 0; y <= 5; y++) {
            if (this.Field_Matrix[c_x][y].CheckColor().equals(currentPlayer.getColor())) {
                concurrent++;
            } else {
                concurrent = 0;
            }
            if (concurrent == 4)
                return true;
        }
        return false;
    }


    public boolean checkDiagonals(Player currentPlayer){
        int concurrent = 0;
        int c_y = currentPlayer.currentField().getCoordinates()[1];
        int c_x = currentPlayer.currentField().getCoordinates()[0];
        int[] lineStart = findLowest(c_x, c_y, "ll");
        int tempx = lineStart[0];
        int tempy = lineStart[1];
        String match = currentPlayer.getColor();

        // has to check direction up right
        while (tempx <= 6 && tempy <= 5) {
            if (this.Field_Matrix[tempx][tempy].CheckColor().equals(match)) {
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
            if (this.Field_Matrix[tempx][tempy].CheckColor().equals(match)) {
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

}
