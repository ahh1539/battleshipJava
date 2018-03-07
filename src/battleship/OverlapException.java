package battleship;
/*
Name: Alexander Hurley
Date: 3/6/2018
 */
/*
this exception is called when ships overlap each other
 */
public class OverlapException extends BattleshipException {

    public static final String OVERLAP = "Ships placed in overlapping positions";


    public OverlapException(int row, int column) {
        super(row, column,OVERLAP);
    }
}
