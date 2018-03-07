package battleship;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
Name: Alexander Hurley
Date: 3/6/2018
 */
public class Battleship {

    public static final String ALL_SHIPS_SUNK = "All ships sunk!";

    public static final String BAD_ARG_COUNT = "Wrong number of arguments for command";

    public static final String MISSING_SETUP_FILE = "No setup file specified.";

    public static final int MAX_DIM = 20;

    public static final String DIM_TOO_BIG = "Board dimensions too big to display.";

    public static final String BAD_CONFIG_FILE = "Malformed board text file";

    public static final String PROMPT = "> ";

    public static final String WHITESPACE = "\\s+";

    private Board board;

    private ArrayList<Ship> ships = new ArrayList<Ship>();


    /*
    constructor that starts the play of the game and reads the file, checks if resuming game or starting one
     */

    public Battleship(String[] args) throws OverlapException, OutOfBoundsException {
        try {
            FileInputStream read = new FileInputStream(args[0]);
            ObjectInputStream obj = new ObjectInputStream(read);
            Battleship battle = (Battleship) obj.readObject();
            battle.play();
        } catch (FileNotFoundException thing) {
            System.out.println(MISSING_SETUP_FILE);
        } catch (IOException | ClassNotFoundException thingy) {
            setUp(args);
        }
    }

    /*
    main method that controls the entire game
     */
    public static void main(String[] args) throws OverlapException, OutOfBoundsException {
        if(args.length != 1){
            System.out.println("bad arg count");
        }
        else {
            Battleship start = new Battleship(args);
            start.play();
        }

    }

    /*
    this save the current state of a game that has been stopped so it can be resumed later
     */
    private boolean save(String[] args) {
        try {
            OutputStream out = new FileOutputStream(args[1]);
            ObjectOutputStream oon = new ObjectOutputStream(out);
            oon.writeObject(this);
            return true;
        } catch (FileNotFoundException thing) {
            System.out.println(MISSING_SETUP_FILE);
            return false;
        } catch (IOException thingy) {
            System.out.println("arigato gozaimas sempai!!!");
            return false;
        }

    }

    /*
    this is a helper function that sets up the arraylist of ships and game board dimensions
     */
    private void setUp(String[] args) throws OverlapException, OutOfBoundsException {
        try {
            FileReader file = new FileReader(args[0]);
            BufferedReader read = new BufferedReader(file);
            String line;
            int count = 0;
            while (!((line = read.readLine()) == null)) {
                String[] ary = line.split(" ");
                if (count == 0) {
                    board = new Board(Integer.parseInt(ary[0]), Integer.parseInt(ary[1]));
                    count++;
                } else {
                    if (ary[2] == "HORIZONTAL") {
                        ships.add(new Ship(board, Integer.parseInt(ary[0]), Integer.parseInt(ary[1]), Ship.Orientation.HORIZONTAL, Integer.parseInt(ary[3])));
                    } else {
                        ships.add(new Ship(board, Integer.parseInt(ary[0]), Integer.parseInt(ary[1]), Ship.Orientation.VERTICAL, Integer.parseInt(ary[3])));
                    }
                }
            }
        } catch (IOException bad) {
            System.out.println("The file is invalid");
        }
    }

    /*
    this hits a cell
     */
    private void hit(String[] args) {
        try {
            Cell cell = board.getCell(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            cell.hit();
            board.display(System.out);
        } catch (BattleshipException thing) {
            System.out.println(OutOfBoundsException.PAST_EDGE);
        }
    }

    /*
    returns boolean stating status of game true == game over
     */
    private boolean quit() {
        if (board.allSunk() == true) {
            return true;
        }
        return false;
    }

    /*
    user controls of the game
     */
    private void play() {
        while(true){
            Scanner thing = new Scanner(System.in);
            String[] usr = thing.nextLine().split(" ");
            if(usr[0] == "h" ){
                hit(usr);
            }
            else if(usr[0] == "s"){
                save(usr);
            }
            else if(usr[0] == "q"){
                if(quit() == true) {
                    System.out.println(ALL_SHIPS_SUNK);
                }
            }
            else if(usr[0] == "!"){
                cheat();
            }
        }
    }

    /*
    this allows the user to cheat by seeing where the battleships are
     */
    public void cheat(){
        board.fullDisplay(System.out);
    }
}
