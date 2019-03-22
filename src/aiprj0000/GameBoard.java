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

    static int size = 3;
    public final static int X=1, O=-1,EMPTY=0;
    int[][] board = new int[3][3];

    /**
     * makes a new game board
     *
     * or clears game board
     */
    public void reset() {

        for (int i = 0; i < size; ++i) {
            for(int j=0; j<size;j++){
                this.board[i][j] = 0; 
            }
           

        }

    }

    public boolean check(int m) {

        int  k=0;
        for (int i = 0; i < size; ++i) {
           for(int j =0; j< size;j++){
               
           }

            
        }

        return true;
    }

    public boolean move(int m, int turn) {
        if (m < 0 || m > 8) {
            
            return false;
        }
         int  k=0;
        for (int i = 0; i < size; ++i) {
           for(int j =0; j< size;j++){
               if(k==m&&this.board[i][j]==EMPTY){
                   this.board[i][j]=turn;
                   return true;
               }
                k++;
           }

            
        }
   
        return true;
    }
     

    public String toString() {
        String out = "|";
        int k=0;
        for (int i = 0; i < size; ++i) {
            for(int j =0; j< size;j++){
                if(this.board[i][j]==0){
                    out+="-";
                }
                if(this.board[i][j]==1){
                    out+="X";
                }
                if(this.board[i][j]==-1){
                    out+="O";
                }
            }
            k++;
           if(k<3){
                out+="|\n|";
           }else{
               out+="|";
           }
              
           
            
            
        }
      

        return out;
    }
    public static void help(){
        System.out.println("You can type in 0-8 to move there or or exit to quit\nfor example if you type in 0 you will move in the first position\n"
                + "if you type 8 you will move in the 8th position or the last the board is as follows"
                + "0, 1, 2"
                + "3, 4, 5"
                + "6, 7, 8");
    }
    
    public boolean hasWon(String[] b){
        
        return false;
    }
}
