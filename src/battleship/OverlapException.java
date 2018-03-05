package battleship;

public class OverlapException extends BattleshipException {

    public static final String OVERLAP = "Ships placed in overlapping positions";


    public OverlapException(int row, int column) {
        super(row, column,OVERLAP);
    }
}
