import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueensThatCanAttackKing {
    List<List<Integer>> coOrdinates;
    char[][] board;
    public QueensThatCanAttackKing(){
        coOrdinates=new LinkedList<>();
        board=new char[8][8];
    }
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {         
        Arrays.stream(board).forEach(row->Arrays.fill(row, '.'));                               
        //Assigning kings in the board
        board[king[0]][king[1]]='K';
        //Assigning queens in the board
        for(int i=0;i<queens.length;i++)
            board[queens[i][0]][queens[i][1]]='Q';  
        validateAllPaths(king[0], king[1], board);                   
        return coOrdinates;
    }
    public void validateAllPaths(int i, int j, char[][] board){
        int row=i, col=j;
        //Left
        while(j>=0){
            if(board[i][j]=='Q'){
                coOrdinates.add(List.of(i,j));
                break;
            }
            j--;
        }
        //Right
        i=row; j=col;
        while(j<=7){
            if(board[i][j]=='Q'){
                coOrdinates.add(List.of(i,j));
                break;
            }
            j++;
        }
        //Top
        i=row; j=col;
        while(i>=0){
            if(board[i][j]=='Q'){
                coOrdinates.add(List.of(i,j));
                break;
            }
            i--;
        }
        //Bottom
        i=row; j=col;
        while(i<=7){
            if(board[i][j]=='Q'){
                coOrdinates.add(List.of(i,j));
                break;
            }
            i++;
        }
        //Top-left
        i=row; j=col;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q'){
                coOrdinates.add(List.of(i,j));
                break;
            }
            i--; j--;
        }
        //Top-right
        i=row; j=col;
        while(i>=0 && j<=7){
            if(board[i][j]=='Q'){
                coOrdinates.add(List.of(i,j));
                break;
            }
            i--; j++;
        }
        //Bottom-left
        i=row; j=col;
        while(i<=7 && j>=0){
            if(board[i][j]=='Q'){
                coOrdinates.add(List.of(i,j));
                break;
            }
            i++; j--;
        }
        //Bottom-right
        i=row; j=col;
        while(i<=7 && j<=7){
            if(board[i][j]=='Q'){
                coOrdinates.add(List.of(i,j));
                break;
            }
            i++; j++;
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] queens;
        int[] kings;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of queens array : ");
            int length=sc.nextInt();
            queens=new int[length][2];
            kings=new int[2];
            for(int i=0;i<length;i++){
                queens[i][0]=sc.nextInt();
                queens[i][1]=sc.nextInt();
            }
            System.out.println("Enter kings co-ordinate in 2D array : ");
            kings[0]=sc.nextInt(); kings[1]=sc.nextInt();
            System.out.println(new QueensThatCanAttackKing().queensAttacktheKing(queens, kings));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
