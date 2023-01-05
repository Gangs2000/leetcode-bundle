package LeetcodeDailyStreaks;

import java.util.Scanner;

public class DeleteColumnsToMakeSorted {
    int deletedColumnsCount=0;
    public int minDeletionSize(String[] strs) {
        for(int i=0;i<strs[0].length();i++)
            traverseEachRow(0, i, strs);
        return deletedColumnsCount;
    }
    public void traverseEachRow(int row, int column, String[] strs){
        if(row!=strs.length-1){
            if(!((byte) strs[row].charAt(column) <= (byte) strs[row+1].charAt(column))){
                deletedColumnsCount++;
                return ;
            }
            traverseEachRow(row+1, column, strs);
        }        
    }
    public static void main(String[] args){
        Scanner sc;
        String[] strs;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of String array : ");
            int length=sc.nextInt();
            strs=new String[length];
            for(int i=0;i<strs.length;i++)
                strs[i]=sc.next();
            System.out.println(new DeleteColumnsToMakeSorted().minDeletionSize(strs));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
