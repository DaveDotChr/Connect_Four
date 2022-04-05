package Player;

public enum Teams {
    Blue("B"),
    Red("R"),
    neutral(" ");

    private String shortName;

    Teams(String shortName){
        this.shortName = shortName;
    }

    public String getshortName(){
        return this.shortName;
    }

}
