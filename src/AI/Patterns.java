package AI;

public enum Patterns {

    
    /** @Descripton Prevent enemy from placing 4th in a row*/
    Defend(2),

    /** @Descripton self explanatory*/
    RowOf3(1),
    
    /** @Descripton Any 4 in a row */ 
    Win(3),

    /** @Descripton When 3 interruped are in a row but the last one isnt placeable yet
    -> if other player makes it placeable*/
    SetupEnemyWin(-3),

    /** @Descripton If no other pattern matches*/
    Random(0),

    /** @Descripton When multiple are set in a row but are interrupted*/
    Buildup(1);

    private double turnValue;
    Patterns(double turnValue){
        this.turnValue = turnValue;
    }

    public double getTurnValue(){
        return this.turnValue;
    }

    public void setTurnValue(double adjustBy){
        this.turnValue = this.turnValue * adjustBy;
        System.out.println("TurnValue of "+ this.name() +" has been adjusted to" + this.turnValue);
    }


}
