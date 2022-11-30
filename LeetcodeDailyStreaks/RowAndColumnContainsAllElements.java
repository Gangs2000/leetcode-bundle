package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RowAndColumnContainsAllElements {
    boolean rowFlag,columnFlag;
    List<Integer> number;
    public RowAndColumnContainsAllElements(){
        rowFlag=true; columnFlag=true;
        number=new LinkedList<>();
    }
    public boolean checkValid(int[][] matrix) {
        return this.checkDuplicatesForEachRow(matrix, 0) && this.checkDuplicatesForEachColumn(matrix, 0);
    }
    public boolean checkDuplicatesForEachRow(int[][] matrix, int rowIndex){
        if(rowIndex<matrix.length){
            for(int i=0;i<matrix.length;i++){
                if(!this.checkIsValidElementAndNonRepeatable(matrix, rowIndex, i)){
                    rowFlag=false;
                    break;
                }
            }
            if(rowFlag){                
                number.clear();
                checkDuplicatesForEachRow(matrix, rowIndex+1);
            }
        }
        number.clear();
        return rowFlag;
    }
    public boolean checkDuplicatesForEachColumn(int[][] matrix, int columnIndex){
        if(columnIndex<matrix.length){
            for(int i=0;i<matrix.length;i++){
                if(!this.checkIsValidElementAndNonRepeatable(matrix, i, columnIndex)){
                    columnFlag=false;
                    break;
                }                
            }
            if(columnFlag){                
                number.clear();
                checkDuplicatesForEachColumn(matrix, columnIndex+1);
            }
        }
        number.clear();
        return columnFlag;
    }
    public boolean checkIsValidElementAndNonRepeatable(int[][] matrix, int i, int j){
        boolean flag=true;
        if((1<=matrix[i][j] && matrix[i][j]<=matrix.length) && !number.contains(matrix[i][j]))
            number.add(matrix[i][j]);
        else
            flag=false;
        return flag;
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] matrix;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter number of rows and columns : ");
            int length=sc.nextInt();
            matrix=new int[length][length];
            for(int i=0;i<length;i++)
                for(int j=0;j<length;j++)
                    matrix[i][j]=sc.nextInt();
            System.out.println(new RowAndColumnContainsAllElements().checkValid(matrix));
        }   
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
