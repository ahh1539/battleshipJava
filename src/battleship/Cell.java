package battleship;

import java.io.Serializable;

/**
 * A single spot on the Battleship game board.
 * A cell knows if there is a ship on it, and it remember
 * if it has been hit.
 */
public class Cell implements Serializable {

    /** Character to display for a ship that has been entirely sunk */
    public static final char SUNK_SHIP_SECTION = '*';

    /** Character to display for a ship that has been hit but not sunk */
    public static final char HIT_SHIP_SECTION = '☐';

    /** Character to display for a water cell that has been hit */
    public static final char HIT_WATER = '.';

    /**
     * Character to display for a water cell that has not been hit.
     * This character is also used for an unhit ship segment.
     */
    public static final char PRISTINE_WATER = '_';

    /**
     * Character to display for a ship section that has not been
     * sunk, when revealing the hidden locations of ships
     */
    public static final char HIDDEN_SHIP_SECTION = 'S';


    /**
     * Place a ship on this cell. Of course, ships typically cover
     * more than one Cell, so the same ship will usually be passed
     * to more than one Cell's putShip method.
     * @param ship the ship that is to be on this Cell
     * @throws OverlapException if there is already a ship here.
     */
    // TODO putShip GOES HERE

    public Cell(int row, int column){

    }

    public void putShip(Ship ship) throws OverlapException{

    }

    public void hit() throws CellPlayedException{

    }

    public char displayHitStatus(){

    }

    public char displayChar(){

    }

}
