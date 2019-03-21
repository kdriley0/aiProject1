/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiprj0000;

/**
 *
 * @author kevin
 */
public class GameBoard {

    static int size = 9;
    String[] board = new String[9];

    /**
     * makes a new game board
     *
     * or clears game board
     */
    public void reset(String[] b) {

        for (int i = 0; i < size; ++i) {

            b[i] = "-";

        }

    }

    public boolean check(int m) {

        for (int i = 0; i < size; ++i) {
         

            
        }

        return true;
    }

    public boolean move(int m) {
        if (m < 0 || m > 8) {
            return false;
        }
        if(this.board[m].equalsIgnoreCase("-")){
            this.board[m]="O";
        }
        // 
        return true;
    }

    public String toString(String[] b) {
        String out = "";
        int j=0;
        for (int i = 0; i < size; ++i) {

            out += "|" + b[i];

            if (i- 2 == 0) {
                out += "|\n";
            }
            if (i- 5 == 0) {
                out += "|\n";
            }
            
        }
        out+= "|";

        return out;
    }
    public static void help(){
        System.out.println("You can type in 0-8 to move there or or exit to quit\nfor example if you type in 0 you will move in the first position\n"
                + "if you type 8 you will move in the 8th position or the last?");
    }
    
    public boolean hasWon(String[] b){
        if(b[0].equalsIgnoreCase("o")&&b[1].equalsIgnoreCase("o")&&b[2].equalsIgnoreCase("o")){
            return true;
        }
        return false;
    }
}
