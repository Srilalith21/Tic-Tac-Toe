package game;

import java.util.Scanner;

class TicTacToe{
    
    char board[][];
    
    public TicTacToe(){
        board = new char[3][3];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                board[i][j] = ' ';
            }
        }
    }
    void displayBoard(){
        System.out.println("  -------------");
        for(int i=0; i<board.length; i++){
            System.out.print("  | ");
            for(int j=0; j<board[i].length; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("  -------------");
        }
    }
    void writeInBoard(int row,int col, char value){
        board[row][col] = value;
    }
}

// Main Method and public class
public class Main {
    
    static TicTacToe t = new TicTacToe(); //Global use
    
    static int[] processBoard(){
        Scanner sc = new Scanner(System.in);
        int row = 0;
        int col = 0;
        while(true){
            try{
                System.out.print("Enter Row Value : ");
                row = sc.nextInt();
                System.out.print("Enter Coloumn Value : ");
                col = sc.nextInt();
                if((row >= 0 && row < 3) && (col >= 0 && col < 3)){
                    break;
                }
            }
            catch(Exception error){
                System.out.println("Invalid Entry please enter integer values between 0 and 3");
                System.out.println();
                sc.next();
            }
        }
        int returnValue[] = {row,col};
        return returnValue;
    }
    
    static boolean checkWinner(){
        boolean condition = false;
        //Possible cases
        if (((t.board[0][0] == 'x' && t.board[0][1] == 'x' && t.board[0][2] == 'x') || (t.board[1][0] == 'x' && t.board[1][1] == 'x' && t.board[1][2] == 'x') || (t.board[2][0] == 'x' && t.board[2][1] == 'x' && t.board[2][2] == 'x') ||(t.board[0][0] == 'x' && t.board[1][0] == 'x' && t.board[2][0] == 'x') || (t.board[0][1] == 'x' && t.board[1][1] == 'x' && t.board[2][1] == 'x') || (t.board[0][2] == 'x' && t.board[1][2] == 'x' && t.board[2][2] == 'x') || (t.board[0][0] == 'x' && t.board[1][1] == 'x' && t.board[2][2] == 'x') || (t.board[0][2] == 'x' && t.board[1][1] == 'x' && t.board[2][0] == 'x'))){
            condition = true; // Player 'x' wins
        }
        
        else if (((t.board[0][0] == 'o' && t.board[0][1] == 'o' && t.board[0][2] == 'o') || (t.board[1][0] == 'o' && t.board[1][1] == 'o' && t.board[1][2] == 'o') || (t.board[2][0] == 'o' && t.board[2][1] == 'o' && t.board[2][2] == 'o') ||(t.board[0][0] == 'o' && t.board[1][0] == 'o' && t.board[2][0] == 'o') ||(t.board[0][1] == 'o' && t.board[1][1] == 'o' && t.board[2][1] == 'o') ||(t.board[0][2] == 'o' && t.board[1][2] == 'o' && t.board[2][2] == 'o') ||(t.board[0][0] == 'o' && t.board[1][1] == 'o' && t.board[2][2] == 'o') ||(t.board[0][2] == 'o' && t.board[1][1] == 'o' && t.board[2][0] == 'o'))){
            condition = true;
        }
        
        else{
            condition = false;
        }
        
        return condition;
    }
    
    /*
        TO-DO:- 
        1.Automatic board solver.
        2.Help Section in command prompt.
        3.check the game points and drawn game.
        4.Random value of the cell should be done in the beginning.
    */
    
    /* 
        Bug:-
        1.If the player has given data to a cell then the next player or the current player can overwrite on it
            This need to be fixed ..! and it will be fixed.
    */
    
    public static void main(String[] args) {
        t.writeInBoard(1,1,'o');
        t.displayBoard();
        System.out.println();
        boolean flag = false;
        String value = "";
        for(int i=0; i<9; i++){
            int rowColData[] = processBoard(); // Calling function and storing a storing array address in a variable
            if(i%2 == 0){
                System.out.println("\n\tPlayer 1's Turn ");
                t.writeInBoard(rowColData[0],rowColData[0+1],'x');
                value = "Player 1";
                flag = checkWinner();
            }else{
                System.out.println("\n\tPlayer 2's Turn ");
                t.writeInBoard(rowColData[0],rowColData[0+1],'o');
                value = "Player 2";
                flag = checkWinner();
            }
            t.displayBoard();
            if(flag){
                break;
            }
        }
        System.out.print("Congragulations " + value + " Won the Game..!");
        System.out.println("\n\t Thank You ");
    }
}