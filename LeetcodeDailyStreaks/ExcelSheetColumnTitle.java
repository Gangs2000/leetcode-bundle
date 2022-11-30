package LeetcodeDailyStreaks;

import java.util.Scanner;

public class ExcelSheetColumnTitle {
    String columnTitle="";    
    byte byteValue=64;
    public String convertToTitle(int columnNumber){             
        if(columnNumber>26){
            columnTitle+=(char) (byteValue+((columnNumber%26==0)?(26):(columnNumber%26)));                                                
            columnNumber=(columnNumber%26==0)?((columnNumber/26)-1):(columnNumber/26);                                           
            convertToTitle(columnNumber);          
        }
        else
            columnTitle+=(char) (byteValue+columnNumber);                           
        return new StringBuilder(columnTitle).reverse().toString();
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter column number to return it's title as it is in excel sheet : ");
            int columnNumber=sc.nextInt();
            System.out.println(new ExcelSheetColumnTitle().convertToTitle(columnNumber));
        }
        catch(Exception e){
            System.out.println("Exception occured :"+e.getMessage());
            e.printStackTrace();
        }
    }
}
