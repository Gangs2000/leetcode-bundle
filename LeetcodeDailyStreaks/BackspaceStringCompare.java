package LeetcodeDailyStreaks;

import java.util.Scanner;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        return validateString(s).equals(validateString(t));
    }
    public String validateString(String string){
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<string.length();i++){
            if(string.charAt(i)=='#') {
                if(stringBuilder.length()!=0)
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
            else
                stringBuilder.append(string.charAt(i));
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S and T values : ");
            String s=sc.useDelimiter("\n").next();
            String t=sc.useDelimiter("\n").next();
            System.out.println(new BackspaceStringCompare().backspaceCompare(s, t));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
