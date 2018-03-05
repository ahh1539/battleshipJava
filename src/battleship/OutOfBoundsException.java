package battleship;

public class OutOfBoundsException extends BattleshipException {

    public static final String PAST_EDGE = "Co\u00f6rdinates are past board edge";


    public OutOfBoundsException(int row, int column) {
        super(row, column, PAST_EDGE);
    }
}
