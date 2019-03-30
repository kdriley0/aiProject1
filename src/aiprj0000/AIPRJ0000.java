/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiprj0000;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class AIPRJ0000 {

    final int size = 2;
    static int turnsTaken = 0;
    static Player h = new Player(0);
    static Player ai = new Player(0);
    static Random r;
    static Ai g = new Ai();
    static GameBoard gb = new GameBoard();
    static String in = "";
    static int move = 0;
    static char c = 'x';
    static boolean turn;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        r = new Random();

        String[] board = new String[9];
        gb.reset();

        // System.out.println(b1.toString());
        boolean turn = r.nextBoolean();

        System.out.println("Welcome to Tic Tak Toe!");

        while (!in.equalsIgnoreCase("quit") && !in.equalsIgnoreCase("q") && !in.equalsIgnoreCase("exit")) {// game loop
            System.out.println(gb.toString());//printing out the gb

            if (turnsTaken == 0) {// choosing who goes first
                if (turn) {
                    h = new Player(1);
                    ai = new Player(-1);
                } else {
                    h = new Player(-1);
                    ai = new Player(1);
                }
            }
            if (h.symbol == 1) {//human is X
                if (turnsTaken == 0) {
                    System.out.println("You go first you are X");
                }
                humanTurn();
            } else if (ai.symbol == 1) {//ai is X
                //gb.move(g.findNextMove(), ai.symbol);                                                                                          
                System.out.println(gb.toString());//printing out the gb
                aiTurn();
            }
            if (h.symbol == 1 && turnsTaken % 2 == 0) {
                humanTurn();
            } else if (h.symbol == 1 && turnsTaken % 2 == 1) {
                aiTurn();
            }
            if (ai.symbol == 1 && turnsTaken % 2 == 0) {
                aiTurn();
            } else if (ai.symbol == 1 && turnsTaken % 2 == 1) {
                humanTurn();
            }

        }//end game loop
    }

    public static void humanTurn() {
        System.out.println("You can type in 0-8 to move there or type in ? for help or exit to quit or r to reset");
        in = scan.nextLine();
        if (in.isEmpty()) {
            System.out.println(gb.toString());//printing out the gb
        } 
        else {
            c = in.charAt(0);
            if (in.equalsIgnoreCase("r")) {
                gb.reset();
                reset();
                turnsTaken = 0;
            }
            if (in.equalsIgnoreCase("?")) {
                gb.help();
            }
            if (Character.isDigit(c)) {
                move = Integer.parseInt(in);
                if (gb.move(move, h.symbol)) {
                    turnsTaken++;
                } else {
                    System.out.println("You cannot move there please try againt");
                    in= scan.nextLine();
                    move = Integer.parseInt(in);
                    if (gb.move(move, h.symbol)) {
                        turnsTaken++;
                    } else {
                        System.out.println("You cannot move there either you forfit your turn");
                    }

                }
                if (gb.hasWon(1)) {
                    System.out.println("player has won");
                    System.out.println("would you like to play again y for yes n for no");
                    in = scan.nextLine();
                    if (in.equalsIgnoreCase("n")) {
                        System.out.println("Thanks for playing ");
                        in = "quit";
                    } else {
                        gb.reset();
                        turnsTaken = 0;
                    }

                }
            }

        }
    }

    public static void aiTurn() {

        EvalFcn ef = new EvalFcn(gb.board, ai);
        gb.move(ef.makeMove(), ai.symbol);
        turnsTaken++;
        System.out.println("it now the computers turn threre are have been " + g.getMovesTaken(gb.board));
        System.out.println(gb.toString());//printing out the gb
    }

    public static void reset() {
        turn = r.nextBoolean();
        turnsTaken = 0;
        if (turn) {
            h = new Player(1);
            ai = new Player(-1);
        } else {
            h = new Player(-1);
            ai = new Player(1);
        }
    }

}
