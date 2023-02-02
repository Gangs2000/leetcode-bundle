package MemoiDPAndBackTracking;

import java.util.Scanner;

public class WordSearch {
    boolean searchDone=false;
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){         
                    searchWord(i, j, 0, word, board);                    
                    if(searchDone)
                        return true;
                }
            }
        }
        return false;
    }
    public void searchWord(int i, int j, int currentCharIndex, String word, char[][] board){        
        if(currentCharIndex==word.length()){
            searchDone=true;
            return ;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[i].length || board[i][j]=='.')
            return ;                
        if(board[i][j]==word.charAt(currentCharIndex)){
            char storeChar=board[i][j];
            board[i][j]='.';
            searchWord(i, j-1, currentCharIndex+1, word, board);       //Left
            searchWord(i, j+1, currentCharIndex+1, word, board);       //Right
            searchWord(i-1, j, currentCharIndex+1, word, board);       //Top
            searchWord(i+1, j, currentCharIndex+1, word, board);       //Bottom            
            board[i][j]=storeChar;
        }        
    }
    public static void main(String[] args){
        Scanner sc;
        char[][] board;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter M and N value : ");
            int m=sc.nextInt();
            int n=sc.nextInt();
            board=new char[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    board[i][j]=sc.next().charAt(0);
                }
            }
            System.out.println("Enter word to be searched in board : ");
            String word=sc.next();
            System.out.println(new WordSearch().exist(board, word));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
