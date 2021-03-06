package battleship;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;

/*
Name: Alexander Hurley
Date: 3/6/2018
 */

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
     *
     * @param ship the as-yet un-added ship
     * @rit.pre This ship has already informed the Cells of the board
     * that are involved.
     * @see Cell#putShip(Ship)
     */
    // TODO addShip GOES HERE

    private int height;
    private int width;
    private Cell[][] board;
    private ArrayList<Ship> ships = new ArrayList<>();

    /*
    This creates the game board
     */
    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        board = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = new Cell(i, j);
            }
        }
    }

    /*
    returns the height of the game board
     */
    public int getHeight() {
        return this.height;
    }

    /*
    returns the width of the game board
     */
    public int getWidth() {
        return this.width;
    }

    /*
    this finds ands returns the cell at a row and column
     */
    public Cell getCell(int row, int column) throws OutOfBoundsException {
        if (!(row >= this.getHeight() || row < 0 || column >= this.getWidth() || column < 0)) {
            return board[row][column];
        } else {
            throw new OutOfBoundsException(row, column);
        }
    }


/*
    public String toString(){


    }
*/

    /*
    Displays the board in character form to the user
     */
    public void display(PrintStream out) {
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < width; i++) {
            t.append(" ");
            t.append(i);
        }
        t.append("\n");
        for (int row = 0; row < height; row++) {
            t.append(row);
            t.append(" ");
            for (int column = 0; column < width; column++) {
                t.append(" ");
                t.append(board[row][column].displayHitStatus());
            }
            t.append("\n");
        }
        out.println(t.toString());
    }

    /*
    Displays the board with the unsunk parts of ship
     */

    public void fullDisplay(PrintStream out) {
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < width; i++) {
            t.append(" ");
            t.append(i);
        }
        t.append("\n");
        for (int row = 0; row < height; row++) {
            t.append(row);
            t.append(" ");
            for (int column = 0; column < width; column++) {
                t.append(" ");
                t.append(board[row][column].displayChar());
            }
            t.append("\n");
        }
        out.println(t.toString());
    }

    /*
    Adds ship to the game board
     */
    public void addShip(Ship ship) {
        ships.add(ship);

    }

    /*
    returns the state of the game True == game over
     */
    public boolean allSunk() {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).isSunk() == true && i == ships.size()) {
                return true;
            } else if (ships.get(i).isSunk() == true) {
                continue;
            }

        }
        return false;
    }


}
