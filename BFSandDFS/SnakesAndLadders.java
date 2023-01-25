import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SnakesAndLadders {
    Map<Integer, Integer> snakeOrLadder;
    List<List<Integer>> queue;   
    Set<Integer> visited; 
    public SnakesAndLadders(){
        snakeOrLadder=new LinkedHashMap<>();
        queue=new LinkedList<>();
        visited=new HashSet<>();
    }
    public int snakesAndLadders(int[][] board) {
        int numericValue=1; boolean flag=true;
        for(int i=board.length-1;i>=0;i--){
            if(flag){
                for(int j=0;j<=board.length-1;j++){
                    if(board[i][j]!=-1)
                        snakeOrLadder.put(numericValue, board[i][j]);
                    numericValue++;
                }
            }
            else{
                for(int j=board.length-1;j>=0;j--){
                    if(board[i][j]!=-1)
                        snakeOrLadder.put(numericValue, board[i][j]);
                    numericValue++;
                }
            }
            flag=(flag)?(false):(true);
        }
        queue.add(List.of(1,0));
        while(!queue.isEmpty()){
            int currentPosition=queue.get(0).get(0);
            int steps=queue.get(0).get(1);
            if(currentPosition==board.length*board.length)                
                return steps;
            breathFirstSearch(currentPosition, steps, board);   
            queue.remove(0);                                        
        }
        return -1;
    }    
    public void breathFirstSearch(int currentPosition, int steps, int[][] board){
        for(int i=1;i<=6;i++){     
            int nextSquare=currentPosition+i;   
            if(!visited.contains(nextSquare)){
                visited.add(nextSquare);
                if(snakeOrLadder.containsKey(nextSquare))
                    queue.add(List.of(snakeOrLadder.get(nextSquare), steps+1));                
                else
                    queue.add(List.of(nextSquare, steps+1));
            }
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] board;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter board size : ");
            int n=sc.nextInt();
            board=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    board[i][j]=sc.nextInt();
                }
            }
            System.out.println(new SnakesAndLadders().snakesAndLadders(board));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
