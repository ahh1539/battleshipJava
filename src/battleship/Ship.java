package battleship;

import java.io.Serializable;
/*
Name: Alexander Hurley
Date: 3/6/2018
 */
/**
 * A single ship in a Battleship game
 */
public class Ship implements Serializable {

    /*
    fields used in this class
     */
    private int count = 0;
    private int uRow;
    private Board board;
    private int lCol;
    private int length;
    private Ship.Orientation ort;

    public static final String SUNK_MESSAGE = "A battleship has been sunk!";

    /**
     * Orientation is a property of a ship.
     * The names of the enum values were chosen because they
     * are descriptive and match the words put in the configuration
     * files.
     *
     * @see Orientation#"valueOf"(String)
     */
    public enum Orientation {
        HORIZONTAL( 0, 1 ), VERTICAL( 1, 0 );

        /**
         * Use it to loop through all of the cell locations a ship
         * is on, based on the upper left end of the ship.
         */
        public int rDelta, cDelta;

        /**
         * Associate a direction vector with the orientation.
         * @param rDelta how much the row number changes in this direction
         * @param cDelta how much the column number changes
         *               in this direction
         */
        Orientation( int rDelta, int cDelta ) {
            this.rDelta = rDelta;
            this.cDelta = cDelta;
        }
    }

    /**
     * Initialize this new ship's state. Tell the Board object
     * and each involved Cell object about the existence of this
     * ship by trying to put the ship at each applicable Cell.
     * @param board holds a collection of ships
     * @param uRow the uppermost row that the ship is on
     * @param lCol the leftmost column that the ship is on
     * @param ort the ship's orientation
     * @param length how many cells the ship is on
     * @throws OverlapException if this ship would overlap another one
     *              that already exists
     * @throws OutOfBoundsException if this ship would extend beyond
     *              the board
     */
    // TODO Write your code here.

    /*
    This is the constructor for the Ship class with creates a type ship
     */
    public Ship(Board board, int uRow, int lCol, Ship.Orientation ort, int length)throws OverlapException, OutOfBoundsException{
        this.board = board;
        this.uRow = uRow;
        this.lCol = lCol;
        this.length = length;
        this.ort = ort;
        if(!(uRow > board.getHeight() || uRow < board.getHeight() || lCol > board.getWidth() || lCol < board.getWidth())){
            if(ort == Orientation.HORIZONTAL){
                int i = 0;
                while(i <= length){
                    board.getCell(uRow,lCol+i).putShip(this);
                    i++;
                }
            }
            if(ort == Orientation.VERTICAL){
                int i = 0;
                while(i <= length){
                    board.getCell(uRow+i,lCol).putShip(this);
                    i++;
                }
            }
        }
    }

    /*
    Returns the number of times ship is hit, if
    hit as many times as length retuns sunk message
     */
    public void hit(){
        count++;
        if(count == this.length){
            System.out.println(SUNK_MESSAGE);
        }

    }

    /*
    returns the state of the ship if it is sunk or not
     */
    public boolean isSunk(){
        if(count==this.length){
            return true;
        }
        else{
            return false;
        }

    }

}
