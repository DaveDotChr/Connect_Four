package Connect_Four;

public class Field {
    
    private String Color;
    private boolean Set;
    private int x_pos;
    private int y_pos;
    private static int FieldCount = 1;


    public Field(int x_pos, int y_pos){
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.Set = false;
        this.Color = " ";
        //System.out.println("Field " + FieldCount + " created" + x_pos + " <x-y> " + y_pos);
        FieldCount++;
    }


    public void Fill (String setColor){
        this.Color = setColor;
        this.Set = true;
    }

    public boolean CheckIfSet(){
        return this.Set;
    }

    public String CheckColor(){
        return Color;
    }

    public int[] getCoordinates(){
        int[] re = {x_pos, y_pos};
        return re;
    }

    
}
