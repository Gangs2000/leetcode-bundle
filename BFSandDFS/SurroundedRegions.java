import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SurroundedRegions {
    List<List<Integer>> queue, visited;
    boolean isRegionTouchedTheBorder=false;
    public SurroundedRegions(){
        queue=new LinkedList<>();
        visited=new LinkedList<>();
    }
    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='O' && i!=0 && j!=0 && i!=board.length-1 && j!=board[i].length-1){                    
                    board[i][j]='X';
                    queue.add(List.of(i,j));
                    visited.add(List.of(i,j));
                    while(!queue.isEmpty() && !isRegionTouchedTheBorder){
                        int row=queue.get(0).get(0);
                        int column=queue.get(0).get(1);
                        this.directions(row, column, board);                        
                        queue.remove(0);
                    }                                                 
                    //InValid Surrounded Regions
                    if(isRegionTouchedTheBorder){
                        visited.stream().forEach(list->{
                            int row=list.get(0);
                            int column=list.get(1);
                            board[row][column]='O';
                        });
                    }                                            
                    queue.clear(); visited.clear(); isRegionTouchedTheBorder=false;
                }
            }
        }                
    }        
    public void directions(int row, int column, char[][] board){    
        breathFirstSearch(row, column-1, board);        //Left         
        breathFirstSearch(row, column+1, board);        //Right        
        breathFirstSearch(row-1, column, board);        //Top
        breathFirstSearch(row+1, column, board);        //Bottom
    }
    public void breathFirstSearch(int row, int column, char[][] board){
        if(row>=0 && column>=0 && row<=board.length-1 && column<=board[row].length-1){
            if(board[row][column]=='O' && !visited.contains(List.of(row,column))){
                if(row!=0 && column!=0 && row!=board.length-1 && column!=board[row].length-1){     
                    board[row][column]='X';                       
                    queue.add(List.of(row,column));
                    visited.add(List.of(row,column));
                }
                else
                    isRegionTouchedTheBorder=true;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc;
        char[][] grid;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter M and N values : ");
            int m=sc.nextInt(); int n=sc.nextInt();
            grid=new char[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.next().charAt(0);                    
                }
            }
            new SurroundedRegions().solve(grid);
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
