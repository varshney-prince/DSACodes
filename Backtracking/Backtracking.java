package Backtracking;

public class Backtracking {

    public static void findSubsets(String str , int i , String ans){
        if(i==str.length()){
            if(ans.length()==0){
                System.out.print("null"+ " ");
            }
            else{
                System.out.print(ans+ " ");
            }
            return;
        }

        findSubsets(str, i+1, ans+str.charAt(i));
        findSubsets(str, i+1, ans);
    }

    public static void findPermutation(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
        }
        
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            String remaing=str.substring(0,i)+str.substring(i+1);
            findPermutation(remaing,ans+curr);
            
        }
    }
   

    public static void nQueen(char[][] board,int row){
      
        if(row==board.length){
            print(board);
            return;
        }
        
        for(int i=0;i<board.length;i++){
           
            if(isSafe(row,i,board)){
                board[row][i]='Q';
                nQueen(board,row+1);
                board[row][i]='X';
            }
           
        }
    }
    
    private static boolean isSafe(int row , int col , char[][] board){
        
        // vertical up
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        
        //Diagonal left up
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        
        // Diagonal right up
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        
        return true;
        
    }
    
    
    public static char[][] makeBoard(int n){
        char board[][] = new char[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='X';
            }
        }
        
        return board;
    }
    
    public static void print(char[][] board){
       System.out.println("--------chess board----------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }


    
}
