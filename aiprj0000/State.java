/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiprj0000;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author kevin
 */
public class State {
    GameBoard gb = new GameBoard();
    int[][] board;
    int player;
    public State(int[][] board,int player){
        this.board=board;
        this.player=player;
    }
   public int[] getActions(){
        int[] moves = new int[9];
       
        return moves;
    }
   public boolean isTerminal(){
       return gb.hasWon(this.player);
       
   }
   public int getUtility(){
       return 0;
   }
}
