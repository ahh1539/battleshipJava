package battleship;

import java.io.PrintStream;
import java.io.Serializable;


/**
 * The class to represent the grid of cells (squares).
 * A collection of ships is also kept so the Board
 * can be asked if the game is over.
 * The class is Serializable so that its instance can
 * be saved to a file in binary form using an
 * {@link java.io.ObjectOutputStream} and restored
 * with an {@link java.io.ObjectInputStream}.
 * Because the object holds references to all other
 * objects in the system, no other objects need to
 * be separately saved.
 */
public class Board implements Serializable {

    /**
     * Fetch the Cell object at the given location.
     * @param row row number (0-based)
     * @param column column number (0-based)
     * @return the Cell created for this position on the board
     * @throws OutOfBoundsException if either coordinate is negative or too high
     */
    // TODO getCell GOES HERE


    /**
     * Add a ship to the board. The only current reason that the
     * board needs direct access to the ships is to poll them
     * to see if they are all sunk and the game is over.
     * @see Cell#putShip(Ship)
     * @param ship the as-yet un-added ship
     * @rit.pre This ship has already informed the Cells of the board
     *    that are involved.
     */
    // TODO addShip GOES HERE

    private int height;
    private int width;
    private Cell[][] board;

    /*
    This creates the game board
     */
    public Board(int height, int width){
        this.height = height;
        this.width = width;
        board = new Cell[height][width];
        for(int i = 0 ; i < height; i++){
            for(int j = 0; j < width; j++){
                board[i][j] = new Cell(i, j);
            }
        }

    }

    /*
    returns the height of the game board
     */
    public int getHeight(){
        return this.height;
    }

    /*
    returns the width of the game board
     */
    public int getWidth(){
        return this.width;
    }

    /*
    this finds ands returns the cell at a row and column
     */
    public Cell getCell(int row, int column) throws OutOfBoundsException{
        if(!(row > this.getHeight() || row < this.getHeight() || column > this.getWidth() || column < this.getWidth())){
            return board[row][column];
        }
        else {
            throw  new OutOfBoundsException(row,column);
        }


    }


/*
    public String toString(){


    }
*/



    /*
    Displays the board in character form to the user
     */
    public void display(PrintStream out){
        StringBuilder t = new StringBuilder();
        for(int i = 0; i <= width; i++){
            t.append(" ");
            t.append(t);
        }
        for (int row = 0; row < height; row++){
            t.append(row);
            t.append(" ");
            for(int column = 0; column < width; column++){
                t.append("\n");
                t.append(board[row][column].displayHitStatus());
            }
        }

    }

    /*
    Displays the board with the unsunk parts of ship
     */

    public void fullDisplay(PrintStream out){
        StringBuilder t = new StringBuilder();
        for(int i = 0; i <= width; i++){
            t.append(" ");
            t.append(t);
        }
        for (int row = 0; row < height; row++){
            t.append(row);
            t.append(" ");
            for(int column = 0; column < width; column++){
                t.append("\n");
                t.append(board[row][column].displayChar());
            }
        }

    }

    /*
    Adds ship to the game board
     */
    public void addShip(Ship ship){
        if(ship.isSunk() == true){

        }


    }
    /*
    returns the state of the game True == game over
     */
    public boolean allSunk(){

    }



}
