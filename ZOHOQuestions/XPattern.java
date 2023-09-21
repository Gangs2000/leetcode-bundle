package ZOHOQuestions;

import java.util.Scanner;
import java.util.Arrays;

public class XPattern {
    char[][] grid;
    public void drawPattern(String string){
        grid=new char[string.length()][string.length()];
        Arrays.stream(grid).forEach(array->Arrays.fill(array, ' '));
        int topLeft=0, leftPointer=0;
        int topRight=grid.length-1, bottomLeft=topRight, bottomRight=topRight, rightPointer=topRight;
        int middle=string.length()/2;
        for(int i=0;i<middle;i++){
            grid[topLeft][leftPointer]=string.charAt(leftPointer);
            grid[leftPointer][topRight]=string.charAt(rightPointer);
            grid[bottomLeft][leftPointer]=string.charAt(leftPointer);
            grid[bottomRight][rightPointer]=string.charAt(rightPointer);
            leftPointer++; rightPointer--;
            topLeft++; bottomLeft--;
            topRight--; bottomRight--;            
        }       
        grid[middle][middle]=string.charAt(leftPointer);
        //Printing pattern
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++)
                System.out.print(grid[i][j]);
            System.out.println();
        }
    }    
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter String value length must be odd : ");
            String string=sc.next().toUpperCase();
            new XPattern().drawPattern(string);
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
