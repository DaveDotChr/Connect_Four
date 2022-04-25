package Player;

/**
 * @Description Identifies which player set which field or if it is still
 *              neutral
 */
public enum Teams {
    Blue("B"),
    Red("R"),
    neutral(" ");

    private final String shortName;

    Teams(String shortName) {
        this.shortName = shortName;
    }

    public String getshortName() {
        return this.shortName;
    }

    public static Teams getOpposite(Teams team){
        if(neutral == team){
            throw new IllegalArgumentException("Cant return opposite of neutral");
        }
        if(team == Blue){
            return Red;
        } else {
            return Blue;
        }
    }

}
