package Connect_Four;

public class Field {
    
    private String Color;
    private boolean Set;
    private int x_pos;
    private int y_pos;
    private static int FieldCount = 1;
    public double prediction = 1.0;
    private boolean setable;
    private String[] predColor = {"1","","","","","","",""};


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

    public void setSetable(boolean bool){
        this.setable = bool;
    }

    public boolean isSetable(){
        return this.setable;
    }

    public void calculatePrediction(){
        this.prediction = 9;
    }

    public String getPrediction(){
        if(this.Set == true){
            return " X ";
        }
        if(this.setable == false){
            return "0.0";
        }
        return String.valueOf(this.prediction);
    }
    
}
