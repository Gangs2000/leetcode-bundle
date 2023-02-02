package MemoiDPAndBackTracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NQueens {
    List<List<String>> output;
    char[][] board;
    public NQueens(){
        output=new LinkedList<>();
    }
    public List<List<String>> solveNQueens(int n) {
        board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                board[i][j]='.';
        }
        placeQueensWithOutAttackingEachOther(0, board);
        return output;
    }
    public boolean isSafe(int row, int column, char[][] board){    
        int copyRow=row;
        int copyColumn=column;    
        //Upper diagonal checking
        while(row>=0 && column>=0){            
            if(board[row][column]=='Q')
                return false;
            row--;
            column--;
        }
        row=copyRow;
        column=copyColumn;
        //Lower diagonal checking
        while(row<=board.length-1 && column>=0){            
            if(board[row][column]=='Q')
                return false;
            row++;
            column--;
        }
        row=copyRow;
        column=copyColumn;
        //Left side checking
        while(column>=0){            
            if(board[row][column]=='Q')
                return false;
            column--;
        }
        return true;        
    }
    public void placeQueensWithOutAttackingEachOther(int column, char[][] board){
        if(column==board.length){
            List<String> list=new LinkedList<>();
            for(int i=0;i<board.length;i++){
                String string="";
                for(int j=0;j<board[i].length;j++)
                    string+=board[i][j];
                list.add(string);
            }
            output.add(list);
            return ;
        }
        for(int row=0;row<board.length;row++){
            if(isSafe(row, column, board)){
                board[row][column]='Q';
                placeQueensWithOutAttackingEachOther(column+1, board);
                board[row][column]='.';
            }
        }
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N Value : ");
            int n=sc.nextInt();
            System.out.println(new NQueens().solveNQueens(n));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
