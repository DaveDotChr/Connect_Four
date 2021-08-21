package Connect_Four;
import Player.Player;
import Player.AI;

public class Connect_Four {

    private Field Field;
    private Field[][] Field_Matrix; 
    private Player[] Players;
    private AI[] AI_List;

    public Connect_Four(){
        this.Field_Matrix = new Field[7][6];
        initFieldMatrix();
    }


    private void initFieldMatrix(){
        for (int x = 0; x <= 6; x++) {

            for(int y = 0; y <= 5; y++){
                this.Field_Matrix[x][y] = new Field(x,y);
            }
        }
    }

    public boolean CheckWincondition(Field Field){
        boolean result = false;



        return result;
    }


}
