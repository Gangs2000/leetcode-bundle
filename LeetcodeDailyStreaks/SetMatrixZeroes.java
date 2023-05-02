package LeetcodeDailyStreaks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SetMatrixZeroes {
    List<Integer> visitedRows, visitedColumns;
    public SetMatrixZeroes(){
        visitedRows=new ArrayList<>();
        visitedColumns=new ArrayList<>();        
    }
    public void setZeroes(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    if(!visitedRows.contains(i))
                        visitedRows.add(i);                        
                    if(!visitedColumns.contains(j))
                        visitedColumns.add(j);                       
                }                
            }
        }                
        visitedRows.stream().forEach(row->setRowToZero(row, matrix[row].length, matrix));
        visitedColumns.stream().forEach(column->setColumnToZero(column, matrix.length, matrix));        
    }
    public void setRowToZero(int row, int length, int[][] matrix){
        for(int i=0;i<length;i++)            
            matrix[row][i]=0;
    }
    public void setColumnToZero(int column, int length, int[][] matrix){
        for(int i=0;i<length;i++)            
            matrix[i][column]=0;
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] matrix;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter M and N values : ");
            int m=sc.nextInt();
            int n=sc.nextInt();
            matrix=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j]=sc.nextInt();
                }
            }
            new SetMatrixZeroes().setZeroes(matrix);
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
