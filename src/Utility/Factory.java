package Utility;

import Connect_Four.Field;

public class Factory {
    
    public static Calculations createCalculations(Field[][] Matrix){
        return new Calculations(Matrix);
    }

}
