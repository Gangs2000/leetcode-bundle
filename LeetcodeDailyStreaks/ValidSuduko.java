package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;

public class ValidSuduko {
    boolean flag1,flag2,flag3;
    int rowStartingIndex=0, rowEndingIndex=2, columnStartingIndex=0, columnEndingIndex=2;           //Setting initial board index
    List<Character> numbers;
    public ValidSuduko(){
        flag1=true; flag2=true; flag3=true;
        numbers=new LinkedList<>();
    }
    public boolean isValidSudoku(char[][] board) {        
        return this.checkForSubGridRepetition(board) && this.checkForRowRepetition(board, 0) && this.checkForColumnRepetition(board, 0);
    }
    public boolean checkForRowRepetition(char[][] board, int rowIndex){        
        if(flag1 && rowIndex<=8){
            for(int i=0;i<board.length;i++){         
                if(!this.checkForRepetitionInBoard(board, rowIndex, i)){
                    flag1=false;
                    break;
                }
            }
            if(flag1){
                numbers.clear();
                checkForRowRepetition(board, rowIndex+1);
            }
        }
        numbers.clear();
        return flag1;
    }
    public boolean checkForColumnRepetition(char[][] board, int columnIndex){
        if(flag2 && columnIndex<=8){
            for(int i=0;i<board.length;i++){
                if(!this.checkForRepetitionInBoard(board, i, columnIndex)){
                    flag2=false;
                    break;
                }
            }
            if(flag2){
                numbers.clear();
                checkForColumnRepetition(board, columnIndex+1);
            }
        }
        numbers.clear();
        return flag2;
    }
    public boolean checkForSubGridRepetition(char[][] board){      
        if(flag3 && rowEndingIndex<=8){            
            for(int i=rowStartingIndex;i<=rowEndingIndex;i++){
                for(int j=columnStartingIndex;j<=columnEndingIndex;j++){
                    if(!this.checkForRepetitionInBoard(board, i, j)){
                        flag3=false;
                        break;
                    }
                }                  
            }
            if(flag3){                
                numbers.clear();
                if(columnEndingIndex!=8){
                    columnStartingIndex=columnEndingIndex+1;
                    columnEndingIndex=columnEndingIndex+3;
                }
                else if(columnEndingIndex==8){
                    rowStartingIndex=rowEndingIndex+1;
                    rowEndingIndex=rowEndingIndex+3;
                    columnStartingIndex=0; columnEndingIndex=2;
                }                                
                checkForSubGridRepetition(board);                
            }
        }  
        numbers.clear();
        return flag3;        
    }
    public boolean checkForRepetitionInBoard(char[][] board, int i, int j){
        boolean flag=true;
        if(board[i][j]!='.' && !numbers.contains(board[i][j]))
            numbers.add(board[i][j]);
        else if(board[i][j]!='.')
            flag=false;
        return flag;                  
    }
    public static void main(String[] args){                
        try{            
            char[][] board=new char[][]{
                {'5','3','.','.','7','.','.','.','.'}
                ,{'8','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
            };
            System.out.println(new ValidSuduko().isValidSudoku(board));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
