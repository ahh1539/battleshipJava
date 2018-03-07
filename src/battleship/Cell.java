package battleship;

import java.io.Serializable;

/**
 * A single spot on the Battleship game board.
 * A cell knows if there is a ship on it, and it remember
 * if it has been hit.
 */

/*
Name: Alexander Hurley
Date: 3/6/2018
 */
public class Cell implements Serializable {

    private Ship ship;
    private Boolean hit = false;

    /**
     * Character to display for a ship that has been entirely sunk
     */
    public static final char SUNK_SHIP_SECTION = '*';

    /**
     * Character to display for a ship that has been hit but not sunk
     */
    public static final char HIT_SHIP_SECTION = '☐';

    /**
     * Character to display for a water cell that has been hit
     */
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


    private int row;
    private int column;


    public Cell(int row, int column) {
        this.row = row;
        this.column = column;

    }

    /**
     * Place a ship on this cell. Of course, ships typically cover
     * more than one Cell, so the same ship will usually be passed
     * to more than one Cell's putShip method.
     *
     * @param ship the ship that is to be on this Cell
     * @throws OverlapException if there is already a ship here.
     */
    // TODO putShip GOES HERE

    /*
    Puts ship into a cell
     */
    public void putShip(Ship ship) throws OverlapException {
        if (this.ship == null) {
            this.ship = ship;
        } else
            throw new OverlapException(this.row, this.column);

    }

    /*
    sets status of a ship cell as hit or not hit
     */
    public void hit() throws CellPlayedException {
        if (hit == true) {
            System.out.println(CellPlayedException.ALREADY_HIT);
            throw new CellPlayedException(this.row, this.column);
        } else {
            hit = true;
            if(ship != null) {
                ship.hit();
            }
        }

    }

    /*
    Return a character representing the state of this Cell but without revealing unhit portions of ships
     */
    public char displayHitStatus() {
        if(ship != null) {
            if (ship.isSunk()) {
                return SUNK_SHIP_SECTION;
            }
            if (!(ship.isSunk()) && hit == true) {
                return HIT_SHIP_SECTION;
            }
        }

        if (this.ship == null && hit) {
            return HIT_WATER;
        } else {
            return PRISTINE_WATER;
        }

    }

    /*
    Return a character representing the state of this Cell
     */
    public char displayChar() {
        if(ship != null) {
            if (ship.isSunk()) {
                return SUNK_SHIP_SECTION;
            }
            if (hit == true) {
                return HIT_SHIP_SECTION;
            }
            else if(hit == false) {
                return HIDDEN_SHIP_SECTION;
            }
        }
        else if (this.ship == null && hit == true) {
            return HIT_WATER;
        }
        return PRISTINE_WATER;


    }

}
