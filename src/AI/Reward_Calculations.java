package AI;

import Connect_Four.Field;
import Utility.Calculations;
import Player.Teams;

public class Reward_Calculations extends Calculations{

    
    public Reward_Calculations(Field[][] Field_Matrix) {
        super(Field_Matrix);
    }
    
    /**
     * @Description Checks if the field contributed to a buildup in a horizontal line
     * @param Field Element that is not neutral
     * @return true if buildup false if not
     */
    public boolean is_H_Buildup(Field currentField) {
        //Moves a 4 Field grid from left to right to check all possible Buildup variants
        //If 4 was the placed Field the checks would look like this
        //0 [1 2 3 4] 5 6
        //0 1 [2 3 4 5] 6
        //0 1 2 [3 4 5 6]
        //0 1 2 3 4 5 6

        Teams opposite = Teams.getOpposite(currentField.getColor());

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


    public boolean is_D_Buildup(Field currentField) {
        //Moves a 4 Field grid from left to right to check all possible Buildup variants
        //If 4 was the placed Field the checks would look like this
        //0 1 2 3 4 5 6
        //0 1 2 3 [4] 5 6
        //0 1 2 [3] 4 5 6
        //0 1 [2] 3 4 5 6
        //0 [1] 2 3 4 5 6
        //0 1 2 3 4 5 6

        Teams opposite = Teams.getOpposite(currentField.getColor());

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
    
}
