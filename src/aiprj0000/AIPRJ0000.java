/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiprj0000;

import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class AIPRJ0000 {

    final int size = 2;

    public static void main(String[] args) {

        Game g = new Game();
        GameBoard b1 = new GameBoard();
        String[] board = new String[9];
        b1.reset();
       // System.out.println(b1.toString());
        Scanner scan = new Scanner(System.in);
        String in = "";
        System.out.println("What would you like to do?");
        char c = 'x'; 
        int move=0;
        while (!in.equalsIgnoreCase("quit")) {
            System.out.println(b1.toString());
            System.out.println("You can type in 0-8 to move there or type in ? for help or exit to quit or r to reset");
            in = scan.nextLine();
            c=in.charAt(0);
            System.out.println("it now the computers turn threre are "+g.getAvalMoves(b1.board));
            
            if(in.equalsIgnoreCase("?")){
                b1.help();
            }
            if(Character.isDigit(c)){
                move=Integer.parseInt(in);
                b1.move(move,1);
            }
            if(in.equalsIgnoreCase("r")){
                b1.reset();
            }
            if(b1.hasWon(1)){
                System.out.println("player has won");
                System.out.println("would you like to play again y for yes n for no");
                in = scan.nextLine();
                if(in.equalsIgnoreCase("n")){
                    System.out.println("Thanks for playing ");
                    break;
                }else {
                    b1.reset();
                }
            }
           
            
        
        }
    }

}
