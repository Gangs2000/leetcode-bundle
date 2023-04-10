package MemoiDPAndBackTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WordSearchII {
    List<String> result;    
    public WordSearchII(){
        result=new LinkedList<>();
    }
    public List<String> findWords(char[][] board, String[] words) {
        boolean[][] visited=new boolean[board.length][board[0].length];
        Arrays.stream(visited).forEach(array -> Arrays.fill(array, false));
        for(int i=0;i<words.length;i++){
            if(this.isWordFound(board, words[i], visited))
                result.add(words[i]);
        }
        return result;
    }
    public boolean isWordFound(char[][] board, String word, boolean[][] visited){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(word.length()==1)
                        return true;
                    if(this.backTracking(i, j, board, visited, 0, word))
                        return true;
                }
            }
        }
        return false;
    }
    public boolean backTracking(int i, int j, char[][] board, boolean[][] visited, int currentIndex, String word){
        if(currentIndex==word.length())
            return true;
        if(i<0 || j<0 || i>=board.length || j>=board[i].length || visited[i][j])
            return false;        
        if(board[i][j]==word.charAt(currentIndex)){
            visited[i][j]=true;
            if(this.backTracking(i, j-1, board, visited,currentIndex+1, word)==true){  //Left call
                visited[i][j]=false;
                return true;
            }
            if(this.backTracking(i, j+1, board, visited, currentIndex+1, word)==true){  //Right call
                visited[i][j]=false;
                return true;
            }
            if(this.backTracking(i-1, j, board, visited, currentIndex+1, word)==true){  //Top call
                visited[i][j]=false;
                return true;
            }
            if(this.backTracking(i+1, j, board, visited, currentIndex+1, word)==true){  //Bottom call
                visited[i][j]=false;
                return true;            
            }
            visited[i][j]=false;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc;
        char[][] board;
        String[] words;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter rows and columns value : ");
            int rows=sc.nextInt();
            int columns=sc.nextInt();
            board=new char[rows][columns];
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    board[i][j]=sc.next().charAt(0);
                }
            }
            System.out.println("Enter length of words array : ");
            int length=sc.nextInt();
            words=new String[length];
            for(int i=0;i<length;i++)
                words[i]=sc.useDelimiter("\n").next();
            System.out.println(new WordSearchII().findWords(board, words));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
